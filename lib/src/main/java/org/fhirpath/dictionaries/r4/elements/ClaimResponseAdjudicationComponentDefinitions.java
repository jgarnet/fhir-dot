package org.fhirpath.dictionaries.r4.elements;

import org.fhirpath.dictionaries.framework.AbstractDefinitions;
import org.hl7.fhir.r4.model.Base;
import org.hl7.fhir.r4.model.ClaimResponse;

public class ClaimResponseAdjudicationComponentDefinitions extends AbstractDefinitions<Base> {
    @Override
    protected void initialize() {
        this.definitions.putAll(new BackboneElementDefinitions().getDefinitions());
        // category
        this.definitions.put("category", arg -> ((ClaimResponse.AdjudicationComponent) arg).getCategory());
        // reason
        this.definitions.put("reason", arg -> ((ClaimResponse.AdjudicationComponent) arg).getReason());
        // amount
        this.definitions.put("amount", arg -> ((ClaimResponse.AdjudicationComponent) arg).getAmount());
        // value
        this.definitions.put("value", arg -> ((ClaimResponse.AdjudicationComponent) arg).getValueElement());
    }

    @Override
    public String getName() {
        return "ClaimResponse$AdjudicationComponent";
    }
}
