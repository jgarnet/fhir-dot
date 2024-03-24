package org.fhirdot.dictionaries.r4.elements;

import org.fhirdot.dictionaries.framework.AbstractDefinition;
import org.hl7.fhir.r4.model.Base;
import org.hl7.fhir.r4.model.Bundle;

public class BundleEntryComponentDefinition extends AbstractDefinition<Base, Bundle.BundleEntryComponent> {
    @Override
    protected void initialize() {
        this.putAllPaths(new BackboneElementDefinition().getPaths());
        // resource
        this.putPath("resource", Bundle.BundleEntryComponent::getResource);
    }

    @Override
    public String getName() {
        return "Bundle$BundleEntryComponent";
    }
}
