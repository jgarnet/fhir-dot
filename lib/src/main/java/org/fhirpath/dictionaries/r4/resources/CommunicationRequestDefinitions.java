package org.fhirpath.dictionaries.r4.resources;

import org.fhirpath.dictionaries.framework.AbstractDefinitions;
import org.hl7.fhir.r4.model.Base;
import org.hl7.fhir.r4.model.CommunicationRequest;

public class CommunicationRequestDefinitions extends AbstractDefinitions<Base> {
    @Override
    protected void initialize() {
        this.definitions.putAll(new DomainResourceDefinitions().getDefinitions());
        this.definitions.put("category", arg -> ((CommunicationRequest) arg).getCategory());
        this.definitions.put("categoryFirstRep", arg -> ((CommunicationRequest) arg).getCategoryFirstRep());
        this.definitions.put("identifier", arg -> ((CommunicationRequest) arg).getIdentifier());
        this.definitions.put("identifierFirstRep", arg -> ((CommunicationRequest) arg).getIdentifierFirstRep());
        this.definitions.put("medium", arg -> ((CommunicationRequest) arg).getMedium());
        this.definitions.put("mediumFirstRep", arg -> ((CommunicationRequest) arg).getMediumFirstRep());
    }

    @Override
    public String getName() {
        return "CommunicationRequest";
    }
}
