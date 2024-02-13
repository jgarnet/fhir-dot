package org.fhirpath.dictionaries.r4.elements;

import org.fhirpath.dictionaries.framework.AbstractDefinitions;
import org.hl7.fhir.r4.model.Base;
import org.hl7.fhir.r4.model.ContactDetail;

public class ContactDetailDefinitions extends AbstractDefinitions<Base> {
    @Override
    protected void initialize() {
        this.definitions.putAll(new ElementDefinitions().getDefinitions());
        this.definitions.put("name", arg -> ((ContactDetail) arg).getNameElement());
        this.definitions.put("telecom", arg -> ((ContactDetail) arg).getTelecom());
        this.definitions.put("telecomFirstRep", arg -> ((ContactDetail) arg).getTelecomFirstRep());
    }

    @Override
    public String getName() {
        return "ContactDetail";
    }
}
