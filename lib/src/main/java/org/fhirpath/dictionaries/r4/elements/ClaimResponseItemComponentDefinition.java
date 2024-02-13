package org.fhirpath.dictionaries.r4.elements;

import org.fhirpath.dictionaries.framework.AbstractDefinition;
import org.hl7.fhir.r4.model.Base;
import org.hl7.fhir.r4.model.ClaimResponse;

public class ClaimResponseItemComponentDefinition extends AbstractDefinition<Base> {
    @Override
    protected void initialize() {
        this.paths.putAll(new BackboneElementDefinition().getPaths());
        // itemSequence
        this.paths.put("itemSequence", arg -> ((ClaimResponse.ItemComponent) arg).getItemSequenceElement());
        // noteNumber
        this.paths.put("noteNumber", arg -> ((ClaimResponse.ItemComponent) arg).getNoteNumber());
        // adjudication
        this.paths.put("adjudication", arg -> ((ClaimResponse.ItemComponent) arg).getAdjudication());
        // detail
        this.paths.put("detail", arg -> ((ClaimResponse.ItemComponent) arg).getDetail());
    }

    @Override
    public String getName() {
        return "ClaimResponse$ItemComponent";
    }
}
