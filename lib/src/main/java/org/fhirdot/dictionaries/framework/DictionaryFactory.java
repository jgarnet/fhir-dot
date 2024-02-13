package org.fhirdot.dictionaries.framework;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.fhirdot.exceptions.FhirDotException;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.ClassPathScanningCandidateComponentProvider;
import org.springframework.core.type.filter.AssignableTypeFilter;
import org.springframework.util.ClassUtils;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

@SuppressWarnings("rawtypes")
public class DictionaryFactory {

    private final Map<Class<?>, Dictionary> dictionaries;
    private final Map<Class<?>, Dictionary> cache;
    private final Logger log = LogManager.getLogger(this);

    public DictionaryFactory() {
        this.dictionaries = new HashMap<>();
        this.cache = new HashMap<>();
        this.scanForDictionaries();
    }

    private void scanForDictionaries() {
        // scan for classes that implement Dictionary
        ClassPathScanningCandidateComponentProvider provider = new ClassPathScanningCandidateComponentProvider(false);
        provider.addIncludeFilter(new AssignableTypeFilter(Dictionary.class));
        // search in dictionaries package
        Set<BeanDefinition> beanDefinitions = provider.findCandidateComponents("org.fhirdot.dictionaries");
        for (BeanDefinition beanDefinition : beanDefinitions) {
            if (beanDefinition.getBeanClassName() != null) {
                // instantiate class instance and register in internal dictionaries
                Class<?> dictionaryClass = ClassUtils.resolveClassName(
                        beanDefinition.getBeanClassName(),
                        ClassUtils.getDefaultClassLoader()
                );
                try {
                    Dictionary instance = (Dictionary) dictionaryClass.newInstance();
                    Class<?> baseClass = (Class<?>) instance.getBaseClass();
                    this.dictionaries.put(baseClass, instance);
                } catch (InstantiationException | IllegalAccessException e) {
                    this.log.error(e);
                }
            }
        }
    }

    public <Base> Dictionary getDictionary(Base base) throws FhirDotException {
        if (base == null) {
            throw new FhirDotException("FHIR structure is null");
        }
        Class<?> baseClass = base.getClass();
        if (this.cache.containsKey(baseClass)) {
            return this.cache.get(baseClass);
        }
        for (Map.Entry<Class<?>, Dictionary> entry : this.dictionaries.entrySet()) {
            if (entry.getKey().isInstance(base)) {
                this.cache.put(baseClass, entry.getValue());
                return entry.getValue();
            }
        }
        throw new FhirDotException(String.format("Failed to find FHIR dictionary for %s", baseClass.toString()));
    }

}
