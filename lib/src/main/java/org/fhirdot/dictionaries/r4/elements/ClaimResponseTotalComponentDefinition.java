package org.fhirdot.dictionaries.r4.elements;

import org.fhirdot.dictionaries.framework.AbstractDefinition;
import org.hl7.fhir.r4.model.Base;
import org.hl7.fhir.r4.model.ClaimResponse;

public class ClaimResponseTotalComponentDefinition extends AbstractDefinition<Base, ClaimResponse.TotalComponent> {
    @Override
    protected void initialize() {
        this.putAllPaths(new BackboneElementDefinition().getPaths());
        // category
        this.putPath("category", ClaimResponse.TotalComponent::getCategory);
        // amount
        this.putPath("amount", ClaimResponse.TotalComponent::getAmount);
    }

    @Override
    public String getName() {
        return "ClaimResponse$TotalComponent";
    }
}
