package org.fhirpath.dictionaries.r4.elements;

import org.fhirpath.dictionaries.framework.AbstractDefinition;
import org.hl7.fhir.r4.model.Base;
import org.hl7.fhir.r4.model.ClaimResponse;

public class ClaimResponseNoteComponentDefinition extends AbstractDefinition<Base> {
    @Override
    protected void initialize() {
        this.paths.putAll(new BackboneElementDefinition().getPaths());
        // number
        this.paths.put("number", arg -> ((ClaimResponse.NoteComponent) arg).getNumberElement());
        // type
        this.paths.put("type", arg -> ((ClaimResponse.NoteComponent) arg).getType());
        // text
        this.paths.put("text", arg -> ((ClaimResponse.NoteComponent) arg).getTextElement());
        // language
        this.paths.put("language", arg -> ((ClaimResponse.NoteComponent) arg).getLanguage());
    }

    @Override
    public String getName() {
        return "ClaimResponse$NoteComponent";
    }
}
