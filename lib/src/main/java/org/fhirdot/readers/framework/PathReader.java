package org.fhirdot.readers.framework;

import org.fhirdot.exceptions.FhirDotException;
import org.fhirdot.framework.Rules;

public interface PathReader {
    Rules getRules();
    <Base, Result> Result read(Base base, String path) throws FhirDotException;
}
