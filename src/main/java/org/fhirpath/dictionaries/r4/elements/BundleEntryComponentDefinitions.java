package org.fhirpath.dictionaries.r4.elements;

import org.fhirpath.dictionaries.framework.AbstractDefinitions;
import org.hl7.fhir.r4.model.Base;
import org.hl7.fhir.r4.model.Bundle;

public class BundleEntryComponentDefinitions extends AbstractDefinitions<Base> {
    @Override
    protected void initialize() {
        this.definitions.putAll(new BackboneElementDefinitions().getDefinitions());
        // resource
        this.definitions.put("resource", arg -> ((Bundle.BundleEntryComponent) arg).getResource());
    }

    @Override
    public String getName() {
        return "Bundle$BundleEntryComponent";
    }
}
