package org.fhirpath.dictionaries.r4.elements;

import org.fhirpath.dictionaries.framework.AbstractDefinitions;
import org.hl7.fhir.r4.model.Base;
import org.hl7.fhir.r4.model.ClaimResponse;

public class ClaimResponseErrorComponentDefinitions extends AbstractDefinitions<Base> {
    @Override
    protected void initialize() {
        this.definitions.putAll(new BackboneElementDefinitions().getDefinitions());
        this.definitions.put("itemSequence", arg -> ((ClaimResponse.ErrorComponent) arg).getItemSequenceElement());
        this.definitions.put("detailSequence", arg -> ((ClaimResponse.ErrorComponent) arg).getDetailSequenceElement());
        this.definitions.put("subDetailSequence", arg -> ((ClaimResponse.ErrorComponent) arg).getSubDetailSequenceElement());
        this.definitions.put("code", arg -> ((ClaimResponse.ErrorComponent) arg).getCode());
    }

    @Override
    public String getName() {
        return "ClaimResponse$ErrorComponent";
    }
}
