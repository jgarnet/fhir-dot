package org.fhirdot.dictionaries.r4.elements;

import org.fhirdot.dictionaries.framework.AbstractDefinition;
import org.hl7.fhir.r4.model.Base;
import org.hl7.fhir.r4.model.CodeableConcept;

public class CodeableConceptDefinition extends AbstractDefinition<Base> {
    @Override
    protected void initialize() {
        this.paths.putAll(new ElementDefinition().getPaths());
        // coding
        this.paths.put("coding", arg -> ((CodeableConcept) arg).getCoding());
        // codingFirstRep
        this.paths.put("codingFirstRep", arg -> ((CodeableConcept) arg).getCodingFirstRep());
        // text
        this.paths.put("text", arg -> ((CodeableConcept) arg).getTextElement());
    }

    @Override
    public String getName() {
        return "CodeableConcept";
    }
}
