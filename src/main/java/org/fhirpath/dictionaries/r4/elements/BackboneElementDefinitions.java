package org.fhirpath.dictionaries.r4.elements;

import org.fhirpath.dictionaries.framework.AbstractDefinitions;
import org.hl7.fhir.r4.model.BackboneElement;
import org.hl7.fhir.r4.model.Base;

public class BackboneElementDefinitions extends AbstractDefinitions<Base> {
    @Override
    protected void initialize() {
        this.definitions.putAll(new ElementDefinitions().getDefinitions());
        this.definitions.put("modifierExtension", arg -> ((BackboneElement) arg).getModifierExtension());
    }

    @Override
    public String getName() {
        return "BackboneElement";
    }
}
