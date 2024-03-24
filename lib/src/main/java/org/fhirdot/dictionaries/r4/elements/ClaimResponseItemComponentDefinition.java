package org.fhirdot.dictionaries.r4.elements;

import org.fhirdot.dictionaries.framework.AbstractDefinition;
import org.hl7.fhir.r4.model.Base;
import org.hl7.fhir.r4.model.ClaimResponse;

public class ClaimResponseItemComponentDefinition extends AbstractDefinition<Base, ClaimResponse.ItemComponent> {
    @Override
    protected void initialize() {
        this.putAllPaths(new BackboneElementDefinition().getPaths());
        // itemSequence
        this.putPath("itemSequence", ClaimResponse.ItemComponent::getItemSequenceElement);
        // noteNumber
        this.putPath("noteNumber", ClaimResponse.ItemComponent::getNoteNumber);
        // adjudication
        this.putPath("adjudication", ClaimResponse.ItemComponent::getAdjudication);
        this.putPath("adjudicationFirstRep", ClaimResponse.ItemComponent::getAdjudicationFirstRep);
        // detail
        this.putPath("detail", ClaimResponse.ItemComponent::getDetail);
        this.putPath("detailFirstRep", ClaimResponse.ItemComponent::getDetailFirstRep);
    }

    @Override
    public String getName() {
        return "ClaimResponse$ItemComponent";
    }
}
