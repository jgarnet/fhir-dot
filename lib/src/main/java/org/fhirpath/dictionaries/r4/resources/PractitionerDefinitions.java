package org.fhirpath.dictionaries.r4.resources;

import org.fhirpath.dictionaries.framework.AbstractDefinitions;
import org.hl7.fhir.r4.model.Base;
import org.hl7.fhir.r4.model.Practitioner;

public class PractitionerDefinitions extends AbstractDefinitions<Base> {
    @Override
    protected void initialize() {
        this.definitions.putAll(new DomainResourceDefinitions().getDefinitions());
        // identifier
        this.definitions.put("identifier", arg -> ((Practitioner) arg).getIdentifier());
        this.definitions.put("identifierFirstRep", arg -> ((Practitioner) arg).getIdentifierFirstRep());
        // active
        this.definitions.put("active", arg -> ((Practitioner) arg).getActiveElement());
        // name
        this.definitions.put("name", arg -> ((Practitioner) arg).getName());
        this.definitions.put("nameFirstRep", arg -> ((Practitioner) arg).getNameFirstRep());
        // telecom
        this.definitions.put("telecom", arg -> ((Practitioner) arg).getTelecom());
        this.definitions.put("telecomFirstRep", arg -> ((Practitioner) arg).getTelecomFirstRep());
        // address
        this.definitions.put("address", arg -> ((Practitioner) arg).getAddress());
        this.definitions.put("addressFirstRep", arg -> ((Practitioner) arg).getAddressFirstRep());
        // gender
        this.definitions.put("gender", arg -> ((Practitioner) arg).getGender());
        // birthDate
        this.definitions.put("birthDate", arg -> ((Practitioner) arg).getBirthDateElement());
        // photo
        this.definitions.put("photo", arg -> ((Practitioner) arg).getPhoto());
        this.definitions.put("photoFirstRep", arg -> ((Practitioner) arg).getPhotoFirstRep());
        // qualification
        this.definitions.put("qualification", arg -> ((Practitioner) arg).getQualification());
        this.definitions.put("qualificationFirstRep", arg -> ((Practitioner) arg).getQualificationFirstRep());
        // communication
        this.definitions.put("communication", arg -> ((Practitioner) arg).getCommunication());
        this.definitions.put("communicationFirstRep", arg -> ((Practitioner) arg).getCommunicationFirstRep());
    }

    @Override
    public String getName() {
        return "Practitioner";
    }
}
