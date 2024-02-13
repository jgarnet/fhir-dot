package org.fhirdot.dictionaries.r4.elements;

import org.fhirdot.dictionaries.framework.AbstractDefinition;
import org.hl7.fhir.r4.model.Base;
import org.hl7.fhir.r4.model.ClaimResponse;

public class ClaimResponseAdjudicationComponentDefinition extends AbstractDefinition<Base> {
    @Override
    protected void initialize() {
        this.paths.putAll(new BackboneElementDefinition().getPaths());
        // category
        this.paths.put("category", arg -> ((ClaimResponse.AdjudicationComponent) arg).getCategory());
        // reason
        this.paths.put("reason", arg -> ((ClaimResponse.AdjudicationComponent) arg).getReason());
        // amount
        this.paths.put("amount", arg -> ((ClaimResponse.AdjudicationComponent) arg).getAmount());
        // value
        this.paths.put("value", arg -> ((ClaimResponse.AdjudicationComponent) arg).getValueElement());
    }

    @Override
    public String getName() {
        return "ClaimResponse$AdjudicationComponent";
    }
}
