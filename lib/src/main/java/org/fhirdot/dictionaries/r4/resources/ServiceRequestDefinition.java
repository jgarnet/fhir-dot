package org.fhirdot.dictionaries.r4.resources;

import org.fhirdot.dictionaries.framework.AbstractDefinition;
import org.hl7.fhir.r4.model.Base;
import org.hl7.fhir.r4.model.ServiceRequest;

public class ServiceRequestDefinition extends AbstractDefinition<Base> {
    @Override
    protected void initialize() {
        this.paths.putAll(new DomainResourceDefinition().getPaths());
        this.paths.put("quantityQuantity", arg -> ((ServiceRequest) arg).getQuantityQuantity());
        this.paths.put("occurrenceTiming", arg -> ((ServiceRequest) arg).getOccurrenceTiming());
    }

    @Override
    public String getName() {
        return "ServiceRequest";
    }
}
