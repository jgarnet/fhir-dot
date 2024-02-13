package org.fhirpath.dictionaries.r4.elements;

import org.fhirpath.dictionaries.framework.Definition;
import org.hl7.fhir.r4.model.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ClaimResponseInsuranceComponentDefinitionsTest extends BackboneElementDefinitionsTest {
    private final ClaimResponseInsuranceComponentDefinition claimResponseInsuranceComponentDefinitions;
    private final ClaimResponse.InsuranceComponent insuranceComponent;
    private final Coverage coverage;
    private final ClaimResponse claimResponse;

    public ClaimResponseInsuranceComponentDefinitionsTest() {
        this.claimResponseInsuranceComponentDefinitions = new ClaimResponseInsuranceComponentDefinition();
        this.coverage = new Coverage();
        this.claimResponse = new ClaimResponse();
        this.insuranceComponent = new ClaimResponse.InsuranceComponent();
        this.insuranceComponent.setSequence(1);
        this.insuranceComponent.setFocal(true);
        Reference coverageReference = new Reference();
        coverageReference.setResource(this.coverage);
        this.insuranceComponent.setCoverage(coverageReference);
        this.insuranceComponent.setCoverageTarget(this.coverage);
        Reference claimResponseReference = new Reference();
        claimResponseReference.setResource(this.claimResponse);
        this.insuranceComponent.setClaimResponse(claimResponseReference);
        this.insuranceComponent.setClaimResponseTarget(this.claimResponse);
        this.insuranceComponent.setBusinessArrangement("Test Business Arrangement");
    }

    @Test
    public void testSuppliesSequence() {
        PositiveIntType result = this.evaluate("sequence", this.insuranceComponent);
        Assertions.assertEquals(1, result.getValue());
    }

    @Test
    public void testSuppliesFocal() {
        BooleanType result = this.evaluate("focal", this.insuranceComponent);
        Assertions.assertTrue(result.getValue());
    }

    @Test
    public void testSuppliesCoverage() {
        Reference result = this.evaluate("coverage", this.insuranceComponent);
        Assertions.assertEquals(this.coverage, result.getResource());
    }

    @Test
    public void testSuppliesCoverageTarget() {
        Coverage result = this.evaluate("coverageTarget", this.insuranceComponent);
        Assertions.assertEquals(this.coverage, result);
    }

    @Test
    public void testSuppliesBusinessArrangement() {
        StringType result = this.evaluate("businessArrangement", this.insuranceComponent);
        Assertions.assertEquals("Test Business Arrangement", result.getValue());
    }

    @Test
    public void testSuppliesClaimResponse() {
        Reference result = this.evaluate("claimResponse", this.insuranceComponent);
        Assertions.assertEquals(this.claimResponse, result.getResource());
    }

    @Test
    public void testSuppliesClaimResponseTarget() {
        ClaimResponse result = this.evaluate("claimResponseTarget", this.insuranceComponent);
        Assertions.assertEquals(this.claimResponse, result);
    }

    @Override
    protected Definition<Base> getDefinitions() {
        return this.claimResponseInsuranceComponentDefinitions;
    }
}
