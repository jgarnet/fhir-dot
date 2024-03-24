package org.fhirdot.dictionaries.r4.elements;

import org.fhirdot.dictionaries.framework.AbstractDefinition;
import org.hl7.fhir.r4.model.Base;
import org.hl7.fhir.r4.model.CodeableConcept;

public class CodeableConceptDefinition extends AbstractDefinition<Base, CodeableConcept> {
    @Override
    protected void initialize() {
        this.putAllPaths(new ElementDefinition().getPaths());
        // coding
        this.putPath("coding", CodeableConcept::getCoding);
        // codingFirstRep
        this.putPath("codingFirstRep", CodeableConcept::getCodingFirstRep);
        // text
        this.putPath("text", CodeableConcept::getTextElement);
    }

    @Override
    public String getName() {
        return "CodeableConcept";
    }
}
