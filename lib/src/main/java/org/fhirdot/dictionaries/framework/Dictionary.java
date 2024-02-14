package org.fhirdot.dictionaries.framework;

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
    default Map<String, Function<Base, Object>> getPaths(Base base) {
        if (base == null) {
            return null;
        }
        String baseClass = base.getClass().toString();
        int lastDot = baseClass.lastIndexOf(".");
        return this.getDefinitions().get(baseClass.substring(lastDot + 1));
    }

    /**
     * Defines the Base FHIR structure which all structures must extend in the Dictionary
     * @return Class definition for Base FHIR structures in the Dictionary
     */
    Class<Base> getBaseClass();
}
