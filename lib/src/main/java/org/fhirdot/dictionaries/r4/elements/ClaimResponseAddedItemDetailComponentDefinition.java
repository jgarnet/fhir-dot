package org.fhirdot.dictionaries.r4.elements;

import org.fhirdot.dictionaries.framework.AbstractDefinition;
import org.hl7.fhir.r4.model.BackboneElement;
import org.hl7.fhir.r4.model.Base;
import org.hl7.fhir.r4.model.ClaimResponse;

public class ClaimResponseAddedItemDetailComponentDefinition extends AbstractDefinition<Base, ClaimResponse.AddedItemDetailComponent> {
    @Override
    protected void initialize() {
        this.putAllPaths(new BackboneElementDefinition().getPaths());
        // productOrService
        this.putPath("productOrService", ClaimResponse.AddedItemDetailComponent::getProductOrService);
        // modifier
        this.putPath("modifier", ClaimResponse.AddedItemDetailComponent::getModifier);
        this.putPath("modifierFirstRep", ClaimResponse.AddedItemDetailComponent::getModifierFirstRep);
        // modifierExtension
        this.putPath("modifierExtension", BackboneElement::getModifierExtension);
        this.putPath("modifierExtensionFirstRep", BackboneElement::getModifierExtensionFirstRep);
        // quantity
        this.putPath("quantity", ClaimResponse.AddedItemDetailComponent::getQuantity);
        // unitPrice
        this.putPath("unitPrice", ClaimResponse.AddedItemDetailComponent::getUnitPrice);
        // factor
        this.putPath("factor", ClaimResponse.AddedItemDetailComponent::getFactorElement);
        // net
        this.putPath("net", ClaimResponse.AddedItemDetailComponent::getNet);
        // noteNumber
        this.putPath("noteNumber", ClaimResponse.AddedItemDetailComponent::getNoteNumber);
        // adjudication
        this.putPath("adjudication", ClaimResponse.AddedItemDetailComponent::getAdjudication);
        this.putPath("adjudicationFirstRep", ClaimResponse.AddedItemDetailComponent::getAdjudicationFirstRep);
        // subDetail
        this.putPath("subDetail", ClaimResponse.AddedItemDetailComponent::getSubDetail);
        this.putPath("subDetailFirstRep", ClaimResponse.AddedItemDetailComponent::getSubDetailFirstRep);
    }

    @Override
    public String getName() {
        return "ClaimResponse$AddedItemDetailComponent";
    }
}
