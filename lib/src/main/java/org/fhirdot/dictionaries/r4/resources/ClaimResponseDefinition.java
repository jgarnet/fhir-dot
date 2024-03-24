package org.fhirdot.dictionaries.r4.resources;

import org.fhirdot.dictionaries.framework.AbstractDefinition;
import org.hl7.fhir.r4.model.Base;
import org.hl7.fhir.r4.model.ClaimResponse;

public class ClaimResponseDefinition extends AbstractDefinition<Base, ClaimResponse> {
    @Override
    protected void initialize() {
        this.putAllPaths(new DomainResourceDefinition().getPaths());
        // identifier
        this.putPath("identifier", ClaimResponse::getIdentifier);
        // status
        this.putPath("status", ClaimResponse::getStatusElement);
        // type
        this.putPath("type", ClaimResponse::getType);
        // subType
        this.putPath("subType", ClaimResponse::getSubType);
        // use
        this.putPath("use", ClaimResponse::getUseElement);
        // patient
        this.putPath("patient", ClaimResponse::getPatient);
        this.putPath("patientTarget", arg -> arg.getPatient().getResource());
        // created
        this.putPath("created", ClaimResponse::getCreatedElement);
        // insurer
        this.putPath("insurer", ClaimResponse::getInsurer);
        this.putPath("insurerTarget", arg -> arg.getInsurer().getResource());
        // requestor
        this.putPath("requestor", ClaimResponse::getRequestor);
        this.putPath("requestorTarget", arg -> arg.getRequestor().getResource());
        // request
        this.putPath("request", ClaimResponse::getRequest);
        this.putPath("requestTarget", arg -> arg.getRequest().getResource());
        // outcome
        this.putPath("outcome", ClaimResponse::getOutcome);
        // disposition
        this.putPath("disposition", ClaimResponse::getDispositionElement);
        // preAuthRef
        this.putPath("preAuthRef", ClaimResponse::getPreAuthRefElement);
        // preAuthPeriod
        this.putPath("preAuthPeriod", ClaimResponse::getPreAuthPeriod);
        // payeeType
        this.putPath("payeeType", ClaimResponse::getPayeeType);
        // item
        this.putPath("item", ClaimResponse::getItem);
        this.putPath("itemFirstRep", ClaimResponse::getItemFirstRep);
        // addItem
        this.putPath("addItem", ClaimResponse::getAddItem);
        this.putPath("addItemFirstRep", ClaimResponse::getAddItemFirstRep);
        // adjudication
        this.putPath("adjudication", ClaimResponse::getAdjudication);
        this.putPath("adjudicationFirstRep", ClaimResponse::getAdjudicationFirstRep);
        // total
        this.putPath("total", ClaimResponse::getTotal);
        // payment
        this.putPath("payment", ClaimResponse::getPayment);
        // fundsReserve
        this.putPath("fundsReserve", ClaimResponse::getFundsReserve);
        // formCode
        this.putPath("formCode", ClaimResponse::getFormCode);
        // form
        this.putPath("form", ClaimResponse::getForm);
        // processNote
        this.putPath("processNote", ClaimResponse::getProcessNote);
        this.putPath("processNoteFirstRep", ClaimResponse::getProcessNoteFirstRep);
        // communicationRequest
        this.putPath("communicationRequest", ClaimResponse::getCommunicationRequest);
        this.putPath("communicationRequestFirstRep", ClaimResponse::getCommunicationRequestFirstRep);
        // insurance
        this.putPath("insurance", ClaimResponse::getInsurance);
        this.putPath("insuranceFirstRep", ClaimResponse::getInsuranceFirstRep);
        // error
        this.putPath("error", ClaimResponse::getError);
        this.putPath("errorFirstRep", ClaimResponse::getErrorFirstRep);
    }

    @Override
    public String getName() {
        return "ClaimResponse";
    }
}
