package org.fhirdot.dictionaries.r4.elements;

import org.fhirdot.dictionaries.framework.AbstractDefinition;
import org.hl7.fhir.r4.model.Base;
import org.hl7.fhir.r4.model.ClaimResponse;

public class ClaimResponseTotalComponentDefinition extends AbstractDefinition<Base> {
    @Override
    protected void initialize() {
        this.paths.putAll(new BackboneElementDefinition().getPaths());
        // category
        this.paths.put("category", arg -> ((ClaimResponse.TotalComponent) arg).getCategory());
        // amount
        this.paths.put("amount", arg -> ((ClaimResponse.TotalComponent) arg).getAmount());
    }

    @Override
    public String getName() {
        return "ClaimResponse$TotalComponent";
    }
}
