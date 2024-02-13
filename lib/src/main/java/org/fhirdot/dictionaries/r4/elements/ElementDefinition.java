package org.fhirdot.dictionaries.r4.elements;

import org.fhirdot.dictionaries.framework.AbstractDefinition;
import org.hl7.fhir.r4.model.Base;
import org.hl7.fhir.r4.model.Element;

public class ElementDefinition extends AbstractDefinition<Base> {
    @Override
    protected void initialize() {
        // id
        this.paths.put("id", arg -> ((Element) arg).getIdElement());
        // extension
        this.paths.put("extension", arg -> ((Element) arg).getExtension());
    }

    @Override
    public String getName() {
        return "Element";
    }
}
