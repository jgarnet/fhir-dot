package org.fhirdot.cache.framework;

/**
 * Provides ability to cache Node results for a given structure to avoid duplicate path evaluations
 */
public interface NodeCache {
    /**
     * Retrieves the cached result of a Node evaluation on a structure
     * @param base The structure being evaluated
     * @param path The path being evaluated on the supplied structure
     * @param <Base> Generic structure type
     * @param <Result> Generic result type
     * @return Cached result if present
     */
    <Base, Result> Result get(Base base, String path);

    /**
     * Puts a computed result into the cache
     * @param base The base structure being evaluated
     * @param path The path being evaluated on the supplied structure
     * @param result The resulting Object computed during Node evaluation
     * @param <Base> Generic structure type
     * @param <Result> Generic result type
     */
    <Base, Result> void put(Base base, String path, Result result);

    /**
     * Returns cache entry size
     * @return Cache entry size
     */
    int size();
}
