package org.fhirpath.dictionaries.r4.elements;

import org.fhirpath.dictionaries.framework.AbstractDefinition;
import org.hl7.fhir.r4.model.Base;
import org.hl7.fhir.r4.model.Reference;

public class ReferenceDefinition extends AbstractDefinition<Base> {
    @Override
    protected void initialize() {
        this.paths.putAll(new ElementDefinition().getPaths());
        // reference
        this.paths.put("reference", arg -> ((Reference) arg).getReferenceElement_());
        // type
        this.paths.put("type", arg -> ((Reference) arg).getTypeElement());
        // identifier
        this.paths.put("identifier", arg -> ((Reference) arg).getIdentifier());
        // display
        this.paths.put("display", arg -> ((Reference) arg).getDisplayElement());
        // resource
        this.paths.put("resource", arg -> ((Reference) arg).getResource());
    }

    @Override
    public String getName() {
        return "Reference";
    }
}
