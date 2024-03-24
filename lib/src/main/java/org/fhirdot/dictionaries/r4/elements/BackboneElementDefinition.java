package org.fhirdot.dictionaries.r4.elements;

import org.fhirdot.dictionaries.framework.AbstractDefinition;
import org.hl7.fhir.r4.model.BackboneElement;
import org.hl7.fhir.r4.model.Base;

public class BackboneElementDefinition extends AbstractDefinition<Base, BackboneElement> {
    @Override
    protected void initialize() {
        this.putAllPaths(new ElementDefinition().getPaths());
        this.putPath("modifierExtension", BackboneElement::getModifierExtension);
    }

    @Override
    public String getName() {
        return "BackboneElement";
    }
}
