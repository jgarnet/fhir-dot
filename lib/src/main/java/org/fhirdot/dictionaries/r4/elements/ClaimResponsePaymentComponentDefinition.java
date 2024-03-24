package org.fhirdot.dictionaries.r4.elements;

import org.fhirdot.dictionaries.framework.AbstractDefinition;
import org.hl7.fhir.r4.model.Base;
import org.hl7.fhir.r4.model.ClaimResponse;

public class ClaimResponsePaymentComponentDefinition extends AbstractDefinition<Base> {
    @Override
    protected void initialize() {
        this.paths.putAll(new BackboneElementDefinition().getPaths());
        // type
        this.paths.put("type", arg -> ((ClaimResponse.PaymentComponent) arg).getType());
        // adjustment
        this.paths.put("adjustment", arg -> ((ClaimResponse.PaymentComponent) arg).getAdjustment());
        // adjustmentReason
        this.paths.put("adjustmentReason", arg -> ((ClaimResponse.PaymentComponent) arg).getAdjustmentReason());
        // date
        this.paths.put("date", arg -> ((ClaimResponse.PaymentComponent) arg).getDateElement());
        // amount
        this.paths.put("amount", arg -> ((ClaimResponse.PaymentComponent) arg).getAmount());
        // identifier
        this.paths.put("identifier", arg -> ((ClaimResponse.PaymentComponent) arg).getIdentifier());
    }

    @Override
    public String getName() {
        return "ClaimResponse$PaymentComponent";
    }
}
