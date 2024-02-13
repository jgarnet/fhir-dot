package org.fhirpath.dictionaries.r4.resources;

import org.fhirpath.dictionaries.framework.AbstractDefinitions;
import org.hl7.fhir.r4.model.Base;
import org.hl7.fhir.r4.model.RelatedPerson;

public class RelatedPersonDefinitions extends AbstractDefinitions<Base> {
    @Override
    protected void initialize() {
        this.definitions.putAll(new DomainResourceDefinitions().getDefinitions());
        this.definitions.put("identifier", arg -> ((RelatedPerson) arg).getIdentifier());
        this.definitions.put("identifierFirstRep", arg -> ((RelatedPerson) arg).getIdentifierFirstRep());
        this.definitions.put("active", arg -> ((RelatedPerson) arg).getActiveElement());
        this.definitions.put("patient", arg -> ((RelatedPerson) arg).getPatient());
        this.definitions.put("relationship", arg -> ((RelatedPerson) arg).getRelationship());
        this.definitions.put("relationshipFirstRep", arg -> ((RelatedPerson) arg).getRelationshipFirstRep());
        this.definitions.put("name", arg -> ((RelatedPerson) arg).getName());
        this.definitions.put("nameFirstRep", arg -> ((RelatedPerson) arg).getNameFirstRep());
        this.definitions.put("telecom", arg -> ((RelatedPerson) arg).getTelecom());
        this.definitions.put("telecomFirstRep", arg -> ((RelatedPerson) arg).getTelecomFirstRep());
        this.definitions.put("gender", arg -> ((RelatedPerson) arg).getGender());
        this.definitions.put("birthDate", arg -> ((RelatedPerson) arg).getBirthDateElement());
        this.definitions.put("address", arg -> ((RelatedPerson) arg).getAddress());
        this.definitions.put("addressFirstRep", arg -> ((RelatedPerson) arg).getAddressFirstRep());
        this.definitions.put("photo", arg -> ((RelatedPerson) arg).getPhoto());
        this.definitions.put("photoFirstRep", arg -> ((RelatedPerson) arg).getPhotoFirstRep());
        this.definitions.put("period", arg -> ((RelatedPerson) arg).getPeriod());
        this.definitions.put("communication", arg -> ((RelatedPerson) arg).getCommunication());
        this.definitions.put("communicationFirstRep", arg -> ((RelatedPerson) arg).getCommunicationFirstRep());
    }

    @Override
    public String getName() {
        return "RelatedPerson";
    }
}
