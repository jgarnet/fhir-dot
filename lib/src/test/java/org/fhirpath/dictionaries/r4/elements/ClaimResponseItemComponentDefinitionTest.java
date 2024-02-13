package org.fhirpath.dictionaries.r4.elements;

import org.fhirpath.dictionaries.framework.Definition;
import org.hl7.fhir.r4.model.Base;
import org.hl7.fhir.r4.model.ClaimResponse;
import org.hl7.fhir.r4.model.PositiveIntType;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.List;

public class ClaimResponseItemComponentDefinitionsTest extends BackboneElementDefinitionsTest {
    private final ClaimResponseItemComponentDefinition claimResponseItemComponentDefinitions;
    private final ClaimResponse.ItemComponent itemComponent;

    public ClaimResponseItemComponentDefinitionsTest() {
        this.claimResponseItemComponentDefinitions = new ClaimResponseItemComponentDefinition();
        this.itemComponent = new ClaimResponse.ItemComponent();
        this.itemComponent.setItemSequence(1);
        this.itemComponent.addNoteNumber(1);
        this.itemComponent.addAdjudication().setValue(1);
        this.itemComponent.addDetail().setDetailSequence(1);
    }

    @Test
    public void testSuppliesItemSequence() {
        PositiveIntType result = this.evaluate("itemSequence", this.itemComponent);
        Assertions.assertEquals(1, result.getValue());
    }

    @Test
    public void testSuppliesNoteNumber() {
        List<PositiveIntType> result = this.evaluate("noteNumber", this.itemComponent);
        Assertions.assertEquals(1, result.get(0).getValue());
    }

    @Test
    public void testSuppliesAdjudication() {
        List<ClaimResponse.AdjudicationComponent> result = this.evaluate("adjudication", this.itemComponent);
        Assertions.assertEquals(BigDecimal.ONE, result.get(0).getValue());
    }

    @Test
    public void testSuppliesDetail() {
        List<ClaimResponse.ItemDetailComponent> result = this.evaluate("detail", this.itemComponent);
        Assertions.assertEquals(1, result.get(0).getDetailSequence());
    }

    @Override
    protected Definition<Base> getDefinitions() {
        return this.claimResponseItemComponentDefinitions;
    }
}
