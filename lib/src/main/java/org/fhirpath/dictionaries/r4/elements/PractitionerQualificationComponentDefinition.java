package org.fhirpath.dictionaries.r4.elements;

import org.fhirpath.dictionaries.framework.AbstractDefinition;
import org.hl7.fhir.r4.model.Base;
import org.hl7.fhir.r4.model.Practitioner;

public class PractitionerQualificationComponentDefinition extends AbstractDefinition<Base> {
    @Override
    protected void initialize() {
        this.paths.putAll(new BackboneElementDefinition().getPaths());
        // identifier
        this.paths.put("identifier", arg -> ((Practitioner.PractitionerQualificationComponent) arg).getIdentifier());
        this.paths.put("identifierFirstRep", arg -> ((Practitioner.PractitionerQualificationComponent) arg).getIdentifierFirstRep());
        // code
        this.paths.put("code", arg -> ((Practitioner.PractitionerQualificationComponent) arg).getCode());
        // period
        this.paths.put("period", arg -> ((Practitioner.PractitionerQualificationComponent) arg).getPeriod());
        // issuer
        this.paths.put("issuer", arg -> ((Practitioner.PractitionerQualificationComponent) arg).getIssuer());
    }

    @Override
    public String getName() {
        return "Practitioner$PractitionerQualificationComponent";
    }
}
