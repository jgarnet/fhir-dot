package org.fhirpath.dictionaries.framework;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.fhirpath.exceptions.FhirPathException;
import org.springframework.beans.factory.annotation.AnnotatedBeanDefinition;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.ClassPathScanningCandidateComponentProvider;
import org.springframework.core.type.filter.AnnotationTypeFilter;
import org.springframework.util.ClassUtils;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

@SuppressWarnings("rawtypes")
public class FhirDictionaryFactory {

    private final Map<Class<?>, FhirDictionary> dictionaries;
    private final Map<Class<?>, FhirDictionary> cache;
    private final Logger log = LogManager.getLogger(this);

    public FhirDictionaryFactory() {
        this.dictionaries = new HashMap<>();
        this.cache = new HashMap<>();
        this.scanForDictionaries();
    }

    private void scanForDictionaries() {
        // scan for classes annotated with @Dictionary
        ClassPathScanningCandidateComponentProvider provider = new ClassPathScanningCandidateComponentProvider(false);
        provider.addIncludeFilter(new AnnotationTypeFilter(Dictionary.class));
        // search in dictionaries package
        Set<BeanDefinition> beanDefinitions = provider.findCandidateComponents("org.fhirpath.dictionaries");
        for (BeanDefinition beanDefinition : beanDefinitions) {
            if (beanDefinition instanceof AnnotatedBeanDefinition) {
                Map<String, Object> attributes = ((AnnotatedBeanDefinition) beanDefinition)
                        .getMetadata()
                        .getAnnotationAttributes(Dictionary.class.getCanonicalName());
                // ensure beanClass, attributes are populated
                if (attributes != null && beanDefinition.getBeanClassName() != null) {
                    Class<?> baseClass = (Class<?>) attributes.get("baseClass");
                    // ensure baseClass attribute is defined
                    if (baseClass != null) {
                        // instantiate class instance and register in internal dictionaries
                        Class<?> dictionaryClass = ClassUtils.resolveClassName(
                                beanDefinition.getBeanClassName(),
                                ClassUtils.getDefaultClassLoader()
                        );
                        try {
                            FhirDictionary instance = (FhirDictionary) dictionaryClass.newInstance();
                            this.dictionaries.put(baseClass, instance);
                        } catch (InstantiationException | IllegalAccessException e) {
                            this.log.error(e);
                        }
                    }
                }
            }
        }
    }

    public <Base> FhirDictionary getDictionary(Base base) throws FhirPathException {
        if (base == null) {
            throw new FhirPathException("FHIR structure is null");
        }
        Class<?> baseClass = base.getClass();
        if (this.cache.containsKey(baseClass)) {
            return this.cache.get(baseClass);
        }
        for (Map.Entry<Class<?>, FhirDictionary> entry : this.dictionaries.entrySet()) {
            if (entry.getKey().isInstance(base)) {
                this.cache.put(baseClass, entry.getValue());
                return entry.getValue();
            }
        }
        throw new FhirPathException(String.format("Failed to find FHIR dictionary for %s", baseClass.toString()));
    }

}
