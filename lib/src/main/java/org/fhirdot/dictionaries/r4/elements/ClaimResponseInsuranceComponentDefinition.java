package org.fhirdot.dictionaries.r4.elements;

import org.fhirdot.dictionaries.framework.AbstractDefinition;
import org.hl7.fhir.r4.model.Base;
import org.hl7.fhir.r4.model.ClaimResponse;

public class ClaimResponseInsuranceComponentDefinition extends AbstractDefinition<Base> {
    @Override
    protected void initialize() {
        this.paths.putAll(new BackboneElementDefinition().getPaths());
        this.paths.put("sequence", arg -> ((ClaimResponse.InsuranceComponent) arg).getSequenceElement());
        this.paths.put("focal", arg -> ((ClaimResponse.InsuranceComponent) arg).getFocalElement());
        this.paths.put("coverage", arg -> ((ClaimResponse.InsuranceComponent) arg).getCoverage());
        this.paths.put("coverageTarget", arg -> ((ClaimResponse.InsuranceComponent) arg).getCoverage().getResource());
        this.paths.put("businessArrangement", arg -> ((ClaimResponse.InsuranceComponent) arg).getBusinessArrangementElement());
        this.paths.put("claimResponse", arg -> ((ClaimResponse.InsuranceComponent) arg).getClaimResponse());
        this.paths.put("claimResponseTarget", arg -> ((ClaimResponse.InsuranceComponent) arg).getClaimResponseTarget());
    }

    @Override
    public String getName() {
        return "ClaimResponse$InsuranceComponent";
    }
}
