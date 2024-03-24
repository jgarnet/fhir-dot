package org.fhirdot.dictionaries.r4.resources;

import org.fhirdot.dictionaries.framework.AbstractDefinition;
import org.hl7.fhir.r4.model.Base;
import org.hl7.fhir.r4.model.Practitioner;

public class PractitionerDefinition extends AbstractDefinition<Base, Practitioner> {
    @Override
    protected void initialize() {
        this.putAllPaths(new DomainResourceDefinition().getPaths());
        // identifier
        this.putPath("identifier", Practitioner::getIdentifier);
        this.putPath("identifierFirstRep", Practitioner::getIdentifierFirstRep);
        // active
        this.putPath("active", Practitioner::getActiveElement);
        // name
        this.putPath("name", Practitioner::getName);
        this.putPath("nameFirstRep", Practitioner::getNameFirstRep);
        // telecom
        this.putPath("telecom", Practitioner::getTelecom);
        this.putPath("telecomFirstRep", Practitioner::getTelecomFirstRep);
        // address
        this.putPath("address", Practitioner::getAddress);
        this.putPath("addressFirstRep", Practitioner::getAddressFirstRep);
        // gender
        this.putPath("gender", Practitioner::getGender);
        // birthDate
        this.putPath("birthDate", Practitioner::getBirthDateElement);
        // photo
        this.putPath("photo", Practitioner::getPhoto);
        this.putPath("photoFirstRep", Practitioner::getPhotoFirstRep);
        // qualification
        this.putPath("qualification", Practitioner::getQualification);
        this.putPath("qualificationFirstRep", Practitioner::getQualificationFirstRep);
        // communication
        this.putPath("communication", Practitioner::getCommunication);
        this.putPath("communicationFirstRep", Practitioner::getCommunicationFirstRep);
    }

    @Override
    public String getName() {
        return "Practitioner";
    }
}
