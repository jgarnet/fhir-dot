package org.fhirpath.dictionaries.r4.resources;

import org.fhirpath.dictionaries.framework.AbstractDefinition;
import org.hl7.fhir.r4.model.Base;
import org.hl7.fhir.r4.model.RelatedPerson;

public class RelatedPersonDefinition extends AbstractDefinition<Base> {
    @Override
    protected void initialize() {
        this.paths.putAll(new DomainResourceDefinition().getPaths());
        this.paths.put("identifier", arg -> ((RelatedPerson) arg).getIdentifier());
        this.paths.put("identifierFirstRep", arg -> ((RelatedPerson) arg).getIdentifierFirstRep());
        this.paths.put("active", arg -> ((RelatedPerson) arg).getActiveElement());
        this.paths.put("patient", arg -> ((RelatedPerson) arg).getPatient());
        this.paths.put("relationship", arg -> ((RelatedPerson) arg).getRelationship());
        this.paths.put("relationshipFirstRep", arg -> ((RelatedPerson) arg).getRelationshipFirstRep());
        this.paths.put("name", arg -> ((RelatedPerson) arg).getName());
        this.paths.put("nameFirstRep", arg -> ((RelatedPerson) arg).getNameFirstRep());
        this.paths.put("telecom", arg -> ((RelatedPerson) arg).getTelecom());
        this.paths.put("telecomFirstRep", arg -> ((RelatedPerson) arg).getTelecomFirstRep());
        this.paths.put("gender", arg -> ((RelatedPerson) arg).getGender());
        this.paths.put("birthDate", arg -> ((RelatedPerson) arg).getBirthDateElement());
        this.paths.put("address", arg -> ((RelatedPerson) arg).getAddress());
        this.paths.put("addressFirstRep", arg -> ((RelatedPerson) arg).getAddressFirstRep());
        this.paths.put("photo", arg -> ((RelatedPerson) arg).getPhoto());
        this.paths.put("photoFirstRep", arg -> ((RelatedPerson) arg).getPhotoFirstRep());
        this.paths.put("period", arg -> ((RelatedPerson) arg).getPeriod());
        this.paths.put("communication", arg -> ((RelatedPerson) arg).getCommunication());
        this.paths.put("communicationFirstRep", arg -> ((RelatedPerson) arg).getCommunicationFirstRep());
    }

    @Override
    public String getName() {
        return "RelatedPerson";
    }
}
