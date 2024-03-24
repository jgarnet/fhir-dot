package org.fhirdot.dictionaries.r4.elements;

import org.fhirdot.dictionaries.framework.AbstractDefinition;
import org.hl7.fhir.r4.model.Base;
import org.hl7.fhir.r4.model.ClaimResponse;

public class ClaimResponseErrorComponentDefinition extends AbstractDefinition<Base, ClaimResponse.ErrorComponent> {
    @Override
    protected void initialize() {
        this.putAllPaths(new BackboneElementDefinition().getPaths());
        this.putPath("itemSequence", ClaimResponse.ErrorComponent::getItemSequenceElement);
        this.putPath("detailSequence", ClaimResponse.ErrorComponent::getDetailSequenceElement);
        this.putPath("subDetailSequence", ClaimResponse.ErrorComponent::getSubDetailSequenceElement);
        this.putPath("code", ClaimResponse.ErrorComponent::getCode);
    }

    @Override
    public String getName() {
        return "ClaimResponse$ErrorComponent";
    }
}
