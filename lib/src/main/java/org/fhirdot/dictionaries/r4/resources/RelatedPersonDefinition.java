package org.fhirdot.dictionaries.r4.resources;

import org.fhirdot.dictionaries.framework.AbstractDefinition;
import org.hl7.fhir.r4.model.Base;
import org.hl7.fhir.r4.model.RelatedPerson;

public class RelatedPersonDefinition extends AbstractDefinition<Base, RelatedPerson> {
    @Override
    protected void initialize() {
        this.putAllPaths(new DomainResourceDefinition().getPaths());
        this.putPath("identifier", RelatedPerson::getIdentifier);
        this.putPath("identifierFirstRep", RelatedPerson::getIdentifierFirstRep);
        this.putPath("active", RelatedPerson::getActiveElement);
        this.putPath("patient", RelatedPerson::getPatient);
        this.putPath("relationship", RelatedPerson::getRelationship);
        this.putPath("relationshipFirstRep", RelatedPerson::getRelationshipFirstRep);
        this.putPath("name", RelatedPerson::getName);
        this.putPath("nameFirstRep", RelatedPerson::getNameFirstRep);
        this.putPath("telecom", RelatedPerson::getTelecom);
        this.putPath("telecomFirstRep", RelatedPerson::getTelecomFirstRep);
        this.putPath("gender", RelatedPerson::getGender);
        this.putPath("birthDate", RelatedPerson::getBirthDateElement);
        this.putPath("address", RelatedPerson::getAddress);
        this.putPath("addressFirstRep", RelatedPerson::getAddressFirstRep);
        this.putPath("photo", RelatedPerson::getPhoto);
        this.putPath("photoFirstRep", RelatedPerson::getPhotoFirstRep);
        this.putPath("period", RelatedPerson::getPeriod);
        this.putPath("communication", RelatedPerson::getCommunication);
        this.putPath("communicationFirstRep", RelatedPerson::getCommunicationFirstRep);
    }

    @Override
    public String getName() {
        return "RelatedPerson";
    }
}
