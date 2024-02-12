package org.fhirpath.dictionaries.r4.elements;

import org.fhirpath.dictionaries.framework.Definitions;
import org.hl7.fhir.r4.model.Base;
import org.hl7.fhir.r4.model.Bundle;
import org.hl7.fhir.r4.model.Claim;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class BundleEntryComponentDefinitionsTest extends BackboneElementDefinitionsTest {
    private final BundleEntryComponentDefinitions bundleEntryComponentDefinitions;

    public BundleEntryComponentDefinitionsTest() {
        this.bundleEntryComponentDefinitions = new BundleEntryComponentDefinitions();
    }

    @Test
    public void testSuppliesResource() {
        Bundle.BundleEntryComponent b = new Bundle.BundleEntryComponent();
        Claim claim = new Claim();
        b.setResource(claim);
        Claim result = this.evaluate("resource", b);
        Assertions.assertEquals(claim, result);
    }

    @Override
    protected Definitions<Base> getDefinitions() {
        return this.bundleEntryComponentDefinitions;
    }
}
