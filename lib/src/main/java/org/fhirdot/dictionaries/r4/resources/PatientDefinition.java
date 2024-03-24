package org.fhirdot.dictionaries.r4.resources;

import org.fhirdot.dictionaries.framework.AbstractDefinition;
import org.hl7.fhir.r4.model.Base;
import org.hl7.fhir.r4.model.Patient;

public class PatientDefinition extends AbstractDefinition<Base, Patient> {
    @Override
    protected void initialize() {
        this.putAllPaths(new DomainResourceDefinition().getPaths());
        this.putPath("identifier", Patient::getIdentifier);
        this.putPath("identifierFirstRep", Patient::getIdentifierFirstRep);
        this.putPath("active", Patient::getActiveElement);
        this.putPath("name", Patient::getName);
        this.putPath("nameFirstRep", Patient::getNameFirstRep);
        this.putPath("telecom", Patient::getTelecom);
        this.putPath("telecomFirstRep", Patient::getTelecomFirstRep);
        this.putPath("gender", Patient::getGender);
        this.putPath("birthDate", Patient::getBirthDateElement);
        this.putPath("address", Patient::getAddress);
        this.putPath("addressFirstRep", Patient::getAddressFirstRep);
        this.putPath("photo", Patient::getPhoto);
        this.putPath("photoFirstRep", Patient::getPhotoFirstRep);
        this.putPath("communication", Patient::getCommunication);
        this.putPath("communicationFirstRep", Patient::getCommunicationFirstRep);
    }

    @Override
    public String getName() {
        return "Patient";
    }
}
