package org.fhirdot.dictionaries.r4.elements;

import org.fhirdot.dictionaries.framework.AbstractDefinition;
import org.hl7.fhir.r4.model.BackboneElement;
import org.hl7.fhir.r4.model.Base;
import org.hl7.fhir.r4.model.ClaimResponse;

public class ClaimResponseAddedItemSubDetailComponentDefinition extends AbstractDefinition<Base, ClaimResponse.AddedItemSubDetailComponent> {
    @Override
    protected void initialize() {
        this.putAllPaths(new BackboneElementDefinition().getPaths());
        // productOrService
        this.putPath("productOrService", ClaimResponse.AddedItemSubDetailComponent::getProductOrService);
        // modifier
        this.putPath("modifier", ClaimResponse.AddedItemSubDetailComponent::getModifier);
        this.putPath("modifierFirstRep", ClaimResponse.AddedItemSubDetailComponent::getModifierFirstRep);
        // modifierExtension
        this.putPath("modifierExtension", BackboneElement::getModifierExtension);
        this.putPath("modifierExtensionFirstRep", BackboneElement::getModifierExtensionFirstRep);
        // quantity
        this.putPath("quantity", ClaimResponse.AddedItemSubDetailComponent::getQuantity);
        // unitPrice
        this.putPath("unitPrice", ClaimResponse.AddedItemSubDetailComponent::getUnitPrice);
        // factor
        this.putPath("factor", ClaimResponse.AddedItemSubDetailComponent::getFactorElement);
        // net
        this.putPath("net", ClaimResponse.AddedItemSubDetailComponent::getNet);
        // noteNumber
        this.putPath("noteNumber", ClaimResponse.AddedItemSubDetailComponent::getNoteNumber);
        // adjudication
        this.putPath("adjudication", ClaimResponse.AddedItemSubDetailComponent::getAdjudication);
        this.putPath("adjudicationFirstRep", ClaimResponse.AddedItemSubDetailComponent::getAdjudicationFirstRep);
    }

    @Override
    public String getName() {
        return "ClaimResponse$AddedItemSubDetailComponent";
    }
}
