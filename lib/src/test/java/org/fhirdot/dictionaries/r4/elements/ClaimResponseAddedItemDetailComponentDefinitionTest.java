package org.fhirdot.dictionaries.r4.elements;

import org.fhirdot.dictionaries.framework.Definition;
import org.hl7.fhir.r4.model.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

public class ClaimResponseAddedItemDetailComponentDefinitionTest extends BackboneElementDefinitionTest {
    private final ClaimResponseAddedItemDetailComponentDefinition definitions = new ClaimResponseAddedItemDetailComponentDefinition();

    @Test
    public void testSuppliesProductOrService() {
        ClaimResponse.AddedItemDetailComponent component = new ClaimResponse.AddedItemDetailComponent();
        CodeableConcept productOrService = new CodeableConcept();
        component.setProductOrService(productOrService);
        CodeableConcept result = this.evaluate("productOrService", component);
        Assertions.assertEquals(productOrService, result);
    }

    @Test
    public void testSuppliesModifier() {
        ClaimResponse.AddedItemDetailComponent component = new ClaimResponse.AddedItemDetailComponent();
        CodeableConcept modifier = component.addModifier();
        List<CodeableConcept> result1 = this.evaluate("modifier", component);
        Assertions.assertFalse(result1.isEmpty());
        Assertions.assertEquals(modifier, result1.get(0));
        CodeableConcept result2 = this.evaluate("modifierFirstRep", component);
        Assertions.assertEquals(modifier, result2);
    }

    @Test
    public void testSuppliesQuantity() {
        ClaimResponse.AddedItemDetailComponent component = new ClaimResponse.AddedItemDetailComponent();
        Quantity quantity = new Quantity();
        component.setQuantity(quantity);
        Quantity result = this.evaluate("quantity", component);
        Assertions.assertEquals(quantity, result);
    }

    @Test
    public void testSuppliesUnitPrice() {
        ClaimResponse.AddedItemDetailComponent component = new ClaimResponse.AddedItemDetailComponent();
        Money unitPrice = new Money();
        component.setUnitPrice(unitPrice);
        Money result = this.evaluate("unitPrice", component);
        Assertions.assertEquals(unitPrice, result);
    }

    @Test
    public void testSuppliesFactor() {
        ClaimResponse.AddedItemDetailComponent component = new ClaimResponse.AddedItemDetailComponent();
        DecimalType factor = new DecimalType(1);
        component.setFactor(1);
        DecimalType result = this.evaluate("factor", component);
        Assertions.assertEquals(factor.getValue(), result.getValue());
    }

    @Test
    public void testSuppliesNet() {
        ClaimResponse.AddedItemDetailComponent component = new ClaimResponse.AddedItemDetailComponent();
        Money net = new Money();
        component.setNet(net);
        Money result = this.evaluate("net", component);
        Assertions.assertEquals(net, result);
    }

    @Test
    public void testSuppliesNoteNumber() {
        ClaimResponse.AddedItemDetailComponent component = new ClaimResponse.AddedItemDetailComponent();
        component.addNoteNumber(1);
        List<PositiveIntType> result = this.evaluate("noteNumber", component);
        Assertions.assertFalse(result.isEmpty());
        Assertions.assertEquals(1, result.get(0).getValue());
    }

    @Test
    public void testSuppliesAdjudication() {
        ClaimResponse.AddedItemDetailComponent component = new ClaimResponse.AddedItemDetailComponent();
        ClaimResponse.AdjudicationComponent adjudication = component.addAdjudication();
        List<ClaimResponse.AdjudicationComponent> result1 = this.evaluate("adjudication", component);
        Assertions.assertFalse(result1.isEmpty());
        Assertions.assertEquals(adjudication, result1.get(0));
        ClaimResponse.AdjudicationComponent result2 = this.evaluate("adjudicationFirstRep", component);
        Assertions.assertEquals(adjudication, result2);
    }

    @Test
    public void testSuppliesSubDetail() {
        ClaimResponse.AddedItemDetailComponent component = new ClaimResponse.AddedItemDetailComponent();
        ClaimResponse.AddedItemSubDetailComponent subDetail = component.addSubDetail();
        List<ClaimResponse.AddedItemSubDetailComponent> result1 = this.evaluate("subDetail", component);
        Assertions.assertFalse(result1.isEmpty());
        Assertions.assertEquals(subDetail, result1.get(0));
        ClaimResponse.AddedItemSubDetailComponent result2 = this.evaluate("subDetailFirstRep", component);
        Assertions.assertEquals(subDetail, result2);
    }

    @Override
    protected Definition<Base> getDefinitions() {
        return this.definitions;
    }
}
