package org.fhirdot.exceptions;

public class FhirDotException extends Exception {
    private Exception wrapped;
    public FhirDotException(Exception e) {
        super();
        this.wrapped = e;
    }

    public FhirDotException(String message) {
        super(message);
    }

    public Exception getWrapped() {
        return this.wrapped;
    }
}
