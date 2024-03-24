package org.fhirdot.dictionaries.r4.resources;

import org.fhirdot.dictionaries.framework.AbstractDefinition;
import org.hl7.fhir.r4.model.Base;
import org.hl7.fhir.r4.model.CommunicationRequest;

public class CommunicationRequestDefinition extends AbstractDefinition<Base, CommunicationRequest> {
    @Override
    protected void initialize() {
        this.putAllPaths(new DomainResourceDefinition().getPaths());
        this.putPath("category", CommunicationRequest::getCategory);
        this.putPath("categoryFirstRep", CommunicationRequest::getCategoryFirstRep);
        this.putPath("identifier", CommunicationRequest::getIdentifier);
        this.putPath("identifierFirstRep", CommunicationRequest::getIdentifierFirstRep);
        this.putPath("medium", CommunicationRequest::getMedium);
        this.putPath("mediumFirstRep", CommunicationRequest::getMediumFirstRep);
    }

    @Override
    public String getName() {
        return "CommunicationRequest";
    }
}
