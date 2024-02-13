package org.fhirpath.dictionaries.r4.resources;

import org.fhirpath.dictionaries.framework.AbstractDefinition;
import org.hl7.fhir.r4.model.Base;
import org.hl7.fhir.r4.model.Patient;

public class PatientDefinition extends AbstractDefinition<Base> {
    @Override
    protected void initialize() {
        this.paths.putAll(new DomainResourceDefinition().getPaths());
        this.paths.put("identifier", arg -> ((Patient) arg).getIdentifier());
        this.paths.put("identifierFirstRep", arg -> ((Patient) arg).getIdentifierFirstRep());
        this.paths.put("active", arg -> ((Patient) arg).getActiveElement());
        this.paths.put("name", arg -> ((Patient) arg).getName());
        this.paths.put("nameFirstRep", arg -> ((Patient) arg).getNameFirstRep());
        this.paths.put("telecom", arg -> ((Patient) arg).getTelecom());
        this.paths.put("telecomFirstRep", arg -> ((Patient) arg).getTelecomFirstRep());
        this.paths.put("gender", arg -> ((Patient) arg).getGender());
        this.paths.put("birthDate", arg -> ((Patient) arg).getBirthDateElement());
        this.paths.put("address", arg -> ((Patient) arg).getAddress());
        this.paths.put("addressFirstRep", arg -> ((Patient) arg).getAddressFirstRep());
        this.paths.put("photo", arg -> ((Patient) arg).getPhoto());
        this.paths.put("photoFirstRep", arg -> ((Patient) arg).getPhotoFirstRep());
        this.paths.put("communication", arg -> ((Patient) arg).getCommunication());
        this.paths.put("communicationFirstRep", arg -> ((Patient) arg).getCommunicationFirstRep());
    }

    @Override
    public String getName() {
        return "Patient";
    }
}
