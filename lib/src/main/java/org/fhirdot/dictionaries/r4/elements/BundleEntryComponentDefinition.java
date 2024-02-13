package org.fhirdot.dictionaries.r4.elements;

import org.fhirdot.dictionaries.framework.AbstractDefinition;
import org.hl7.fhir.r4.model.Base;
import org.hl7.fhir.r4.model.Bundle;

public class BundleEntryComponentDefinition extends AbstractDefinition<Base> {
    @Override
    protected void initialize() {
        this.paths.putAll(new BackboneElementDefinition().getPaths());
        // resource
        this.paths.put("resource", arg -> ((Bundle.BundleEntryComponent) arg).getResource());
    }

    @Override
    public String getName() {
        return "Bundle$BundleEntryComponent";
    }
}
