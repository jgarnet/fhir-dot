package org.fhirpath.dictionaries.r4.resources;

import org.fhirpath.dictionaries.framework.AbstractDefinition;
import org.hl7.fhir.r4.model.Base;
import org.hl7.fhir.r4.model.Practitioner;

public class PractitionerDefinition extends AbstractDefinition<Base> {
    @Override
    protected void initialize() {
        this.paths.putAll(new DomainResourceDefinition().getPaths());
        // identifier
        this.paths.put("identifier", arg -> ((Practitioner) arg).getIdentifier());
        this.paths.put("identifierFirstRep", arg -> ((Practitioner) arg).getIdentifierFirstRep());
        // active
        this.paths.put("active", arg -> ((Practitioner) arg).getActiveElement());
        // name
        this.paths.put("name", arg -> ((Practitioner) arg).getName());
        this.paths.put("nameFirstRep", arg -> ((Practitioner) arg).getNameFirstRep());
        // telecom
        this.paths.put("telecom", arg -> ((Practitioner) arg).getTelecom());
        this.paths.put("telecomFirstRep", arg -> ((Practitioner) arg).getTelecomFirstRep());
        // address
        this.paths.put("address", arg -> ((Practitioner) arg).getAddress());
        this.paths.put("addressFirstRep", arg -> ((Practitioner) arg).getAddressFirstRep());
        // gender
        this.paths.put("gender", arg -> ((Practitioner) arg).getGender());
        // birthDate
        this.paths.put("birthDate", arg -> ((Practitioner) arg).getBirthDateElement());
        // photo
        this.paths.put("photo", arg -> ((Practitioner) arg).getPhoto());
        this.paths.put("photoFirstRep", arg -> ((Practitioner) arg).getPhotoFirstRep());
        // qualification
        this.paths.put("qualification", arg -> ((Practitioner) arg).getQualification());
        this.paths.put("qualificationFirstRep", arg -> ((Practitioner) arg).getQualificationFirstRep());
        // communication
        this.paths.put("communication", arg -> ((Practitioner) arg).getCommunication());
        this.paths.put("communicationFirstRep", arg -> ((Practitioner) arg).getCommunicationFirstRep());
    }

    @Override
    public String getName() {
        return "Practitioner";
    }
}
