package org.fhirpath.dictionaries.framework;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.ClassPathScanningCandidateComponentProvider;
import org.springframework.core.type.filter.AssignableTypeFilter;
import org.springframework.util.ClassUtils;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.function.Function;

@SuppressWarnings("unchecked")
public abstract class AbstractFhirDictionary<Base> implements FhirDictionary<Base> {
    private final Logger log = LogManager.getLogger(this);
    private final Map<String, Map<String, Function<Base, Object>>> definitions;

    public AbstractFhirDictionary() {
        this.definitions = new HashMap<>();
    }

    @Override
    public Map<String, Map<String, Function<Base, Object>>> getDefinitions() {
        if (this.definitions.isEmpty()) {
            this.initialize();
        }
        return this.definitions;
    }

    private void initialize() {
        ClassPathScanningCandidateComponentProvider provider = new ClassPathScanningCandidateComponentProvider(false);
        provider.addIncludeFilter(new AssignableTypeFilter(Definitions.class));
        Set<BeanDefinition> beanDefinitions = provider.findCandidateComponents(this.getPackage());
        for (BeanDefinition beanDefinition : beanDefinitions) {
            if (beanDefinition.getBeanClassName() != null) {
                Class<?> dictionaryClass = ClassUtils.resolveClassName(
                        beanDefinition.getBeanClassName(),
                        ClassUtils.getDefaultClassLoader()
                );
                try {
                    Definitions<Base> definitions = (Definitions<Base>) dictionaryClass.newInstance();
                    this.definitions.put(definitions.getName(), definitions.getDefinitions());
                } catch (InstantiationException | IllegalAccessException e) {
                    this.log.error(e);
                }
            }
        }
    }

    protected abstract String getPackage();
}
