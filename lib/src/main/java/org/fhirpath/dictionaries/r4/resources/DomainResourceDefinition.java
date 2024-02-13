package org.fhirpath.dictionaries.r4.resources;

import org.fhirpath.dictionaries.framework.AbstractDefinition;
import org.hl7.fhir.r4.model.Base;
import org.hl7.fhir.r4.model.DomainResource;

public class DomainResourceDefinition extends AbstractDefinition<Base> {
    @Override
    protected void initialize() {
        this.paths.putAll(new ResourceDefinition().getPaths());
        // text
        this.paths.put("text", arg -> ((DomainResource) arg).getText());
        // contained
        this.paths.put("contained", arg -> ((DomainResource) arg).getContained());
        // extension
        this.paths.put("extension", arg -> ((DomainResource) arg).getExtension());
        // modifierExtension
        this.paths.put("modifierExtension", arg -> ((DomainResource) arg).getModifierExtension());
    }

    @Override
    public String getName() {
        return "DomainResource";
    }
}
