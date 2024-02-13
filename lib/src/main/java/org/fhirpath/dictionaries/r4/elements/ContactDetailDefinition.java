package org.fhirpath.dictionaries.r4.elements;

import org.fhirpath.dictionaries.framework.AbstractDefinition;
import org.hl7.fhir.r4.model.Base;
import org.hl7.fhir.r4.model.ContactDetail;

public class ContactDetailDefinition extends AbstractDefinition<Base> {
    @Override
    protected void initialize() {
        this.paths.putAll(new ElementDefinition().getPaths());
        this.paths.put("name", arg -> ((ContactDetail) arg).getNameElement());
        this.paths.put("telecom", arg -> ((ContactDetail) arg).getTelecom());
        this.paths.put("telecomFirstRep", arg -> ((ContactDetail) arg).getTelecomFirstRep());
    }

    @Override
    public String getName() {
        return "ContactDetail";
    }
}
