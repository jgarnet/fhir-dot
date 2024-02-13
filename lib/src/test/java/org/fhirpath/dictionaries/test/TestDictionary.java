package org.fhirpath.dictionaries.test;

import org.fhirpath.dictionaries.framework.AbstractFhirDictionary;
import org.hl7.fhir.r4.model.Base;

public class TestDictionary extends AbstractFhirDictionary<Base> {
    @Override
    protected String getPackage() {
        return "org.fhirpath.dictionaries.test";
    }
}
