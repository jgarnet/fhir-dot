package org.fhirpath.dictionaries.r4.resources;

import org.fhirpath.dictionaries.framework.AbstractDefinitions;
import org.hl7.fhir.r4.model.Base;
import org.hl7.fhir.r4.model.DomainResource;

public class DomainResourceDefinitions extends AbstractDefinitions<Base> {
    @Override
    protected void initialize() {
        this.definitions.putAll(new ResourceDefinitions().getDefinitions());
        // text
        this.definitions.put("text", arg -> ((DomainResource) arg).getText());
        // contained
        this.definitions.put("contained", arg -> ((DomainResource) arg).getContained());
        // extension
        this.definitions.put("extension", arg -> ((DomainResource) arg).getExtension());
        // modifierExtension
        this.definitions.put("modifierExtension", arg -> ((DomainResource) arg).getModifierExtension());
    }

    @Override
    public String getName() {
        return "DomainResource";
    }
}
