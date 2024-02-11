package org.fhirpath.dictionaries.framework;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

public abstract class AbstractDefinitions<Base> implements Definitions<Base> {

    protected final Map<String, Function<Base, Object>> definitions;

    public AbstractDefinitions() {
        this.definitions = new HashMap<>();
    }

    @Override
    public Map<String, Function<Base, Object>> getDefinitions() {
        if (this.definitions.isEmpty()) {
            this.initialize();
        }
        return definitions;
    }

    protected abstract void initialize();
}
