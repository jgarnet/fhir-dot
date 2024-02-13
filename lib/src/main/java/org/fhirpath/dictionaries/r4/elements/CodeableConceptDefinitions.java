package org.fhirpath.dictionaries.r4.elements;

import org.fhirpath.dictionaries.framework.AbstractDefinitions;
import org.hl7.fhir.r4.model.Base;
import org.hl7.fhir.r4.model.CodeableConcept;

public class CodeableConceptDefinitions extends AbstractDefinitions<Base> {
    @Override
    protected void initialize() {
        this.definitions.putAll(new ElementDefinitions().getDefinitions());
        // coding
        this.definitions.put("coding", arg -> ((CodeableConcept) arg).getCoding());
        // codingFirstRep
        this.definitions.put("codingFirstRep", arg -> ((CodeableConcept) arg).getCodingFirstRep());
        // text
        this.definitions.put("text", arg -> ((CodeableConcept) arg).getTextElement());
    }

    @Override
    public String getName() {
        return "CodeableConcept";
    }
}
