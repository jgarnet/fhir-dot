package org.fhirpath.dictionaries.r4.resources;

import org.fhirpath.dictionaries.framework.AbstractDefinitions;
import org.hl7.fhir.r4.model.Base;
import org.hl7.fhir.r4.model.Coverage;

public class CoverageDefinitions extends AbstractDefinitions<Base> {
    @Override
    protected void initialize() {
        this.definitions.putAll(new DomainResourceDefinitions().getDefinitions());
        this.definitions.put("identifier", arg -> ((Coverage) arg).getIdentifier());
        this.definitions.put("identifierFirstRep", arg -> ((Coverage) arg).getIdentifierFirstRep());
        this.definitions.put("status", arg -> ((Coverage) arg).getStatus());
        this.definitions.put("type", arg -> ((Coverage) arg).getType());
        this.definitions.put("policyHolder", arg -> ((Coverage) arg).getPolicyHolder());
        this.definitions.put("subscriber", arg -> ((Coverage) arg).getSubscriber());
        this.definitions.put("subscriberTarget", arg -> ((Coverage) arg).getSubscriber().getResource());
        this.definitions.put("subscriberId", arg -> ((Coverage) arg).getSubscriberIdElement());
        this.definitions.put("beneficiary", arg -> ((Coverage) arg).getBeneficiary());
        this.definitions.put("dependent", arg -> ((Coverage) arg).getDependentElement());
        this.definitions.put("relationship", arg -> ((Coverage) arg).getRelationship());
        this.definitions.put("period", arg -> ((Coverage) arg).getPeriod());
        this.definitions.put("payor", arg -> ((Coverage) arg).getPayor());
        this.definitions.put("payorFirstRep", arg -> ((Coverage) arg).getPayorFirstRep());
        this.definitions.put("class", arg -> ((Coverage) arg).getClass_());
        this.definitions.put("classFirstRep", arg -> ((Coverage) arg).getClass_FirstRep());
        this.definitions.put("order", arg -> ((Coverage) arg).getOrderElement());
        this.definitions.put("network", arg -> ((Coverage) arg).getNetworkElement());
        this.definitions.put("costToBeneficiary", arg -> ((Coverage) arg).getCostToBeneficiary());
        this.definitions.put("costToBeneficiaryFirstRep", arg -> ((Coverage) arg).getCostToBeneficiaryFirstRep());
        this.definitions.put("subrogation", arg -> ((Coverage) arg).getSubrogationElement());
        this.definitions.put("contract", arg -> ((Coverage) arg).getContract());
        this.definitions.put("contractFirstRep", arg -> ((Coverage) arg).getContractFirstRep());
    }

    @Override
    public String getName() {
        return "Coverage";
    }
}
