package org.fhirpath.dictionaries.r4.elements;

import org.fhirpath.dictionaries.framework.AbstractDefinitions;
import org.hl7.fhir.r4.model.Base;
import org.hl7.fhir.r4.model.Practitioner;

public class PractitionerQualificationComponentDefinitions extends AbstractDefinitions<Base> {
    @Override
    protected void initialize() {
        this.definitions.putAll(new BackboneElementDefinitions().getDefinitions());
        // identifier
        this.definitions.put("identifier", arg -> ((Practitioner.PractitionerQualificationComponent) arg).getIdentifier());
        this.definitions.put("identifierFirstRep", arg -> ((Practitioner.PractitionerQualificationComponent) arg).getIdentifierFirstRep());
        // code
        this.definitions.put("code", arg -> ((Practitioner.PractitionerQualificationComponent) arg).getCode());
        // period
        this.definitions.put("period", arg -> ((Practitioner.PractitionerQualificationComponent) arg).getPeriod());
        // issuer
        this.definitions.put("issuer", arg -> ((Practitioner.PractitionerQualificationComponent) arg).getIssuer());
    }

    @Override
    public String getName() {
        return "Practitioner$PractitionerQualificationComponent";
    }
}
