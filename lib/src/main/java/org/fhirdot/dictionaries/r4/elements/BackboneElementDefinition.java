package org.fhirdot.dictionaries.r4.elements;

import org.fhirdot.dictionaries.framework.AbstractDefinition;
import org.hl7.fhir.r4.model.BackboneElement;
import org.hl7.fhir.r4.model.Base;

public class BackboneElementDefinition extends AbstractDefinition<Base> {
    @Override
    protected void initialize() {
        this.paths.putAll(new ElementDefinition().getPaths());
        this.paths.put("modifierExtension", arg -> ((BackboneElement) arg).getModifierExtension());
    }

    @Override
    public String getName() {
        return "BackboneElement";
    }
}
