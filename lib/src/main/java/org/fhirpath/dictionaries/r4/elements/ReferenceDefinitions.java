package org.fhirpath.dictionaries.r4.elements;

import org.fhirpath.dictionaries.framework.AbstractDefinitions;
import org.hl7.fhir.r4.model.Base;
import org.hl7.fhir.r4.model.Reference;

public class ReferenceDefinitions extends AbstractDefinitions<Base> {
    @Override
    protected void initialize() {
        this.definitions.putAll(new ElementDefinitions().getDefinitions());
        // reference
        this.definitions.put("reference", arg -> ((Reference) arg).getReferenceElement_());
        // type
        this.definitions.put("type", arg -> ((Reference) arg).getTypeElement());
        // identifier
        this.definitions.put("identifier", arg -> ((Reference) arg).getIdentifier());
        // display
        this.definitions.put("display", arg -> ((Reference) arg).getDisplayElement());
        // resource
        this.definitions.put("resource", arg -> ((Reference) arg).getResource());
    }

    @Override
    public String getName() {
        return "Reference";
    }
}
