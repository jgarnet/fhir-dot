package org.fhirpath.dictionaries.r4.elements;

import org.fhirpath.dictionaries.framework.AbstractDefinition;
import org.hl7.fhir.r4.model.Base;
import org.hl7.fhir.r4.model.ClaimResponse;

public class ClaimResponseErrorComponentDefinition extends AbstractDefinition<Base> {
    @Override
    protected void initialize() {
        this.paths.putAll(new BackboneElementDefinition().getPaths());
        this.paths.put("itemSequence", arg -> ((ClaimResponse.ErrorComponent) arg).getItemSequenceElement());
        this.paths.put("detailSequence", arg -> ((ClaimResponse.ErrorComponent) arg).getDetailSequenceElement());
        this.paths.put("subDetailSequence", arg -> ((ClaimResponse.ErrorComponent) arg).getSubDetailSequenceElement());
        this.paths.put("code", arg -> ((ClaimResponse.ErrorComponent) arg).getCode());
    }

    @Override
    public String getName() {
        return "ClaimResponse$ErrorComponent";
    }
}
