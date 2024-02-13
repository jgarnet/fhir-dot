package org.fhirpath.dictionaries.r4;

import org.fhirpath.dictionaries.framework.AbstractFhirDictionary;
import org.fhirpath.dictionaries.framework.Dictionary;
import org.hl7.fhir.r4.model.Base;

@Dictionary(baseClass = Base.class)
public class R4FhirDictionary extends AbstractFhirDictionary<Base> {
    @Override
    protected String getPackage() {
        return "org.fhirpath.dictionaries.r4";
    }
}
