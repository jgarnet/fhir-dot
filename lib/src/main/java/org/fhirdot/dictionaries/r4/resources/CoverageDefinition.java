package org.fhirdot.dictionaries.r4.resources;

import org.fhirdot.dictionaries.framework.AbstractDefinition;
import org.hl7.fhir.r4.model.Base;
import org.hl7.fhir.r4.model.Coverage;

public class CoverageDefinition extends AbstractDefinition<Base, Coverage> {
    @Override
    protected void initialize() {
        this.putAllPaths(new DomainResourceDefinition().getPaths());
        this.putPath("identifier", Coverage::getIdentifier);
        this.putPath("identifierFirstRep", Coverage::getIdentifierFirstRep);
        this.putPath("status", Coverage::getStatus);
        this.putPath("type", Coverage::getType);
        this.putPath("policyHolder", Coverage::getPolicyHolder);
        this.putPath("subscriber", Coverage::getSubscriber);
        this.putPath("subscriberTarget", arg -> arg.getSubscriber().getResource());
        this.putPath("subscriberId", Coverage::getSubscriberIdElement);
        this.putPath("beneficiary", Coverage::getBeneficiary);
        this.putPath("dependent", Coverage::getDependentElement);
        this.putPath("relationship", Coverage::getRelationship);
        this.putPath("period", Coverage::getPeriod);
        this.putPath("payor", Coverage::getPayor);
        this.putPath("payorFirstRep", Coverage::getPayorFirstRep);
        this.putPath("class", Coverage::getClass_);
        this.putPath("classFirstRep", Coverage::getClass_FirstRep);
        this.putPath("order", Coverage::getOrderElement);
        this.putPath("network", Coverage::getNetworkElement);
        this.putPath("costToBeneficiary", Coverage::getCostToBeneficiary);
        this.putPath("costToBeneficiaryFirstRep", Coverage::getCostToBeneficiaryFirstRep);
        this.putPath("subrogation", Coverage::getSubrogationElement);
        this.putPath("contract", Coverage::getContract);
        this.putPath("contractFirstRep", Coverage::getContractFirstRep);
    }

    @Override
    public String getName() {
        return "Coverage";
    }
}
