package org.fhirpath.dictionaries.r4.elements;

import org.fhirpath.dictionaries.framework.AbstractDefinitions;
import org.hl7.fhir.r4.model.Base;
import org.hl7.fhir.r4.model.ClaimResponse;

public class ClaimResponseInsuranceComponentDefinitions extends AbstractDefinitions<Base> {
    @Override
    protected void initialize() {
        this.definitions.putAll(new BackboneElementDefinitions().getDefinitions());
        this.definitions.put("sequence", arg -> ((ClaimResponse.InsuranceComponent) arg).getSequenceElement());
        this.definitions.put("focal", arg -> ((ClaimResponse.InsuranceComponent) arg).getFocalElement());
        this.definitions.put("coverage", arg -> ((ClaimResponse.InsuranceComponent) arg).getCoverage());
        this.definitions.put("coverageTarget", arg -> ((ClaimResponse.InsuranceComponent) arg).getCoverage().getResource());
        this.definitions.put("businessArrangement", arg -> ((ClaimResponse.InsuranceComponent) arg).getBusinessArrangementElement());
        this.definitions.put("claimResponse", arg -> ((ClaimResponse.InsuranceComponent) arg).getClaimResponse());
        this.definitions.put("claimResponseTarget", arg -> ((ClaimResponse.InsuranceComponent) arg).getClaimResponseTarget());
    }

    @Override
    public String getName() {
        return "ClaimResponse$InsuranceComponent";
    }
}
