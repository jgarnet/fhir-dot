package org.fhirdot.dictionaries.framework;

import java.util.Map;
import java.util.function.Function;

/**
 * Provides Definition name for a given Dictionary entry and paths which can be evaluated against a FHIR structure.
 * @param <Base> The Base class implementation which will be used to evaluate paths against
 */
public interface Definition<Base> {
    /**
     * Returns the name of the Definition in the Dictionary
     * @return String definition name
     */
    String getName();

    /**
     * Returns a Map containing all path Functions used to read a FHIR structure
     * @return Map containing FHIR structure paths
     */
    Map<String, Function<Base, Object>> getPaths();
}
