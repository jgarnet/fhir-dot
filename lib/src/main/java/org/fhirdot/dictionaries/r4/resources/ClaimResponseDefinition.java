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
        // requestor
        this.paths.put("requestor", arg -> ((ClaimResponse) arg).getRequestor());
        // request
        this.paths.put("request", arg -> ((ClaimResponse) arg).getRequest());
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
        // addItem
        this.paths.put("addItem", arg -> ((ClaimResponse) arg).getAddItem());
        // adjudication
        this.paths.put("adjudication", arg -> ((ClaimResponse) arg).getAdjudication());
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
        // communicationRequest
        this.paths.put("communicationRequest", arg -> ((ClaimResponse) arg).getCommunicationRequest());
        // insurance
        this.paths.put("insurance", arg -> ((ClaimResponse) arg).getInsurance());
        // error
        this.paths.put("error", arg -> ((ClaimResponse) arg).getError());
    }

    @Override
    public String getName() {
        return "ClaimResponse";
    }
}
