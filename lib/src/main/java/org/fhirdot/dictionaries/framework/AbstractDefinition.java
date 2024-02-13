package org.fhirdot.dictionaries.framework;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

public abstract class AbstractDefinition<Base> implements Definition<Base> {

    protected final Map<String, Function<Base, Object>> paths;

    public AbstractDefinition() {
        this.paths = new HashMap<>();
    }

    @Override
    public Map<String, Function<Base, Object>> getPaths() {
        if (this.paths.isEmpty()) {
            this.initialize();
        }
        return paths;
    }

    protected abstract void initialize();
}
