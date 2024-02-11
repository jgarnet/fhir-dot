package org.fhirpath.dictionaries.r4.resources;

import org.fhirpath.dictionaries.framework.AbstractDefinitions;
import org.hl7.fhir.r4.model.Base;
import org.hl7.fhir.r4.model.ClaimResponse;

public class ClaimResponseDefinitions extends AbstractDefinitions<Base> {
    @Override
    protected void initialize() {
        this.definitions.putAll(new DomainResourceDefinitions().getDefinitions());
        // identifier
        this.definitions.put("identifier", arg -> ((ClaimResponse) arg).getIdentifier());
        // status
        this.definitions.put("status", arg -> ((ClaimResponse) arg).getStatusElement());
        // type
        this.definitions.put("type", arg -> ((ClaimResponse) arg).getType());
        // subType
        this.definitions.put("subType", arg -> ((ClaimResponse) arg).getSubType());
        // use
        this.definitions.put("use", arg -> ((ClaimResponse) arg).getUseElement());
        // patient
        this.definitions.put("patient", arg -> ((ClaimResponse) arg).getPatient());
        this.definitions.put("patientTarget", arg -> ((ClaimResponse) arg).getPatient().getResource());
        // created
        this.definitions.put("created", arg -> ((ClaimResponse) arg).getCreatedElement());
        // insurer
        this.definitions.put("insurer", arg -> ((ClaimResponse) arg).getInsurer());
        // requestor
        this.definitions.put("requestor", arg -> ((ClaimResponse) arg).getRequestor());
        // request
        this.definitions.put("request", arg -> ((ClaimResponse) arg).getRequest());
        // outcome
        this.definitions.put("outcome", arg -> ((ClaimResponse) arg).getOutcome());
        // disposition
        this.definitions.put("disposition", arg -> ((ClaimResponse) arg).getDispositionElement());
        // preAuthRef
        this.definitions.put("preAuthRef", arg -> ((ClaimResponse) arg).getPreAuthRefElement());
        // preAuthPeriod
        this.definitions.put("preAuthPeriod", arg -> ((ClaimResponse) arg).getPreAuthPeriod());
        // payeeType
        this.definitions.put("payeeType", arg -> ((ClaimResponse) arg).getPayeeType());
        // item
        this.definitions.put("item", arg -> ((ClaimResponse) arg).getItem());
        // addItem
        this.definitions.put("addItem", arg -> ((ClaimResponse) arg).getAddItem());
        // adjudication
        this.definitions.put("adjudication", arg -> ((ClaimResponse) arg).getAdjudication());
        // total
        this.definitions.put("total", arg -> ((ClaimResponse) arg).getTotal());
        // payment
        this.definitions.put("payment", arg -> ((ClaimResponse) arg).getPayment());
        // fundsReserve
        this.definitions.put("fundsReserve", arg -> ((ClaimResponse) arg).getFundsReserve());
        // formCode
        this.definitions.put("formCode", arg -> ((ClaimResponse) arg).getFormCode());
        // form
        this.definitions.put("form", arg -> ((ClaimResponse) arg).getForm());
        // processNote
        this.definitions.put("processNote", arg -> ((ClaimResponse) arg).getProcessNote());
        // communicationRequest
        this.definitions.put("communicationRequest", arg -> ((ClaimResponse) arg).getCommunicationRequest());
        // insurance
        this.definitions.put("insurance", arg -> ((ClaimResponse) arg).getInsurance());
        // error
        this.definitions.put("error", arg -> ((ClaimResponse) arg).getError());
    }

    @Override
    public String getName() {
        return "ClaimResponse";
    }
}
