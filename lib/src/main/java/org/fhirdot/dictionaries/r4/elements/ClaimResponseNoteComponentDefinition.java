package org.fhirdot.dictionaries.r4.elements;

import org.fhirdot.dictionaries.framework.AbstractDefinition;
import org.hl7.fhir.r4.model.Base;
import org.hl7.fhir.r4.model.ClaimResponse;

public class ClaimResponseNoteComponentDefinition extends AbstractDefinition<Base, ClaimResponse.NoteComponent> {
    @Override
    protected void initialize() {
        this.putAllPaths(new BackboneElementDefinition().getPaths());
        // number
        this.putPath("number", ClaimResponse.NoteComponent::getNumberElement);
        // type
        this.putPath("type", ClaimResponse.NoteComponent::getType);
        // text
        this.putPath("text", ClaimResponse.NoteComponent::getTextElement);
        // language
        this.putPath("language", ClaimResponse.NoteComponent::getLanguage);
    }

    @Override
    public String getName() {
        return "ClaimResponse$NoteComponent";
    }
}
