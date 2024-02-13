package org.fhirpath.dictionaries.r4.elements;

import org.fhirpath.dictionaries.framework.Definition;
import org.hl7.fhir.r4.model.Base;
import org.hl7.fhir.r4.model.ClaimResponse;
import org.hl7.fhir.r4.model.CodeableConcept;
import org.hl7.fhir.r4.model.PositiveIntType;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ClaimResponseErrorComponentDefinitionsTest extends BackboneElementDefinitionsTest {
    private final ClaimResponseErrorComponentDefinition claimResponseErrorComponentDefinitions;
    private final ClaimResponse.ErrorComponent error;

    public ClaimResponseErrorComponentDefinitionsTest() {
        this.claimResponseErrorComponentDefinitions = new ClaimResponseErrorComponentDefinition();
        this.error = new ClaimResponse.ErrorComponent();
        this.error.setItemSequence(1);
        this.error.setDetailSequence(1);
        this.error.setSubDetailSequence(1);
        CodeableConcept code = new CodeableConcept();
        code.setText("Test Code");
        this.error.setCode(code);
    }

    @Test
    public void testSuppliesItemSequence() {
        PositiveIntType result = this.evaluate("itemSequence", this.error);
        Assertions.assertEquals(1, result.getValue());
    }

    @Test
    public void testSuppliesDetailSequence() {
        PositiveIntType result = this.evaluate("detailSequence", this.error);
        Assertions.assertEquals(1, result.getValue());
    }

    @Test
    public void testSuppliesSubDetailSequence() {
        PositiveIntType result = this.evaluate("subDetailSequence", this.error);
        Assertions.assertEquals(1, result.getValue());
    }

    @Test
    public void testSuppliesCode() {
        CodeableConcept result = this.evaluate("code", this.error);
        Assertions.assertEquals("Test Code", result.getText());
    }

    @Override
    protected Definition<Base> getDefinitions() {
        return this.claimResponseErrorComponentDefinitions;
    }
}
