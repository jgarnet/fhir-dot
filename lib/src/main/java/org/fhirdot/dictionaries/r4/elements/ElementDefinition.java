package org.fhirdot.dictionaries.r4.elements;

import org.fhirdot.dictionaries.framework.AbstractDefinition;
import org.hl7.fhir.r4.model.Base;
import org.hl7.fhir.r4.model.Element;

public class ElementDefinition extends AbstractDefinition<Base, Element> {
    @Override
    protected void initialize() {
        // id
        this.putPath("id", Element::getIdElement);
        // extension
        this.putPath("extension", Element::getExtension);
    }

    @Override
    public String getName() {
        return "Element";
    }
}
