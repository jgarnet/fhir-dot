package org.fhirdot.dictionaries.r4.resources;

import org.fhirdot.dictionaries.framework.AbstractDefinition;
import org.hl7.fhir.r4.model.Base;
import org.hl7.fhir.r4.model.ClaimResponse;

public class ClaimResponseDefinition extends AbstractDefinition<Base> {
    @Override
    protected void initialize() {
        this.paths.putAll(new DomainResourceDefinition().getPaths());
        // identifier
        this.paths.put("identifier", arg -> ((ClaimResponse) arg).getIdentifier());
        // status
        this.paths.put("status", arg -> ((ClaimResponse) arg).getStatusElement());
        // type
        this.paths.put("type", arg -> ((ClaimResponse) arg).getType());
        // subType
        this.paths.put("subType", arg -> ((ClaimResponse) arg).getSubType());
        // use
        this.paths.put("use", arg -> ((ClaimResponse) arg).getUseElement());
        // patient
        this.paths.put("patient", arg -> ((ClaimResponse) arg).getPatient());
        this.paths.put("patientTarget", arg -> ((ClaimResponse) arg).getPatient().getResource());
        // created
        this.paths.put("created", arg -> ((ClaimResponse) arg).getCreatedElement());
        // insurer
        this.paths.put("insurer", arg -> ((ClaimResponse) arg).getInsurer());
        this.paths.put("insurerTarget", arg -> ((ClaimResponse) arg).getInsurer().getResource());
        // requestor
        this.paths.put("requestor", arg -> ((ClaimResponse) arg).getRequestor());
        this.paths.put("requestorTarget", arg -> ((ClaimResponse) arg).getRequestor().getResource());
        // request
        this.paths.put("request", arg -> ((ClaimResponse) arg).getRequest());
        this.paths.put("requestTarget", arg -> ((ClaimResponse) arg).getRequest().getResource());
        // outcome
        this.paths.put("outcome", arg -> ((ClaimResponse) arg).getOutcome());
        // disposition
        this.paths.put("disposition", arg -> ((ClaimResponse) arg).getDispositionElement());
        // preAuthRef
        this.paths.put("preAuthRef", arg -> ((ClaimResponse) arg).getPreAuthRefElement());
        // preAuthPeriod
        this.paths.put("preAuthPeriod", arg -> ((ClaimResponse) arg).getPreAuthPeriod());
        // payeeType
        this.paths.put("payeeType", arg -> ((ClaimResponse) arg).getPayeeType());
        // item
        this.paths.put("item", arg -> ((ClaimResponse) arg).getItem());
        this.paths.put("itemFirstRep", arg -> ((ClaimResponse) arg).getItemFirstRep());
        // addItem
        this.paths.put("addItem", arg -> ((ClaimResponse) arg).getAddItem());
        this.paths.put("addItemFirstRep", arg -> ((ClaimResponse) arg).getAddItemFirstRep());
        // adjudication
        this.paths.put("adjudication", arg -> ((ClaimResponse) arg).getAdjudication());
        this.paths.put("adjudicationFirstRep", arg -> ((ClaimResponse) arg).getAdjudicationFirstRep());
        // total
        this.paths.put("total", arg -> ((ClaimResponse) arg).getTotal());
        // payment
        this.paths.put("payment", arg -> ((ClaimResponse) arg).getPayment());
        // fundsReserve
        this.paths.put("fundsReserve", arg -> ((ClaimResponse) arg).getFundsReserve());
        // formCode
        this.paths.put("formCode", arg -> ((ClaimResponse) arg).getFormCode());
        // form
        this.paths.put("form", arg -> ((ClaimResponse) arg).getForm());
        // processNote
        this.paths.put("processNote", arg -> ((ClaimResponse) arg).getProcessNote());
        this.paths.put("processNoteFirstRep", arg -> ((ClaimResponse) arg).getProcessNoteFirstRep());
        // communicationRequest
        this.paths.put("communicationRequest", arg -> ((ClaimResponse) arg).getCommunicationRequest());
        this.paths.put("communicationRequestFirstRep", arg -> ((ClaimResponse) arg).getCommunicationRequestFirstRep());
        // insurance
        this.paths.put("insurance", arg -> ((ClaimResponse) arg).getInsurance());
        this.paths.put("insuranceFirstRep", arg -> ((ClaimResponse) arg).getInsuranceFirstRep());
        // error
        this.paths.put("error", arg -> ((ClaimResponse) arg).getError());
        this.paths.put("errorFirstRep", arg -> ((ClaimResponse) arg).getErrorFirstRep());
    }

    @Override
    public String getName() {
        return "ClaimResponse";
    }
}
