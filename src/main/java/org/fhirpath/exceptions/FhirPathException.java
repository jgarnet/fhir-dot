package org.fhirpath.exceptions;

public class FhirPathException extends Exception {
    private Exception wrapped;
    public FhirPathException(Exception e) {
        super();
        this.wrapped = e;
    }

    public FhirPathException(String message) {
        super(message);
    }

    public Exception getWrapped() {
        return this.wrapped;
    }
}
