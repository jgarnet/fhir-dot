package org.fhirdot.dictionaries.r4.elements;

import org.fhirdot.dictionaries.framework.AbstractDefinition;
import org.hl7.fhir.r4.model.Base;
import org.hl7.fhir.r4.model.ClaimResponse;

public class ClaimResponseAdjudicationComponentDefinition extends AbstractDefinition<Base, ClaimResponse.AdjudicationComponent> {
    @Override
    protected void initialize() {
        this.putAllPaths(new BackboneElementDefinition().getPaths());
        // category
        this.putPath("category", ClaimResponse.AdjudicationComponent::getCategory);
        // reason
        this.putPath("reason", ClaimResponse.AdjudicationComponent::getReason);
        // amount
        this.putPath("amount", ClaimResponse.AdjudicationComponent::getAmount);
        // value
        this.putPath("value", ClaimResponse.AdjudicationComponent::getValueElement);
    }

    @Override
    public String getName() {
        return "ClaimResponse$AdjudicationComponent";
    }
}
