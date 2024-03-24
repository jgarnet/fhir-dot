package org.fhirdot.dictionaries.r4.elements;

import org.fhirdot.dictionaries.framework.AbstractDefinition;
import org.hl7.fhir.r4.model.Base;
import org.hl7.fhir.r4.model.Practitioner;

public class PractitionerQualificationComponentDefinition extends AbstractDefinition<Base, Practitioner.PractitionerQualificationComponent> {
    @Override
    protected void initialize() {
        this.putAllPaths(new BackboneElementDefinition().getPaths());
        // identifier
        this.putPath("identifier", Practitioner.PractitionerQualificationComponent::getIdentifier);
        this.putPath("identifierFirstRep", Practitioner.PractitionerQualificationComponent::getIdentifierFirstRep);
        // code
        this.putPath("code", Practitioner.PractitionerQualificationComponent::getCode);
        // period
        this.putPath("period", Practitioner.PractitionerQualificationComponent::getPeriod);
        // issuer
        this.putPath("issuer", Practitioner.PractitionerQualificationComponent::getIssuer);
    }

    @Override
    public String getName() {
        return "Practitioner$PractitionerQualificationComponent";
    }
}
