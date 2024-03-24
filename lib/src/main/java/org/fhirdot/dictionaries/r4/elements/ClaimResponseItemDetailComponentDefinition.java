package org.fhirdot.dictionaries.r4.elements;

import org.fhirdot.dictionaries.framework.AbstractDefinition;
import org.hl7.fhir.r4.model.Base;
import org.hl7.fhir.r4.model.ClaimResponse;

public class ClaimResponseItemDetailComponentDefinition extends AbstractDefinition<Base> {
    @Override
    protected void initialize() {
        this.paths.putAll(new BackboneElementDefinition().getPaths());
        // detailSequence
        this.paths.put("detailSequence", arg -> ((ClaimResponse.ItemDetailComponent) arg).getDetailSequenceElement());
        // noteNumber
        this.paths.put("noteNumber", arg -> ((ClaimResponse.ItemDetailComponent) arg).getNoteNumber());
        // adjudication
        this.paths.put("adjudication", arg -> ((ClaimResponse.ItemDetailComponent) arg).getAdjudication());
        this.paths.put("adjudicationFirstRep", arg -> ((ClaimResponse.ItemDetailComponent) arg).getAdjudicationFirstRep());
        // subDetail
        this.paths.put("subDetail", arg -> ((ClaimResponse.ItemDetailComponent) arg).getSubDetail());
        this.paths.put("subDetailFirstRep", arg -> ((ClaimResponse.ItemDetailComponent) arg).getSubDetailFirstRep());
    }

    @Override
    public String getName() {
        return "ClaimResponse$ItemDetailComponent";
    }
}
