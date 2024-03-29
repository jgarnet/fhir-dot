package org.fhirdot.readers;

import org.fhirdot.cache.InMemoryNodeCache;

import java.util.ArrayList;
import java.util.List;

public class TestNodeCache extends InMemoryNodeCache {
    private final List<String> cacheKeys;

    public TestNodeCache() {
        this.cacheKeys = new ArrayList<>();
    }

    public List<String> getCacheKeys() {
        return cacheKeys;
    }

    @Override
    public <Base, Result> void put(Base base, String path, Result result) {
        this.cacheKeys.add(path);
        super.put(base, path, result);
    }
}
