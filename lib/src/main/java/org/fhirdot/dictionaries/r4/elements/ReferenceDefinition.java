package org.fhirdot.dictionaries.r4.elements;

import org.fhirdot.dictionaries.framework.AbstractDefinition;
import org.hl7.fhir.r4.model.Base;
import org.hl7.fhir.r4.model.BaseReference;
import org.hl7.fhir.r4.model.Reference;

public class ReferenceDefinition extends AbstractDefinition<Base, Reference> {
    @Override
    protected void initialize() {
        this.putAllPaths(new ElementDefinition().getPaths());
        // reference
        this.putPath("reference", Reference::getReferenceElement_);
        // type
        this.putPath("type", Reference::getTypeElement);
        // identifier
        this.putPath("identifier", Reference::getIdentifier);
        // display
        this.putPath("display", Reference::getDisplayElement);
        // resource
        this.putPath("resource", BaseReference::getResource);
    }

    @Override
    public String getName() {
        return "Reference";
    }
}
