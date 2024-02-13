package org.fhirpath.dictionaries.r4.elements;

import org.fhirpath.dictionaries.framework.AbstractDefinitions;
import org.hl7.fhir.r4.model.Base;
import org.hl7.fhir.r4.model.Element;

public class ElementDefinitions extends AbstractDefinitions<Base> {
    @Override
    protected void initialize() {
        // id
        this.definitions.put("id", arg -> ((Element) arg).getIdElement());
        // extension
        this.definitions.put("extension", arg -> ((Element) arg).getExtension());
    }

    @Override
    public String getName() {
        return "Element";
    }
}
