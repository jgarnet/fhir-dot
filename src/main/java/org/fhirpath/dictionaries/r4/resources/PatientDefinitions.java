package org.fhirpath.dictionaries.r4.resources;

import org.fhirpath.dictionaries.framework.AbstractDefinitions;
import org.hl7.fhir.r4.model.Base;
import org.hl7.fhir.r4.model.Patient;

public class PatientDefinitions extends AbstractDefinitions<Base> {
    @Override
    protected void initialize() {
        this.definitions.putAll(new DomainResourceDefinitions().getDefinitions());
        this.definitions.put("identifier", arg -> ((Patient) arg).getIdentifier());
        this.definitions.put("identifierFirstRep", arg -> ((Patient) arg).getIdentifierFirstRep());
        this.definitions.put("active", arg -> ((Patient) arg).getActiveElement());
        this.definitions.put("name", arg -> ((Patient) arg).getName());
        this.definitions.put("nameFirstRep", arg -> ((Patient) arg).getNameFirstRep());
        this.definitions.put("telecom", arg -> ((Patient) arg).getTelecom());
        this.definitions.put("telecomFirstRep", arg -> ((Patient) arg).getTelecomFirstRep());
        this.definitions.put("gender", arg -> ((Patient) arg).getGender());
        this.definitions.put("birthDate", arg -> ((Patient) arg).getBirthDateElement());
        this.definitions.put("address", arg -> ((Patient) arg).getAddress());
        this.definitions.put("addressFirstRep", arg -> ((Patient) arg).getAddressFirstRep());
        this.definitions.put("photo", arg -> ((Patient) arg).getPhoto());
        this.definitions.put("photoFirstRep", arg -> ((Patient) arg).getPhotoFirstRep());
        this.definitions.put("communication", arg -> ((Patient) arg).getCommunication());
        this.definitions.put("communicationFirstRep", arg -> ((Patient) arg).getCommunicationFirstRep());
    }

    @Override
    public String getName() {
        return "Patient";
    }
}
