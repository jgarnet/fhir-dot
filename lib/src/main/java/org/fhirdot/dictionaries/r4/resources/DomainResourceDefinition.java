package org.fhirdot.dictionaries.r4.resources;

import org.fhirdot.dictionaries.framework.AbstractDefinition;
import org.hl7.fhir.r4.model.Base;
import org.hl7.fhir.r4.model.DomainResource;

public class DomainResourceDefinition extends AbstractDefinition<Base, DomainResource> {
    @Override
    protected void initialize() {
        this.putAllPaths(new ResourceDefinition().getPaths());
        // text
        this.putPath("text", DomainResource::getText);
        // contained
        this.putPath("contained", DomainResource::getContained);
        // extension
        this.putPath("extension", DomainResource::getExtension);
        // modifierExtension
        this.putPath("modifierExtension", DomainResource::getModifierExtension);
    }

    @Override
    public String getName() {
        return "DomainResource";
    }
}
