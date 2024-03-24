package org.fhirdot.dictionaries.r4.elements;

import org.fhirdot.dictionaries.framework.AbstractDefinition;
import org.hl7.fhir.r4.model.Base;
import org.hl7.fhir.r4.model.ClaimResponse;

public class ClaimResponseAddedItemComponentDefinition extends AbstractDefinition<Base> {
    @Override
    protected void initialize() {
        this.paths.putAll(new BackboneElementDefinition().getPaths());
        // itemSequence
        this.paths.put("itemSequence", arg -> ((ClaimResponse.AddedItemComponent) arg).getItemSequence());
        // detailSequence
        this.paths.put("detailSequence", arg -> ((ClaimResponse.AddedItemComponent) arg).getDetailSequence());
        // subdetailSequence
        this.paths.put("subdetailSequence", arg -> ((ClaimResponse.AddedItemComponent) arg).getSubdetailSequence());
        // provider
        this.paths.put("provider", arg -> ((ClaimResponse.AddedItemComponent) arg).getProvider());
        this.paths.put("providerFirstRep", arg -> ((ClaimResponse.AddedItemComponent) arg).getProviderFirstRep());
        // productOrService
        this.paths.put("productOrService", arg -> ((ClaimResponse.AddedItemComponent) arg).getProductOrService());
        // modifier
        this.paths.put("modifier", arg -> ((ClaimResponse.AddedItemComponent) arg).getModifier());
        this.paths.put("modifierFirstRep", arg -> ((ClaimResponse.AddedItemComponent) arg).getModifierFirstRep());
        // modifierExtension
        this.paths.put("modifierExtension", arg -> ((ClaimResponse.AddedItemComponent) arg).getModifierExtension());
        this.paths.put("modifierExtensionFirstRep", arg -> ((ClaimResponse.AddedItemComponent) arg).getModifierExtensionFirstRep());
        // programCode
        this.paths.put("programCode", arg -> ((ClaimResponse.AddedItemComponent) arg).getProgramCode());
        this.paths.put("programCodeFirstRep", arg -> ((ClaimResponse.AddedItemComponent) arg).getProgramCodeFirstRep());
        // serviced
        this.paths.put("serviced", arg -> ((ClaimResponse.AddedItemComponent) arg).getServiced());
        this.paths.put("servicedDate", arg -> ((ClaimResponse.AddedItemComponent) arg).getServicedDateType());
        this.paths.put("servicedPeriod", arg -> ((ClaimResponse.AddedItemComponent) arg).getServicedPeriod());
        // location
        this.paths.put("location", arg -> ((ClaimResponse.AddedItemComponent) arg).getLocation());
        this.paths.put("locationCodeableConcept", arg -> ((ClaimResponse.AddedItemComponent) arg).getLocationCodeableConcept());
        this.paths.put("locationAddress", arg -> ((ClaimResponse.AddedItemComponent) arg).getLocationAddress());
        this.paths.put("locationReference", arg -> ((ClaimResponse.AddedItemComponent) arg).getLocationReference());
        this.paths.put("locationTarget", arg -> ((ClaimResponse.AddedItemComponent) arg).getLocationReference().getResource());
        // quantity
        this.paths.put("quantity", arg -> ((ClaimResponse.AddedItemComponent) arg).getQuantity());
        // unitPrice
        this.paths.put("unitPrice", arg -> ((ClaimResponse.AddedItemComponent) arg).getUnitPrice());
        // factor
        this.paths.put("factor", arg -> ((ClaimResponse.AddedItemComponent) arg).getFactorElement());
        // net
        this.paths.put("net", arg -> ((ClaimResponse.AddedItemComponent) arg).getNet());
        // bodySite
        this.paths.put("bodySite", arg -> ((ClaimResponse.AddedItemComponent) arg).getBodySite());
        // subSite
        this.paths.put("subSite", arg -> ((ClaimResponse.AddedItemComponent) arg).getSubSite());
        this.paths.put("subSiteFirstRep", arg -> ((ClaimResponse.AddedItemComponent) arg).getSubSiteFirstRep());
        // noteNumber
        this.paths.put("noteNumber", arg -> ((ClaimResponse.AddedItemComponent) arg).getNoteNumber());
        // adjudication
        this.paths.put("adjudication", arg -> ((ClaimResponse.AddedItemComponent) arg).getAdjudication());
        this.paths.put("adjudicationFirstRep", arg -> ((ClaimResponse.AddedItemComponent) arg).getAdjudicationFirstRep());
        // detail
        this.paths.put("detail", arg -> ((ClaimResponse.AddedItemComponent) arg).getDetail());
        this.paths.put("detailFirstRep", arg -> ((ClaimResponse.AddedItemComponent) arg).getDetailFirstRep());
    }

    @Override
    public String getName() {
        return "ClaimResponse$AddedItemComponent";
    }
}
