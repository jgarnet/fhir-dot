package org.fhirdot.cache;

import org.apache.commons.collections4.map.LRUMap;

import java.util.Map;

public class LruInMemoryNodeCache extends InMemoryNodeCache {
    private final LRUMap<Integer, Map<String, Object>> lruMap;

    public LruInMemoryNodeCache() {
        this.lruMap = new LRUMap<>(1000);
    }

    @Override
    protected Map<Integer, Map<String, Object>> getCache() {
        return this.lruMap;
    }
}
