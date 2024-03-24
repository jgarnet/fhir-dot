package org.fhirdot.dictionaries.r4.elements;

import org.fhirdot.dictionaries.framework.AbstractDefinition;
import org.hl7.fhir.r4.model.Base;
import org.hl7.fhir.r4.model.ClaimResponse;

public class ClaimResponseInsuranceComponentDefinition extends AbstractDefinition<Base, ClaimResponse.InsuranceComponent> {
    @Override
    protected void initialize() {
        this.putAllPaths(new BackboneElementDefinition().getPaths());
        this.putPath("sequence", ClaimResponse.InsuranceComponent::getSequenceElement);
        this.putPath("focal", ClaimResponse.InsuranceComponent::getFocalElement);
        this.putPath("coverage", ClaimResponse.InsuranceComponent::getCoverage);
        this.putPath("coverageTarget", arg -> arg.getCoverage().getResource());
        this.putPath("businessArrangement", ClaimResponse.InsuranceComponent::getBusinessArrangementElement);
        this.putPath("claimResponse", ClaimResponse.InsuranceComponent::getClaimResponse);
        this.putPath("claimResponseTarget", ClaimResponse.InsuranceComponent::getClaimResponseTarget);
    }

    @Override
    public String getName() {
        return "ClaimResponse$InsuranceComponent";
    }
}
