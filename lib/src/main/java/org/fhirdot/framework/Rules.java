package org.fhirdot.framework;

/**
 * Helper class used to provide global configuration values
 */
public class Rules {
    /**
     * Format used to parse and format Date values during operations
     */
    private String dateFormat;
    /**
     * Determines whether PrimitiveType values should be unwrapped from FHIR structures when evaluating paths
     */
    private boolean unwrapPrimitives;

    public String getDateFormat() {
        return dateFormat;
    }

    public Rules setDateFormat(String dateFormat) {
        this.dateFormat = dateFormat;
        return this;
    }

    public boolean shouldUnwrapPrimitives() {
        return unwrapPrimitives;
    }

    public Rules setUnwrapPrimitives(boolean unwrapPrimitives) {
        this.unwrapPrimitives = unwrapPrimitives;
        return this;
    }
}
