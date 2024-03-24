package org.fhirdot.dictionaries.r4.elements;

import org.fhirdot.dictionaries.framework.AbstractDefinition;
import org.hl7.fhir.r4.model.BackboneElement;
import org.hl7.fhir.r4.model.Base;
import org.hl7.fhir.r4.model.ClaimResponse;

public class ClaimResponseAddedItemComponentDefinition extends AbstractDefinition<Base, ClaimResponse.AddedItemComponent> {
    @Override
    protected void initialize() {
        this.putAllPaths(new BackboneElementDefinition().getPaths());
        // itemSequence
        this.putPath("itemSequence", ClaimResponse.AddedItemComponent::getItemSequence);
        // detailSequence
        this.putPath("detailSequence", ClaimResponse.AddedItemComponent::getDetailSequence);
        // subdetailSequence
        this.putPath("subdetailSequence", ClaimResponse.AddedItemComponent::getSubdetailSequence);
        // provider
        this.putPath("provider", ClaimResponse.AddedItemComponent::getProvider);
        this.putPath("providerFirstRep", ClaimResponse.AddedItemComponent::getProviderFirstRep);
        // productOrService
        this.putPath("productOrService", ClaimResponse.AddedItemComponent::getProductOrService);
        // modifier
        this.putPath("modifier", ClaimResponse.AddedItemComponent::getModifier);
        this.putPath("modifierFirstRep", ClaimResponse.AddedItemComponent::getModifierFirstRep);
        // programCode
        this.putPath("programCode", ClaimResponse.AddedItemComponent::getProgramCode);
        this.putPath("programCodeFirstRep", ClaimResponse.AddedItemComponent::getProgramCodeFirstRep);
        // serviced
        this.putPath("serviced[x]", ClaimResponse.AddedItemComponent::getServiced);
        this.putPath("servicedDate", ClaimResponse.AddedItemComponent::getServicedDateType);
        this.putPath("servicedPeriod", ClaimResponse.AddedItemComponent::getServicedPeriod);
        // location
        this.putPath("location[x]", ClaimResponse.AddedItemComponent::getLocation);
        this.putPath("locationCodeableConcept", ClaimResponse.AddedItemComponent::getLocationCodeableConcept);
        this.putPath("locationAddress", ClaimResponse.AddedItemComponent::getLocationAddress);
        this.putPath("locationReference", ClaimResponse.AddedItemComponent::getLocationReference);
        this.putPath("locationTarget", arg -> arg.getLocationReference().getResource());
        // quantity
        this.putPath("quantity", ClaimResponse.AddedItemComponent::getQuantity);
        // unitPrice
        this.putPath("unitPrice", ClaimResponse.AddedItemComponent::getUnitPrice);
        // factor
        this.putPath("factor", ClaimResponse.AddedItemComponent::getFactorElement);
        // net
        this.putPath("net", ClaimResponse.AddedItemComponent::getNet);
        // bodySite
        this.putPath("bodySite", ClaimResponse.AddedItemComponent::getBodySite);
        // subSite
        this.putPath("subSite", ClaimResponse.AddedItemComponent::getSubSite);
        this.putPath("subSiteFirstRep", ClaimResponse.AddedItemComponent::getSubSiteFirstRep);
        // noteNumber
        this.putPath("noteNumber", ClaimResponse.AddedItemComponent::getNoteNumber);
        // adjudication
        this.putPath("adjudication", ClaimResponse.AddedItemComponent::getAdjudication);
        this.putPath("adjudicationFirstRep", ClaimResponse.AddedItemComponent::getAdjudicationFirstRep);
        // detail
        this.putPath("detail", ClaimResponse.AddedItemComponent::getDetail);
        this.putPath("detailFirstRep", ClaimResponse.AddedItemComponent::getDetailFirstRep);
    }

    @Override
    public String getName() {
        return "ClaimResponse$AddedItemComponent";
    }
}
