package org.fhirdot.dictionaries.r4.elements;

import org.fhirdot.dictionaries.framework.AbstractDefinition;
import org.hl7.fhir.r4.model.Base;
import org.hl7.fhir.r4.model.ClaimResponse;

public class ClaimResponseAddedItemDetailComponentDefinition extends AbstractDefinition<Base> {
    @Override
    protected void initialize() {
        this.paths.putAll(new BackboneElementDefinition().getPaths());
        // productOrService
        this.paths.put("productOrService", arg -> ((ClaimResponse.AddedItemDetailComponent) arg).getProductOrService());
        // modifier
        this.paths.put("modifier", arg -> ((ClaimResponse.AddedItemDetailComponent) arg).getModifier());
        this.paths.put("modifierFirstRep", arg -> ((ClaimResponse.AddedItemDetailComponent) arg).getModifierFirstRep());
        // modifierExtension
        this.paths.put("modifierExtension", arg -> ((ClaimResponse.AddedItemDetailComponent) arg).getModifierExtension());
        this.paths.put("modifierExtensionFirstRep", arg -> ((ClaimResponse.AddedItemDetailComponent) arg).getModifierExtensionFirstRep());
        // quantity
        this.paths.put("quantity", arg -> ((ClaimResponse.AddedItemDetailComponent) arg).getQuantity());
        // unitPrice
        this.paths.put("unitPrice", arg -> ((ClaimResponse.AddedItemDetailComponent) arg).getUnitPrice());
        // factor
        this.paths.put("factor", arg -> ((ClaimResponse.AddedItemDetailComponent) arg).getFactorElement());
        // net
        this.paths.put("net", arg -> ((ClaimResponse.AddedItemDetailComponent) arg).getNet());
        // noteNumber
        this.paths.put("noteNumber", arg -> ((ClaimResponse.AddedItemDetailComponent) arg).getNoteNumber());
        // adjudication
        this.paths.put("adjudication", arg -> ((ClaimResponse.AddedItemDetailComponent) arg).getAdjudication());
        this.paths.put("adjudicationFirstRep", arg -> ((ClaimResponse.AddedItemDetailComponent) arg).getAdjudicationFirstRep());
        // subDetail
        this.paths.put("subDetail", arg -> ((ClaimResponse.AddedItemDetailComponent) arg).getSubDetail());
        this.paths.put("subDetailFirstRep", arg -> ((ClaimResponse.AddedItemDetailComponent) arg).getSubDetailFirstRep());
    }

    @Override
    public String getName() {
        return "ClaimResponse$AddedItemDetailComponent";
    }
}
