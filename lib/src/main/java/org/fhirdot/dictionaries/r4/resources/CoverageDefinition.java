package org.fhirdot.dictionaries.r4.resources;

import org.fhirdot.dictionaries.framework.AbstractDefinition;
import org.hl7.fhir.r4.model.Base;
import org.hl7.fhir.r4.model.Coverage;

public class CoverageDefinition extends AbstractDefinition<Base> {
    @Override
    protected void initialize() {
        this.paths.putAll(new DomainResourceDefinition().getPaths());
        this.paths.put("identifier", arg -> ((Coverage) arg).getIdentifier());
        this.paths.put("identifierFirstRep", arg -> ((Coverage) arg).getIdentifierFirstRep());
        this.paths.put("status", arg -> ((Coverage) arg).getStatus());
        this.paths.put("type", arg -> ((Coverage) arg).getType());
        this.paths.put("policyHolder", arg -> ((Coverage) arg).getPolicyHolder());
        this.paths.put("subscriber", arg -> ((Coverage) arg).getSubscriber());
        this.paths.put("subscriberTarget", arg -> ((Coverage) arg).getSubscriber().getResource());
        this.paths.put("subscriberId", arg -> ((Coverage) arg).getSubscriberIdElement());
        this.paths.put("beneficiary", arg -> ((Coverage) arg).getBeneficiary());
        this.paths.put("dependent", arg -> ((Coverage) arg).getDependentElement());
        this.paths.put("relationship", arg -> ((Coverage) arg).getRelationship());
        this.paths.put("period", arg -> ((Coverage) arg).getPeriod());
        this.paths.put("payor", arg -> ((Coverage) arg).getPayor());
        this.paths.put("payorFirstRep", arg -> ((Coverage) arg).getPayorFirstRep());
        this.paths.put("class", arg -> ((Coverage) arg).getClass_());
        this.paths.put("classFirstRep", arg -> ((Coverage) arg).getClass_FirstRep());
        this.paths.put("order", arg -> ((Coverage) arg).getOrderElement());
        this.paths.put("network", arg -> ((Coverage) arg).getNetworkElement());
        this.paths.put("costToBeneficiary", arg -> ((Coverage) arg).getCostToBeneficiary());
        this.paths.put("costToBeneficiaryFirstRep", arg -> ((Coverage) arg).getCostToBeneficiaryFirstRep());
        this.paths.put("subrogation", arg -> ((Coverage) arg).getSubrogationElement());
        this.paths.put("contract", arg -> ((Coverage) arg).getContract());
        this.paths.put("contractFirstRep", arg -> ((Coverage) arg).getContractFirstRep());
    }

    @Override
    public String getName() {
        return "Coverage";
    }
}
