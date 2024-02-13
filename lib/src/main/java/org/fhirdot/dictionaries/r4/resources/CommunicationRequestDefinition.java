package org.fhirdot.dictionaries.r4.resources;

import org.fhirdot.dictionaries.framework.AbstractDefinition;
import org.hl7.fhir.r4.model.Base;
import org.hl7.fhir.r4.model.CommunicationRequest;

public class CommunicationRequestDefinition extends AbstractDefinition<Base> {
    @Override
    protected void initialize() {
        this.paths.putAll(new DomainResourceDefinition().getPaths());
        this.paths.put("category", arg -> ((CommunicationRequest) arg).getCategory());
        this.paths.put("categoryFirstRep", arg -> ((CommunicationRequest) arg).getCategoryFirstRep());
        this.paths.put("identifier", arg -> ((CommunicationRequest) arg).getIdentifier());
        this.paths.put("identifierFirstRep", arg -> ((CommunicationRequest) arg).getIdentifierFirstRep());
        this.paths.put("medium", arg -> ((CommunicationRequest) arg).getMedium());
        this.paths.put("mediumFirstRep", arg -> ((CommunicationRequest) arg).getMediumFirstRep());
    }

    @Override
    public String getName() {
        return "CommunicationRequest";
    }
}
