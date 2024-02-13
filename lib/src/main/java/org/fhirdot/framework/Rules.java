package org.fhirdot.framework;

public class Rules {
    private String dateFormat;
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
