package org.fhirpath.dictionaries.r4.elements;

import org.fhirpath.dictionaries.framework.AbstractDefinitions;
import org.hl7.fhir.r4.model.Base;
import org.hl7.fhir.r4.model.ClaimResponse;

public class ClaimResponseNoteComponentDefinitions extends AbstractDefinitions<Base> {
    @Override
    protected void initialize() {
        this.definitions.putAll(new BackboneElementDefinitions().getDefinitions());
        // number
        this.definitions.put("number", arg -> ((ClaimResponse.NoteComponent) arg).getNumberElement());
        // type
        this.definitions.put("type", arg -> ((ClaimResponse.NoteComponent) arg).getType());
        // text
        this.definitions.put("text", arg -> ((ClaimResponse.NoteComponent) arg).getTextElement());
        // language
        this.definitions.put("language", arg -> ((ClaimResponse.NoteComponent) arg).getLanguage());
    }

    @Override
    public String getName() {
        return "ClaimResponse$NoteComponent";
    }
}
