package org.fhirdot.dictionaries.framework;

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
public abstract class AbstractDictionary<Base> implements Dictionary<Base> {
    private final Logger log = LogManager.getLogger(this);
    private final Map<String, Map<String, Function<Base, Object>>> definitions;

    public AbstractDictionary() {
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
        provider.addIncludeFilter(new AssignableTypeFilter(Definition.class));
        Set<BeanDefinition> beanDefinitions = provider.findCandidateComponents(this.getPackage());
        for (BeanDefinition beanDefinition : beanDefinitions) {
            if (beanDefinition.getBeanClassName() != null) {
                Class<?> dictionaryClass = ClassUtils.resolveClassName(
                        beanDefinition.getBeanClassName(),
                        ClassUtils.getDefaultClassLoader()
                );
                try {
                    Definition<Base> definitions = (Definition<Base>) dictionaryClass.newInstance();
                    this.definitions.put(definitions.getName(), definitions.getPaths());
                } catch (InstantiationException | IllegalAccessException e) {
                    this.log.error(e);
                }
            }
        }
    }

    protected abstract String getPackage();
}
