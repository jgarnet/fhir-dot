package org.fhirdot.dictionaries.r4.elements;

import org.fhirdot.dictionaries.framework.AbstractDefinition;
import org.hl7.fhir.r4.model.Base;
import org.hl7.fhir.r4.model.ClaimResponse;

public class ClaimResponseAddedItemSubDetailComponentDefinition extends AbstractDefinition<Base> {
    @Override
    protected void initialize() {
        this.paths.putAll(new BackboneElementDefinition().getPaths());
        // productOrService
        this.paths.put("productOrService", arg -> ((ClaimResponse.AddedItemSubDetailComponent) arg).getProductOrService());
        // modifier
        this.paths.put("modifier", arg -> ((ClaimResponse.AddedItemSubDetailComponent) arg).getModifier());
        this.paths.put("modifierFirstRep", arg -> ((ClaimResponse.AddedItemSubDetailComponent) arg).getModifierFirstRep());
        // modifierExtension
        this.paths.put("modifierExtension", arg -> ((ClaimResponse.AddedItemSubDetailComponent) arg).getModifierExtension());
        this.paths.put("modifierExtensionFirstRep", arg -> ((ClaimResponse.AddedItemSubDetailComponent) arg).getModifierExtensionFirstRep());
        // quantity
        this.paths.put("quantity", arg -> ((ClaimResponse.AddedItemSubDetailComponent) arg).getQuantity());
        // unitPrice
        this.paths.put("unitPrice", arg -> ((ClaimResponse.AddedItemSubDetailComponent) arg).getUnitPrice());
        // factor
        this.paths.put("factor", arg -> ((ClaimResponse.AddedItemSubDetailComponent) arg).getFactorElement());
        // net
        this.paths.put("net", arg -> ((ClaimResponse.AddedItemSubDetailComponent) arg).getNet());
        // noteNumber
        this.paths.put("noteNumber", arg -> ((ClaimResponse.AddedItemSubDetailComponent) arg).getNoteNumber());
        // adjudication
        this.paths.put("adjudication", arg -> ((ClaimResponse.AddedItemSubDetailComponent) arg).getAdjudication());
        this.paths.put("adjudicationFirstRep", arg -> ((ClaimResponse.AddedItemSubDetailComponent) arg).getAdjudicationFirstRep());
    }

    @Override
    public String getName() {
        return "ClaimResponse$AddedItemSubDetailComponent";
    }
}
