package org.fhirdot.dictionaries.r4.elements;

import org.fhirdot.dictionaries.framework.AbstractDefinition;
import org.hl7.fhir.r4.model.Base;
import org.hl7.fhir.r4.model.ClaimResponse;

public class ClaimResponsePaymentComponentDefinition extends AbstractDefinition<Base, ClaimResponse.PaymentComponent> {
    @Override
    protected void initialize() {
        this.putAllPaths(new BackboneElementDefinition().getPaths());
        // type
        this.putPath("type", ClaimResponse.PaymentComponent::getType);
        // adjustment
        this.putPath("adjustment", ClaimResponse.PaymentComponent::getAdjustment);
        // adjustmentReason
        this.putPath("adjustmentReason", ClaimResponse.PaymentComponent::getAdjustmentReason);
        // date
        this.putPath("date", ClaimResponse.PaymentComponent::getDateElement);
        // amount
        this.putPath("amount", ClaimResponse.PaymentComponent::getAmount);
        // identifier
        this.putPath("identifier", ClaimResponse.PaymentComponent::getIdentifier);
    }

    @Override
    public String getName() {
        return "ClaimResponse$PaymentComponent";
    }
}
