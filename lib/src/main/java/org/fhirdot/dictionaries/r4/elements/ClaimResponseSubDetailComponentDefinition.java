package org.fhirdot.dictionaries.r4.elements;

import org.fhirdot.dictionaries.framework.AbstractDefinition;
import org.hl7.fhir.r4.model.Base;
import org.hl7.fhir.r4.model.ClaimResponse;

public class ClaimResponseSubDetailComponentDefinition extends AbstractDefinition<Base, ClaimResponse.SubDetailComponent> {
    @Override
    protected void initialize() {
        this.putAllPaths(new BackboneElementDefinition().getPaths());
        // subDetailSequence
        this.putPath("subDetailSequence", ClaimResponse.SubDetailComponent::getSubDetailSequenceElement);
        // noteNumber
        this.putPath("noteNumber", ClaimResponse.SubDetailComponent::getNoteNumber);
        // adjudication
        this.putPath("adjudication", ClaimResponse.SubDetailComponent::getAdjudication);
        this.putPath("adjudicationFirstRep", ClaimResponse.SubDetailComponent::getAdjudicationFirstRep);
    }

    @Override
    public String getName() {
        return "ClaimResponse$SubDetailComponent";
    }
}
