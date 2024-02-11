package org.fhirpath.dictionaries.r4.elements;

import org.fhirpath.dictionaries.framework.AbstractDefinitions;
import org.hl7.fhir.r4.model.Base;
import org.hl7.fhir.r4.model.ClaimResponse;

public class ClaimResponseItemComponentDefinitions extends AbstractDefinitions<Base> {
    @Override
    protected void initialize() {
        this.definitions.putAll(new BackboneElementDefinitions().getDefinitions());
        // itemSequence
        this.definitions.put("itemSequence", arg -> ((ClaimResponse.ItemComponent) arg).getItemSequenceElement());
        // noteNumber
        this.definitions.put("noteNumber", arg -> ((ClaimResponse.ItemComponent) arg).getNoteNumber());
        // adjudication
        this.definitions.put("adjudication", arg -> ((ClaimResponse.ItemComponent) arg).getAdjudication());
        // detail
        this.definitions.put("detail", arg -> ((ClaimResponse.ItemComponent) arg).getDetail());
    }

    @Override
    public String getName() {
        return "ClaimResponse$ItemComponent";
    }
}
