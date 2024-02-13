package org.fhirpath.dictionaries.framework;

import java.util.Map;
import java.util.function.Function;

public interface Dictionary<Base> {
    /**
     * Defines all Resource, Element, and Type definitions for a given FHIR specification.
     */
    Map<String, Map<String, Function<Base, Object>>> getDefinitions();

    /**
     * Retrieves the definitions for a given FHIR data structure.
     */
    default Map<String, Function<Base, Object>> getBaseDefinitions(Base base) {
        if (base == null) {
            return null;
        }
        String baseClass = base.getClass().toString();
        int lastDot = baseClass.lastIndexOf(".");
        return this.getDefinitions().get(baseClass.substring(lastDot + 1));
    }

    Class<Base> getBaseClass();
}
