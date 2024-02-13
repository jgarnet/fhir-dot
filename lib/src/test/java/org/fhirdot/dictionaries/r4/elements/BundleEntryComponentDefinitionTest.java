package org.fhirdot.dictionaries.r4.elements;

import org.fhirdot.dictionaries.framework.Definition;
import org.hl7.fhir.r4.model.Base;
import org.hl7.fhir.r4.model.Bundle;
import org.hl7.fhir.r4.model.Claim;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class BundleEntryComponentDefinitionTest extends BackboneElementDefinitionTest {
    private final BundleEntryComponentDefinition bundleEntryComponentDefinitions;

    public BundleEntryComponentDefinitionTest() {
        this.bundleEntryComponentDefinitions = new BundleEntryComponentDefinition();
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
    protected Definition<Base> getDefinitions() {
        return this.bundleEntryComponentDefinitions;
    }
}
