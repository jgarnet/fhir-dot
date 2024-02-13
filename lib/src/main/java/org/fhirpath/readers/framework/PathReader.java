package org.fhirpath.readers.framework;

import org.fhirpath.exceptions.FhirPathException;
import org.fhirpath.framework.Rules;

public interface PathReader {
    Rules getRules();
    <Base, Result> Result read(Base base, String path) throws FhirPathException;
}
