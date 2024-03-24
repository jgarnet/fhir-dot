package org.fhirdot.dictionaries.framework;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

public abstract class AbstractDefinition<Base, Structure extends Base> implements Definition<Base> {

    private final Map<String, Function<Base, Object>> paths;

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

    @SuppressWarnings("unchecked")
    protected void putPath(String path, Function<Structure, Object> pathFunction) {
        this.paths.put(path, (Function<Base, Object>) pathFunction);
    }

    protected void putAllPaths(Map<String, Function<Base, Object>> paths) {
        this.paths.putAll(paths);
    }

    protected abstract void initialize();
}
