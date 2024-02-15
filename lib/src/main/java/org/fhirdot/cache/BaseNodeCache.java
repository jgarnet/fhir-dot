package org.fhirdot.cache;

import org.fhirdot.cache.framework.NodeCache;

import java.util.HashMap;
import java.util.Map;

public class BaseNodeCache implements NodeCache {

    private final Map<Integer, Map<String, Object>> cache;

    public BaseNodeCache() {
        this.cache = new HashMap<>();
    }

    @Override
    @SuppressWarnings("unchecked")
    public <Base, Result> Result get(Base base, String path) {
        return (Result) this.getInternalCache(base).get(path);
    }

    @Override
    public <Base, Result> void put(Base base, String path, Result result) {
        this.getInternalCache(base).put(path, result);
    }

    private <Base> Map<String, Object> getInternalCache(Base base) {
        return this.cache.computeIfAbsent(base.hashCode(), k -> new HashMap<>());
    }

    @Override
    public int size() {
        return this.cache.size();
    }
}
