package org.fhirpath.dictionaries.r4.resources;

import org.fhirpath.dictionaries.framework.AbstractDefinitions;
import org.hl7.fhir.r4.model.Base;
import org.hl7.fhir.r4.model.ServiceRequest;

public class ServiceRequestDefinitions extends AbstractDefinitions<Base> {
    @Override
    protected void initialize() {
        this.definitions.putAll(new DomainResourceDefinitions().getDefinitions());
        this.definitions.put("quantityQuantity", arg -> ((ServiceRequest) arg).getQuantityQuantity());
        this.definitions.put("occurrenceTiming", arg -> ((ServiceRequest) arg).getOccurrenceTiming());
    }

    @Override
    public String getName() {
        return "ServiceRequest";
    }
}
