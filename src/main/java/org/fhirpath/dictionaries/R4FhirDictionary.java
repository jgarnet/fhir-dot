package org.fhirpath.dictionaries;

import org.fhirpath.dictionaries.framework.Dictionary;
import org.fhirpath.dictionaries.framework.FhirDictionary;
import org.hl7.fhir.r4.model.*;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

@Dictionary(baseClass = Base.class)
public class R4FhirDictionary implements FhirDictionary<Base> {

    private Map<String, Map<String, Function<Base, Object>>> definitions;

    @Override
    public Map<String, Map<String, Function<Base, Object>>> getDefinitions() {
        if (this.definitions == null) {
            this.initDefinitions();
        }
        return this.definitions;
    }

    private void initDefinitions() {
        this.definitions = new HashMap<>();
        // Elements & Types
        this.definitions.put("Element", this.setElement());
        this.definitions.put("BackboneElement", this.setBackboneElement());
        this.definitions.put("Extension", this.setExtension());
        this.definitions.put("Reference", this.setReference());
        this.definitions.put("Identifier", this.setIdentifier());
        this.definitions.put("ContactPoint", this.setContactPoint());
        this.definitions.put("HumanName", this.setHumanName());
        this.definitions.put("CodeableConcept", this.setCodeableConcept());
        this.definitions.put("Coding", this.setCoding());
        this.definitions.put("Period", this.setPeriod());
        this.definitions.put("Address", this.setAddress());
        this.definitions.put("ContactDetail", this.setContactDetail());
        this.definitions.put("Quantity", this.setQuantity());
        this.definitions.put("Timing", this.setTiming());
        this.definitions.put("Timing$TimingRepeatComponent", this.setTimingRepeatComponent());
        this.definitions.put("Duration", this.setDuration());
        this.definitions.put("PrimitiveType", this.setPrimitiveType());
        this.definitions.put("PositiveIntType", this.setPositiveIntType());
        // Resources
        this.definitions.put("Resource", this.setResource());
        this.definitions.put("DomainResource", this.setDomainResource());
        // Bundle
        this.definitions.put("Bundle", this.setBundle());
        this.definitions.put("Bundle$BundleEntryComponent", this.setBundleEntryComponent());
        // Organization
        this.definitions.put("Organization", this.setOrganization());
        this.definitions.put("Organization$OrganizationContactComponent", this.setOrganizationContact());
        // Practitioner
        this.definitions.put("Practitioner", this.setPractitioner());
        this.definitions.put("Practitioner$PractitionerQualificationComponent", this.setPractitionerQualificationComponent());
        // ClaimResponse
        this.definitions.put("ClaimResponse", this.setClaimResponse());
        this.definitions.put("ClaimResponse$ItemComponent", this.setClaimResponseItemComponent());
        this.definitions.put("ClaimResponse$AdjudicationComponent", this.setClaimResponseAdjudicationComponent());
        this.definitions.put("ClaimResponse$NoteComponent", this.setClaimResponseNoteComponent());
        this.definitions.put("ClaimResponse$InsuranceComponent", this.setClaimResponseInsuranceComponent());
        this.definitions.put("ClaimResponse$ErrorComponent", this.setClaimResponseErrorComponent());
        // Coverage
        this.definitions.put("Coverage", this.setCoverage());
        // RelatedPerson
        this.definitions.put("RelatedPerson", this.setRelatedPerson());
        // Patient
        this.definitions.put("Patient", this.setPatient());
        // CommunicationRequest
        this.definitions.put("CommunicationRequest", this.setCommunicationRequest());
        // ServiceRequest
        this.definitions.put("ServiceRequest", this.setServiceRequest());
    }

    private Map<String, Function<Base, Object>> setResource() {
        Map<String, Function<Base, Object>> fields = new HashMap<>();
        // id
        fields.put("id", arg -> ((Resource) arg).getIdElement());
        // meta
        fields.put("meta", arg -> ((Resource) arg).getMeta());
        // implicitRules
        fields.put("implicitRules", arg -> ((Resource) arg).getImplicitRulesElement());
        // language
        fields.put("language", arg -> ((Resource) arg).getLanguageElement());
        // resourceType
        fields.put("resourceType", arg -> ((Resource) arg).getResourceType());
        return fields;
    }

    private Map<String, Function<Base, Object>> setDomainResource() {
        Map<String, Function<Base, Object>> fields = new HashMap<>(this.definitions.get("Resource"));
        // text
        fields.put("text", arg -> ((DomainResource) arg).getText());
        // contained
        fields.put("contained", arg -> ((DomainResource) arg).getContained());
        // extension
        fields.put("extension", arg -> ((DomainResource) arg).getExtension());
        // modifierExtension
        fields.put("modifierExtension", arg -> ((DomainResource) arg).getModifierExtension());
        return fields;
    }

    private Map<String, Function<Base, Object>> setElement() {
        Map<String, Function<Base, Object>> fields = new HashMap<>();
        // id
        fields.put("id", arg -> ((Element) arg).getIdElement());
        // extension
        fields.put("extension", arg -> ((Element) arg).getExtension());
        return fields;
    }

    private Map<String, Function<Base, Object>> setExtension() {
        Map<String, Function<Base, Object>> fields = new HashMap<>(this.definitions.get("Element"));
        // url
        fields.put("url", arg -> ((Extension) arg).getUrl());
        // value
        fields.put("value", arg -> ((Extension) arg).getValue());
        return fields;
    }

    private Map<String, Function<Base, Object>> setReference() {
        Map<String, Function<Base, Object>> fields = new HashMap<>(this.definitions.get("Element"));
        // reference
        fields.put("reference", arg -> ((Reference) arg).getReferenceElement_());
        // type
        fields.put("type", arg -> ((Reference) arg).getTypeElement());
        // identifier
        fields.put("identifier", arg -> ((Reference) arg).getIdentifier());
        // display
        fields.put("display", arg -> ((Reference) arg).getDisplayElement());
        // resource
        fields.put("resource", arg -> ((Reference) arg).getResource());
        return fields;
    }

    private Map<String, Function<Base, Object>> setIdentifier() {
        Map<String, Function<Base, Object>> fields = new HashMap<>(this.definitions.get("Element"));
        // use
        fields.put("use", arg -> ((Identifier) arg).getUse());
        // type
        fields.put("type", arg -> ((Identifier) arg).getType());
        // system
        fields.put("system", arg -> ((Identifier) arg).getSystemElement());
        // value
        fields.put("value", arg -> ((Identifier) arg).getValueElement());
        // period
        fields.put("period", arg -> ((Identifier) arg).getPeriod());
        return fields;
    }

    private Map<String, Function<Base, Object>> setContactPoint() {
        Map<String, Function<Base, Object>> fields = new HashMap<>(this.definitions.get("Element"));
        // system
        fields.put("system", arg -> ((ContactPoint) arg).getSystem());
        // value
        fields.put("value", arg -> ((ContactPoint) arg).getValueElement());
        // use
        fields.put("use", arg -> ((ContactPoint) arg).getUse());
        // rank
        fields.put("rank", arg -> ((ContactPoint) arg).getRankElement());
        // period
        fields.put("period", arg -> ((ContactPoint) arg).getPeriod());
        return fields;
    }

    private Map<String, Function<Base, Object>> setHumanName() {
        Map<String, Function<Base, Object>> fields = new HashMap<>(this.definitions.get("Element"));
        // use
        fields.put("use", arg -> ((HumanName) arg).getUse());
        // text
        fields.put("text", arg -> ((HumanName) arg).getTextElement());
        // family
        fields.put("family", arg -> ((HumanName) arg).getFamilyElement());
        // given
        fields.put("given", arg -> ((HumanName) arg).getGiven());
        // prefix
        fields.put("prefix", arg -> ((HumanName) arg).getPrefix());
        // suffix
        fields.put("suffix", arg -> ((HumanName) arg).getSuffix());
        // period
        fields.put("period", arg -> ((HumanName) arg).getPeriod());
        // nameAsSingleString
        fields.put("nameAsSingleString", arg -> ((HumanName) arg).getNameAsSingleString());
        // givenAsSingleString
        fields.put("givenAsSingleString", arg -> ((HumanName) arg).getGivenAsSingleString());
        // prefixAsSingleString
        fields.put("prefixAsSingleString", arg -> ((HumanName) arg).getPrefixAsSingleString());
        // suffixAsSingleString
        fields.put("suffixAsSingleString", arg -> ((HumanName) arg).getSuffixAsSingleString());
        return fields;
    }

    private Map<String, Function<Base, Object>> setCodeableConcept() {
        Map<String, Function<Base, Object>> fields = new HashMap<>(this.definitions.get("Element"));
        // coding
        fields.put("coding", arg -> ((CodeableConcept) arg).getCoding());
        // codingFirstRep
        fields.put("codingFirstRep", arg -> ((CodeableConcept) arg).getCodingFirstRep());
        // text
        fields.put("text", arg -> ((CodeableConcept) arg).getTextElement());
        return fields;
    }

    private Map<String, Function<Base, Object>> setCoding() {
        Map<String, Function<Base, Object>> fields = new HashMap<>(this.definitions.get("Element"));
        // system
        fields.put("system", arg -> ((Coding) arg).getSystemElement());
        // version
        fields.put("version", arg -> ((Coding) arg).getVersionElement());
        // code
        fields.put("code", arg -> ((Coding) arg).getCodeElement());
        // display
        fields.put("display", arg -> ((Coding) arg).getDisplayElement());
        // userSelected
        fields.put("userSelected", arg -> ((Coding) arg).getUserSelectedElement());
        return fields;
    }

    private Map<String, Function<Base, Object>> setPeriod() {
        Map<String, Function<Base, Object>> fields = new HashMap<>(this.definitions.get("Element"));
        // start
        fields.put("start", arg -> ((Period) arg).getStartElement());
        // end
        fields.put("end", arg -> ((Period) arg).getEndElement());
        return fields;
    }

    private Map<String, Function<Base, Object>> setAddress() {
        Map<String, Function<Base, Object>> fields = new HashMap<>(this.definitions.get("Element"));
        fields.put("use", arg -> ((Address) arg).getUse());
        fields.put("type", arg -> ((Address) arg).getType());
        fields.put("text", arg -> ((Address) arg).getTextElement());
        fields.put("line", arg -> ((Address) arg).getLine());
        fields.put("city", arg -> ((Address) arg).getCityElement());
        fields.put("district", arg -> ((Address) arg).getDistrictElement());
        fields.put("state", arg -> ((Address) arg).getStateElement());
        fields.put("postalCode", arg -> ((Address) arg).getPostalCodeElement());
        fields.put("country", arg -> ((Address) arg).getCountryElement());
        fields.put("period", arg -> ((Address) arg).getPeriod());
        return fields;
    }

    private Map<String, Function<Base, Object>> setContactDetail() {
        Map<String, Function<Base, Object>> fields = new HashMap<>(this.definitions.get("Element"));
        fields.put("name", arg -> ((ContactDetail) arg).getNameElement());
        fields.put("telecom", arg -> ((ContactDetail) arg).getTelecom());
        fields.put("telecomFirstRep", arg -> ((ContactDetail) arg).getTelecomFirstRep());
        return fields;
    }

    private Map<String, Function<Base, Object>> setQuantity() {
        Map<String, Function<Base, Object>> fields = new HashMap<>(this.definitions.get("Element"));
        fields.put("value", arg -> ((Quantity) arg).getValueElement());
        fields.put("comparator", arg -> ((Quantity) arg).getComparator());
        fields.put("unit", arg -> ((Quantity) arg).getUnitElement());
        fields.put("system", arg -> ((Quantity) arg).getSystemElement());
        fields.put("code", arg -> ((Quantity) arg).getCodeElement());
        return fields;
    }

    private Map<String, Function<Base, Object>> setTiming() {
        Map<String, Function<Base, Object>> fields = new HashMap<>(this.definitions.get("Element"));
        fields.put("repeat", arg -> ((Timing) arg).getRepeat());
        return fields;
    }

    private Map<String, Function<Base, Object>> setTimingRepeatComponent() {
        Map<String, Function<Base, Object>> fields = new HashMap<>(this.definitions.get("Element"));
        fields.put("boundsDuration", arg -> ((Timing.TimingRepeatComponent) arg).getBoundsDuration());
        fields.put("period", arg -> ((Timing.TimingRepeatComponent) arg).getPeriodElement());
        fields.put("periodUnit", arg -> ((Timing.TimingRepeatComponent) arg).getPeriodUnit());
        return fields;
    }

    private Map<String, Function<Base, Object>> setDuration() {
        Map<String, Function<Base, Object>> fields = new HashMap<>(this.definitions.get("Element"));
        fields.put("unit", arg -> ((Duration) arg).getUnitElement());
        fields.put("value", arg -> ((Duration) arg).getValueElement());
        return fields;
    }

    private Map<String, Function<Base, Object>> setPrimitiveType() {
        Map<String, Function<Base, Object>> fields = new HashMap<>(this.definitions.get("Element"));
        fields.put("value", arg -> ((PrimitiveType<?>) arg).getValue());
        return fields;
    }

    private Map<String, Function<Base, Object>> setPositiveIntType() {
        return new HashMap<>(this.definitions.get("PrimitiveType"));
    }

    private Map<String, Function<Base, Object>> setBackboneElement() {
        Map<String, Function<Base, Object>> fields = new HashMap<>(this.definitions.get("Element"));
        // extension
        fields.put("modifierExtension", arg -> ((BackboneElement) arg).getModifierExtension());
        return fields;
    }

    private Map<String, Function<Base, Object>> setBundle() {
        Map<String, Function<Base, Object>> fields = new HashMap<>(this.definitions.get("DomainResource"));
        // identifier
        fields.put("identifier", arg -> ((Bundle) arg).getIdentifier());
        // type
        fields.put("type", arg -> ((Bundle) arg).getType());
        // timestamp
        fields.put("timestamp", arg -> ((Bundle) arg).getTimestampElement());
        // total
        fields.put("total", arg -> ((Bundle) arg).getTotalElement());
        // link
        fields.put("link", arg -> ((Bundle) arg).getLink());
        // entry
        fields.put("entry", arg -> ((Bundle) arg).getEntry());
        // signature
        fields.put("signature", arg -> ((Bundle) arg).getSignature());
        return fields;
    }

    private Map<String, Function<Base, Object>> setBundleEntryComponent() {
        Map<String, Function<Base, Object>> fields = new HashMap<>(this.definitions.get("BackboneElement"));
        // resource
        fields.put("resource", arg -> ((Bundle.BundleEntryComponent) arg).getResource());
        return fields;
    }

    private Map<String, Function<Base, Object>> setOrganization() {
        Map<String, Function<Base, Object>> fields = new HashMap<>(this.definitions.get("DomainResource"));
        // identifier
        fields.put("identifier", arg -> ((Organization) arg).getIdentifier());
        // active
        fields.put("active", arg -> ((Organization) arg).getActiveElement());
        // type
        fields.put("type", arg -> ((Organization) arg).getType());
        // name
        fields.put("name", arg -> ((Organization) arg).getNameElement());
        // alias
        fields.put("alias", arg -> ((Organization) arg).getAlias());
        // telecom
        fields.put("telecom", arg -> ((Organization) arg).getTelecom());
        // address
        fields.put("address", arg -> ((Organization) arg).getAddress());
        // contact
        fields.put("contact", arg -> ((Organization) arg).getContact());
        return fields;
    }

    private Map<String, Function<Base, Object>> setOrganizationContact() {
        Map<String, Function<Base, Object>> fields = new HashMap<>(this.definitions.get("BackboneElement"));
        // purpose
        fields.put("purpose", arg -> ((Organization.OrganizationContactComponent) arg).getPurpose());
        // name
        fields.put("name", arg -> ((Organization.OrganizationContactComponent) arg).getName());
        // telecom
        fields.put("telecom", arg -> ((Organization.OrganizationContactComponent) arg).getTelecom());
        // address
        fields.put("address", arg -> ((Organization.OrganizationContactComponent) arg).getAddress());
        return fields;
    }

    private Map<String, Function<Base, Object>> setPractitioner() {
        Map<String, Function<Base, Object>> fields = new HashMap<>(this.definitions.get("DomainResource"));
        // identifier
        fields.put("identifier", arg -> ((Practitioner) arg).getIdentifier());
        fields.put("identifierFirstRep", arg -> ((Practitioner) arg).getIdentifierFirstRep());
        // active
        fields.put("active", arg -> ((Practitioner) arg).getActiveElement());
        // name
        fields.put("name", arg -> ((Practitioner) arg).getName());
        fields.put("nameFirstRep", arg -> ((Practitioner) arg).getNameFirstRep());
        // telecom
        fields.put("telecom", arg -> ((Practitioner) arg).getTelecom());
        fields.put("telecomFirstRep", arg -> ((Practitioner) arg).getTelecomFirstRep());
        // address
        fields.put("address", arg -> ((Practitioner) arg).getAddress());
        fields.put("addressFirstRep", arg -> ((Practitioner) arg).getAddressFirstRep());
        // gender
        fields.put("gender", arg -> ((Practitioner) arg).getGender());
        // birthDate
        fields.put("birthDate", arg -> ((Practitioner) arg).getBirthDateElement());
        // photo
        fields.put("photo", arg -> ((Practitioner) arg).getPhoto());
        fields.put("photoFirstRep", arg -> ((Practitioner) arg).getPhotoFirstRep());
        // qualification
        fields.put("qualification", arg -> ((Practitioner) arg).getQualification());
        fields.put("qualificationFirstRep", arg -> ((Practitioner) arg).getQualificationFirstRep());
        // communication
        fields.put("communication", arg -> ((Practitioner) arg).getCommunication());
        fields.put("communicationFirstRep", arg -> ((Practitioner) arg).getCommunicationFirstRep());
        return fields;
    }

    private Map<String, Function<Base, Object>> setPractitionerQualificationComponent() {
        Map<String, Function<Base, Object>> fields = new HashMap<>(this.definitions.get("BackboneElement"));
        // identifier
        fields.put("identifier", arg -> ((Practitioner.PractitionerQualificationComponent) arg).getIdentifier());
        fields.put("identifierFirstRep", arg -> ((Practitioner.PractitionerQualificationComponent) arg).getIdentifierFirstRep());
        // code
        fields.put("code", arg -> ((Practitioner.PractitionerQualificationComponent) arg).getCode());
        // period
        fields.put("period", arg -> ((Practitioner.PractitionerQualificationComponent) arg).getPeriod());
        // issuer
        fields.put("issuer", arg -> ((Practitioner.PractitionerQualificationComponent) arg).getIssuer());
        return fields;
    }

    /* ClaimResponse */

    private Map<String, Function<Base, Object>> setClaimResponse() {
        Map<String, Function<Base, Object>> fields = new HashMap<>(this.definitions.get("DomainResource"));
        // identifier
        fields.put("identifier", arg -> ((ClaimResponse) arg).getIdentifier());
        // status
        fields.put("status", arg -> ((ClaimResponse) arg).getStatusElement());
        // type
        fields.put("type", arg -> ((ClaimResponse) arg).getType());
        // subType
        fields.put("subType", arg -> ((ClaimResponse) arg).getSubType());
        // use
        fields.put("use", arg -> ((ClaimResponse) arg).getUseElement());
        // patient
        fields.put("patient", arg -> ((ClaimResponse) arg).getPatient());
        fields.put("patientTarget", arg -> ((ClaimResponse) arg).getPatient().getResource());
        // created
        fields.put("created", arg -> ((ClaimResponse) arg).getCreatedElement());
        // insurer
        fields.put("insurer", arg -> ((ClaimResponse) arg).getInsurer());
        // requestor
        fields.put("requestor", arg -> ((ClaimResponse) arg).getRequestor());
        // request
        fields.put("request", arg -> ((ClaimResponse) arg).getRequest());
        // outcome
        fields.put("outcome", arg -> ((ClaimResponse) arg).getOutcome());
        // disposition
        fields.put("disposition", arg -> ((ClaimResponse) arg).getDispositionElement());
        // preAuthRef
        fields.put("preAuthRef", arg -> ((ClaimResponse) arg).getPreAuthRefElement());
        // preAuthPeriod
        fields.put("preAuthPeriod", arg -> ((ClaimResponse) arg).getPreAuthPeriod());
        // payeeType
        fields.put("payeeType", arg -> ((ClaimResponse) arg).getPayeeType());
        // item
        fields.put("item", arg -> ((ClaimResponse) arg).getItem());
        // addItem
        fields.put("addItem", arg -> ((ClaimResponse) arg).getAddItem());
        // adjudication
        fields.put("adjudication", arg -> ((ClaimResponse) arg).getAdjudication());
        // total
        fields.put("total", arg -> ((ClaimResponse) arg).getTotal());
        // payment
        fields.put("payment", arg -> ((ClaimResponse) arg).getPayment());
        // fundsReserve
        fields.put("fundsReserve", arg -> ((ClaimResponse) arg).getFundsReserve());
        // formCode
        fields.put("formCode", arg -> ((ClaimResponse) arg).getFormCode());
        // form
        fields.put("form", arg -> ((ClaimResponse) arg).getForm());
        // processNote
        fields.put("processNote", arg -> ((ClaimResponse) arg).getProcessNote());
        // communicationRequest
        fields.put("communicationRequest", arg -> ((ClaimResponse) arg).getCommunicationRequest());
        // insurance
        fields.put("insurance", arg -> ((ClaimResponse) arg).getInsurance());
        // error
        fields.put("error", arg -> ((ClaimResponse) arg).getError());
        return fields;
    }

    private Map<String, Function<Base, Object>> setClaimResponseItemComponent() {
        Map<String, Function<Base, Object>> fields = new HashMap<>(this.definitions.get("BackboneElement"));
        // itemSequence
        fields.put("itemSequence", arg -> ((ClaimResponse.ItemComponent) arg).getItemSequenceElement());
        // noteNumber
        fields.put("noteNumber", arg -> ((ClaimResponse.ItemComponent) arg).getNoteNumber());
        // adjudication
        fields.put("adjudication", arg -> ((ClaimResponse.ItemComponent) arg).getAdjudication());
        // detail
        fields.put("detail", arg -> ((ClaimResponse.ItemComponent) arg).getDetail());
        return fields;
    }

    private Map<String, Function<Base, Object>> setClaimResponseAdjudicationComponent() {
        Map<String, Function<Base, Object>> fields = new HashMap<>(this.definitions.get("BackboneElement"));
        // category
        fields.put("category", arg -> ((ClaimResponse.AdjudicationComponent) arg).getCategory());
        // reason
        fields.put("reason", arg -> ((ClaimResponse.AdjudicationComponent) arg).getReason());
        // amount
        fields.put("amount", arg -> ((ClaimResponse.AdjudicationComponent) arg).getAmount());
        // value
        fields.put("value", arg -> ((ClaimResponse.AdjudicationComponent) arg).getValueElement());
        return fields;
    }

    private Map<String, Function<Base, Object>> setClaimResponseNoteComponent() {
        Map<String, Function<Base, Object>> fields = new HashMap<>(this.definitions.get("BackboneElement"));
        // number
        fields.put("number", arg -> ((ClaimResponse.NoteComponent) arg).getNumberElement());
        // type
        fields.put("type", arg -> ((ClaimResponse.NoteComponent) arg).getType());
        // text
        fields.put("text", arg -> ((ClaimResponse.NoteComponent) arg).getTextElement());
        // language
        fields.put("language", arg -> ((ClaimResponse.NoteComponent) arg).getLanguage());
        return fields;
    }

    private Map<String, Function<Base, Object>> setClaimResponseInsuranceComponent() {
        Map<String, Function<Base, Object>> fields = new HashMap<>(this.definitions.get("BackboneElement"));
        fields.put("sequence", arg -> ((ClaimResponse.InsuranceComponent) arg).getSequenceElement());
        fields.put("focal", arg -> ((ClaimResponse.InsuranceComponent) arg).getFocalElement());
        fields.put("coverage", arg -> ((ClaimResponse.InsuranceComponent) arg).getCoverage());
        fields.put("coverageTarget", arg -> ((ClaimResponse.InsuranceComponent) arg).getCoverage().getResource());
        fields.put("businessArrangement", arg -> ((ClaimResponse.InsuranceComponent) arg).getBusinessArrangementElement());
        fields.put("claimResponse", arg -> ((ClaimResponse.InsuranceComponent) arg).getClaimResponse());
        return fields;
    }

    private Map<String, Function<Base, Object>> setClaimResponseErrorComponent() {
        Map<String, Function<Base, Object>> fields = new HashMap<>(this.definitions.get("BackboneElement"));
        fields.put("itemSequence", arg -> ((ClaimResponse.ErrorComponent) arg).getItemSequenceElement());
        fields.put("detailSequence", arg -> ((ClaimResponse.ErrorComponent) arg).getDetailSequenceElement());
        fields.put("subDetailSequence", arg -> ((ClaimResponse.ErrorComponent) arg).getSubDetailSequenceElement());
        fields.put("code", arg -> ((ClaimResponse.ErrorComponent) arg).getCode());
        return fields;
    }

    /* Coverage */

    private Map<String, Function<Base, Object>> setCoverage() {
        Map<String, Function<Base, Object>> fields = new HashMap<>(this.definitions.get("DomainResource"));
        fields.put("identifier", arg -> ((Coverage) arg).getIdentifier());
        fields.put("identifierFirstRep", arg -> ((Coverage) arg).getIdentifierFirstRep());
        fields.put("status", arg -> ((Coverage) arg).getStatus());
        fields.put("type", arg -> ((Coverage) arg).getType());
        fields.put("policyHolder", arg -> ((Coverage) arg).getPolicyHolder());
        fields.put("subscriber", arg -> ((Coverage) arg).getSubscriber());
        fields.put("subscriberTarget", arg -> ((Coverage) arg).getSubscriber().getResource());
        fields.put("subscriberId", arg -> ((Coverage) arg).getSubscriberIdElement());
        fields.put("beneficiary", arg -> ((Coverage) arg).getBeneficiary());
        fields.put("dependent", arg -> ((Coverage) arg).getDependentElement());
        fields.put("relationship", arg -> ((Coverage) arg).getRelationship());
        fields.put("period", arg -> ((Coverage) arg).getPeriod());
        fields.put("payor", arg -> ((Coverage) arg).getPayor());
        fields.put("payorFirstRep", arg -> ((Coverage) arg).getPayorFirstRep());
        fields.put("class", arg -> ((Coverage) arg).getClass_());
        fields.put("classFirstRep", arg -> ((Coverage) arg).getClass_FirstRep());
        fields.put("order", arg -> ((Coverage) arg).getOrderElement());
        fields.put("network", arg -> ((Coverage) arg).getNetworkElement());
        fields.put("costToBeneficiary", arg -> ((Coverage) arg).getCostToBeneficiary());
        fields.put("costToBeneficiaryFirstRep", arg -> ((Coverage) arg).getCostToBeneficiaryFirstRep());
        fields.put("subrogation", arg -> ((Coverage) arg).getSubrogationElement());
        fields.put("contract", arg -> ((Coverage) arg).getContract());
        fields.put("contractFirstRep", arg -> ((Coverage) arg).getContractFirstRep());
        return fields;
    }

    /* RelatedPerson */

    private Map<String, Function<Base, Object>> setRelatedPerson() {
        Map<String, Function<Base, Object>> fields = new HashMap<>(this.definitions.get("DomainResource"));
        fields.put("identifier", arg -> ((RelatedPerson) arg).getIdentifier());
        fields.put("identifierFirstRep", arg -> ((RelatedPerson) arg).getIdentifierFirstRep());
        fields.put("active", arg -> ((RelatedPerson) arg).getActiveElement());
        fields.put("patient", arg -> ((RelatedPerson) arg).getPatient());
        fields.put("relationship", arg -> ((RelatedPerson) arg).getRelationship());
        fields.put("relationshipFirstRep", arg -> ((RelatedPerson) arg).getRelationshipFirstRep());
        fields.put("name", arg -> ((RelatedPerson) arg).getName());
        fields.put("nameFirstRep", arg -> ((RelatedPerson) arg).getNameFirstRep());
        fields.put("telecom", arg -> ((RelatedPerson) arg).getTelecom());
        fields.put("telecomFirstRep", arg -> ((RelatedPerson) arg).getTelecomFirstRep());
        fields.put("gender", arg -> ((RelatedPerson) arg).getGender());
        fields.put("birthDate", arg -> ((RelatedPerson) arg).getBirthDateElement());
        fields.put("address", arg -> ((RelatedPerson) arg).getAddress());
        fields.put("addressFirstRep", arg -> ((RelatedPerson) arg).getAddressFirstRep());
        fields.put("photo", arg -> ((RelatedPerson) arg).getPhoto());
        fields.put("photoFirstRep", arg -> ((RelatedPerson) arg).getPhotoFirstRep());
        fields.put("period", arg -> ((RelatedPerson) arg).getPeriod());
        fields.put("communication", arg -> ((RelatedPerson) arg).getCommunication());
        fields.put("communicationFirstRep", arg -> ((RelatedPerson) arg).getCommunicationFirstRep());
        return fields;
    }

    /* Patient */

    private Map<String, Function<Base, Object>> setPatient() {
        Map<String, Function<Base, Object>> fields = new HashMap<>(this.definitions.get("DomainResource"));
        fields.put("identifier", arg -> ((Patient) arg).getIdentifier());
        fields.put("identifierFirstRep", arg -> ((Patient) arg).getIdentifierFirstRep());
        fields.put("active", arg -> ((Patient) arg).getActiveElement());
        fields.put("name", arg -> ((Patient) arg).getName());
        fields.put("nameFirstRep", arg -> ((Patient) arg).getNameFirstRep());
        fields.put("telecom", arg -> ((Patient) arg).getTelecom());
        fields.put("telecomFirstRep", arg -> ((Patient) arg).getTelecomFirstRep());
        fields.put("gender", arg -> ((Patient) arg).getGender());
        fields.put("birthDate", arg -> ((Patient) arg).getBirthDateElement());
        fields.put("address", arg -> ((Patient) arg).getAddress());
        fields.put("addressFirstRep", arg -> ((Patient) arg).getAddressFirstRep());
        fields.put("photo", arg -> ((Patient) arg).getPhoto());
        fields.put("photoFirstRep", arg -> ((Patient) arg).getPhotoFirstRep());
        fields.put("communication", arg -> ((Patient) arg).getCommunication());
        fields.put("communicationFirstRep", arg -> ((Patient) arg).getCommunicationFirstRep());
        return fields;
    }

    /* CommunicationRequest */

    private Map<String, Function<Base, Object>> setCommunicationRequest() {
        Map<String, Function<Base, Object>> fields = new HashMap<>(this.definitions.get("DomainResource"));
        fields.put("category", arg -> ((CommunicationRequest) arg).getCategory());
        fields.put("categoryFirstRep", arg -> ((CommunicationRequest) arg).getCategoryFirstRep());
        fields.put("identifier", arg -> ((CommunicationRequest) arg).getIdentifier());
        fields.put("identifierFirstRep", arg -> ((CommunicationRequest) arg).getIdentifierFirstRep());
        fields.put("medium", arg -> ((CommunicationRequest) arg).getMedium());
        fields.put("mediumFirstRep", arg -> ((CommunicationRequest) arg).getMediumFirstRep());
        return fields;
    }

    /* ServiceRequest */

    private Map<String, Function<Base, Object>> setServiceRequest() {
        Map<String, Function<Base, Object>> fields = new HashMap<>(this.definitions.get("DomainResource"));
        fields.put("quantityQuantity", arg -> ((ServiceRequest) arg).getQuantityQuantity());
        fields.put("occurrenceTiming", arg -> ((ServiceRequest) arg).getOccurrenceTiming());
        return fields;
    }

}
