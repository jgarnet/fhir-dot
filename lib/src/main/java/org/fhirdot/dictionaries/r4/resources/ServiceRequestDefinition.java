package org.fhirdot.dictionaries.r4.resources;

import org.fhirdot.dictionaries.framework.AbstractDefinition;
import org.hl7.fhir.r4.model.Base;
import org.hl7.fhir.r4.model.ServiceRequest;

public class ServiceRequestDefinition extends AbstractDefinition<Base, ServiceRequest> {
    @Override
    protected void initialize() {
        this.putAllPaths(new DomainResourceDefinition().getPaths());
        this.putPath("quantityQuantity", ServiceRequest::getQuantityQuantity);
        this.putPath("occurrenceTiming", ServiceRequest::getOccurrenceTiming);
    }

    @Override
    public String getName() {
        return "ServiceRequest";
    }
}
