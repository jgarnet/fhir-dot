package org.fhirdot.dictionaries.r4.elements;

import org.fhirdot.dictionaries.framework.AbstractDefinition;
import org.hl7.fhir.r4.model.Base;
import org.hl7.fhir.r4.model.ClaimResponse;

public class ClaimResponseSubDetailComponentDefinition extends AbstractDefinition<Base> {
    @Override
    protected void initialize() {
        this.paths.putAll(new BackboneElementDefinition().getPaths());
        // subDetailSequence
        this.paths.put("subDetailSequence", arg -> ((ClaimResponse.SubDetailComponent) arg).getSubDetailSequenceElement());
        // noteNumber
        this.paths.put("noteNumber", arg -> ((ClaimResponse.SubDetailComponent) arg).getNoteNumber());
        // adjudication
        this.paths.put("adjudication", arg -> ((ClaimResponse.SubDetailComponent) arg).getAdjudication());
        this.paths.put("adjudicationFirstRep", arg -> ((ClaimResponse.SubDetailComponent) arg).getAdjudicationFirstRep());
    }

    @Override
    public String getName() {
        return "ClaimResponse$SubDetailComponent";
    }
}
