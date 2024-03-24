package org.fhirdot.dictionaries.r4.elements;

import org.fhirdot.dictionaries.framework.Definition;
import org.hl7.fhir.r4.model.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

public class ClaimResponseAddedItemComponentDefinitionTest extends BackboneElementDefinitionTest {
    private final ClaimResponseAddedItemComponentDefinition definitions;

    public ClaimResponseAddedItemComponentDefinitionTest() {
        this.definitions = new ClaimResponseAddedItemComponentDefinition();
    }

    @Test
    public void testSuppliesItemSequence() {
        ClaimResponse.AddedItemComponent component = new ClaimResponse.AddedItemComponent();
        component.addItemSequence(1);
        List<PositiveIntType> result = this.evaluate("itemSequence", component);
        Assertions.assertFalse(result.isEmpty());
        Assertions.assertEquals(1, result.get(0).getValue());
    }

    @Test
    public void testSuppliesDetailSequence() {
        ClaimResponse.AddedItemComponent component = new ClaimResponse.AddedItemComponent();
        component.addDetailSequence(1);
        List<PositiveIntType> result = this.evaluate("detailSequence", component);
        Assertions.assertFalse(result.isEmpty());
        Assertions.assertEquals(1, result.get(0).getValue());
    }

    @Test
    public void testSuppliesSubdetailSequence() {
        ClaimResponse.AddedItemComponent component = new ClaimResponse.AddedItemComponent();
        component.addSubdetailSequence(1);
        List<PositiveIntType> result = this.evaluate("subdetailSequence", component);
        Assertions.assertFalse(result.isEmpty());
        Assertions.assertEquals(1, result.get(0).getValue());
    }

    @Test
    public void testSuppliesProvider() {
        ClaimResponse.AddedItemComponent component = new ClaimResponse.AddedItemComponent();
        Organization provider = new Organization();
        component.addProvider().setResource(provider);
        List<Reference> result1 = this.evaluate("provider", component);
        Assertions.assertFalse(result1.isEmpty());
        Assertions.assertEquals(provider, result1.get(0).getResource());
        Reference result2 = this.evaluate("providerFirstRep", component);
        Assertions.assertEquals(provider, result2.getResource());
    }

    @Test
    public void testSuppliesProductOrService() {
        ClaimResponse.AddedItemComponent component = new ClaimResponse.AddedItemComponent();
        CodeableConcept productOrService = new CodeableConcept();
        component.setProductOrService(productOrService);
        CodeableConcept result = this.evaluate("productOrService", component);
        Assertions.assertEquals(productOrService, result);
    }

    @Test
    public void testSuppliesModifier() {
        ClaimResponse.AddedItemComponent component = new ClaimResponse.AddedItemComponent();
        CodeableConcept modifier = component.addModifier();
        List<CodeableConcept> result1 = this.evaluate("modifier", component);
        Assertions.assertFalse(result1.isEmpty());
        Assertions.assertEquals(modifier, result1.get(0));
        CodeableConcept result2 = this.evaluate("modifierFirstRep", component);
        Assertions.assertEquals(modifier, result2);
    }

    @Test
    public void testSuppliesProgramCode() {
        ClaimResponse.AddedItemComponent component = new ClaimResponse.AddedItemComponent();
        CodeableConcept programCode = component.addProgramCode();
        List<CodeableConcept> result1 = this.evaluate("programCode", component);
        Assertions.assertFalse(result1.isEmpty());
        Assertions.assertEquals(programCode, result1.get(0));
        CodeableConcept result2 = this.evaluate("programCodeFirstRep", component);
        Assertions.assertEquals(programCode, result2);
    }

    @Test
    public void testSuppliesServiced() {
        ClaimResponse.AddedItemComponent component = new ClaimResponse.AddedItemComponent();
        DateType dateType = new DateType();
        component.setServiced(dateType);
        Type result = this.evaluate("serviced[x]", component);
        Assertions.assertEquals(dateType, result);
        result = this.evaluate("servicedDate", component);
        Assertions.assertEquals(dateType, result);
        Period period = new Period();
        component.setServiced(period);
        result = this.evaluate("servicedPeriod", component);
        Assertions.assertEquals(period, result);
    }

    @Test
    public void testSuppliesLocation() {
        ClaimResponse.AddedItemComponent component = new ClaimResponse.AddedItemComponent();
        Type location = new CodeableConcept();
        component.setLocation(location);
        Type result = this.evaluate("location[x]", component);
        Assertions.assertEquals(location, result);
        result = this.evaluate("locationCodeableConcept", component);
        Assertions.assertEquals(location, result);
        location = new Address();
        component.setLocation(location);
        result = this.evaluate("locationAddress", component);
        Assertions.assertEquals(location, result);
        Location locationResource = new Location();
        location = new Reference();
        ((Reference) location).setResource(locationResource);
        component.setLocation(location);
        result = this.evaluate("locationReference", component);
        Assertions.assertEquals(location, result);
        Location result2 = this.evaluate("locationTarget", component);
        Assertions.assertEquals(locationResource, result2);
    }

    @Test
    public void testSuppliesQuantity() {
        ClaimResponse.AddedItemComponent component = new ClaimResponse.AddedItemComponent();
        Quantity quantity = new Quantity();
        component.setQuantity(quantity);
        Quantity result = this.evaluate("quantity", component);
        Assertions.assertEquals(quantity, result);
    }

    @Test
    public void testSuppliesUnitPrice() {
        ClaimResponse.AddedItemComponent component = new ClaimResponse.AddedItemComponent();
        Money unitPrice = new Money();
        component.setUnitPrice(unitPrice);
        Money result = this.evaluate("unitPrice", component);
        Assertions.assertEquals(unitPrice, result);
    }

    @Test
    public void testSuppliesFactor() {
        ClaimResponse.AddedItemComponent component = new ClaimResponse.AddedItemComponent();
        DecimalType factor = new DecimalType(1);
        component.setFactor(1);
        DecimalType result = this.evaluate("factor", component);
        Assertions.assertEquals(factor.getValue(), result.getValue());
    }

    @Test
    public void testSuppliesNet() {
        ClaimResponse.AddedItemComponent component = new ClaimResponse.AddedItemComponent();
        Money net = new Money();
        component.setNet(net);
        Money result = this.evaluate("net", component);
        Assertions.assertEquals(net, result);
    }

    @Test
    public void testSuppliesBodySite() {
        ClaimResponse.AddedItemComponent component = new ClaimResponse.AddedItemComponent();
        CodeableConcept bodySite = new CodeableConcept();
        component.setBodySite(bodySite);
        CodeableConcept result = this.evaluate("bodySite", component);
        Assertions.assertEquals(bodySite, result);
    }

    @Test
    public void testSuppliesSubSite() {
        ClaimResponse.AddedItemComponent component = new ClaimResponse.AddedItemComponent();
        CodeableConcept subSite = new CodeableConcept();
        component.addSubSite(subSite);
        List<CodeableConcept> result1 = this.evaluate("subSite", component);
        Assertions.assertFalse(result1.isEmpty());
        Assertions.assertEquals(subSite, result1.get(0));
        CodeableConcept result2 = this.evaluate("subSiteFirstRep", component);
        Assertions.assertEquals(subSite, result2);
    }

    @Test
    public void testSuppliesNoteNumber() {
        ClaimResponse.AddedItemComponent component = new ClaimResponse.AddedItemComponent();
        PositiveIntType noteNumber = new PositiveIntType(1);
        component.addNoteNumber(1);
        List<PositiveIntType> result = this.evaluate("noteNumber", component);
        Assertions.assertFalse(result.isEmpty());
        Assertions.assertEquals(noteNumber.getValue(), result.get(0).getValue());
    }

    @Test
    public void testSuppliesAdjudication() {
        ClaimResponse.AddedItemComponent component = new ClaimResponse.AddedItemComponent();
        ClaimResponse.AdjudicationComponent adjudication = new ClaimResponse.AdjudicationComponent();
        component.addAdjudication(adjudication);
        List<ClaimResponse.AdjudicationComponent> result1 = this.evaluate("adjudication", component);
        Assertions.assertFalse(result1.isEmpty());
        Assertions.assertEquals(adjudication, result1.get(0));
        ClaimResponse.AdjudicationComponent result2 = this.evaluate("adjudicationFirstRep", component);
        Assertions.assertEquals(adjudication, result2);
    }

    @Test
    public void testSuppliesDetail() {
        ClaimResponse.AddedItemComponent component = new ClaimResponse.AddedItemComponent();
        ClaimResponse.AddedItemDetailComponent detail = component.addDetail();
        List<ClaimResponse.AddedItemDetailComponent> result1 = this.evaluate("detail", component);
        Assertions.assertFalse(result1.isEmpty());
        Assertions.assertEquals(detail, result1.get(0));
        ClaimResponse.AddedItemDetailComponent result2 = this.evaluate("detailFirstRep", component);
        Assertions.assertEquals(detail, result2);
    }

    @Override
    protected Definition<Base> getDefinitions() {
        return this.definitions;
    }
}
