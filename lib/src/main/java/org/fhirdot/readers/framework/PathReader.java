package org.fhirdot.readers.framework;

import org.fhirdot.exceptions.FhirDotException;
import org.fhirdot.framework.Rules;

/**
 * Evaluates paths against FHIR structures leveraging a dot-notation-like syntax
 */
public interface PathReader {
    /**
     * Provides an instance of global Rules used for configuration
     * @return Rules used for configuration
     */
    Rules getRules();

    /**
     * Evaluates a path against a Base FHIR structure to retrieve some desired value
     * @param base The Base FHIR structure being evaluated
     * @param path The path being evaluated
     * @param <Base> The Base FHIR structure class
     * @param <Result> Generic result class
     * @return Computed result from evaluating a path against a FHIR structure
     * @throws FhirDotException When errors occur reading the path
     */
    <Base, Result> Result read(Base base, String path) throws FhirDotException;
}
