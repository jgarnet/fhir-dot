package org.fhirdot.dictionaries.r4.elements;

import org.fhirdot.dictionaries.framework.AbstractDefinition;
import org.hl7.fhir.r4.model.Base;
import org.hl7.fhir.r4.model.ClaimResponse;

public class ClaimResponseItemDetailComponentDefinition extends AbstractDefinition<Base, ClaimResponse.ItemDetailComponent> {
    @Override
    protected void initialize() {
        this.putAllPaths(new BackboneElementDefinition().getPaths());
        // detailSequence
        this.putPath("detailSequence", ClaimResponse.ItemDetailComponent::getDetailSequenceElement);
        // noteNumber
        this.putPath("noteNumber", ClaimResponse.ItemDetailComponent::getNoteNumber);
        // adjudication
        this.putPath("adjudication", ClaimResponse.ItemDetailComponent::getAdjudication);
        this.putPath("adjudicationFirstRep", ClaimResponse.ItemDetailComponent::getAdjudicationFirstRep);
        // subDetail
        this.putPath("subDetail", ClaimResponse.ItemDetailComponent::getSubDetail);
        this.putPath("subDetailFirstRep", ClaimResponse.ItemDetailComponent::getSubDetailFirstRep);
    }

    @Override
    public String getName() {
        return "ClaimResponse$ItemDetailComponent";
    }
}
