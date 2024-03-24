package org.fhirdot.dictionaries.r4.elements;

import org.fhirdot.dictionaries.framework.AbstractDefinition;
import org.hl7.fhir.r4.model.Base;
import org.hl7.fhir.r4.model.ContactDetail;

public class ContactDetailDefinition extends AbstractDefinition<Base, ContactDetail> {
    @Override
    protected void initialize() {
        this.putAllPaths(new ElementDefinition().getPaths());
        this.putPath("name", ContactDetail::getNameElement);
        this.putPath("telecom", ContactDetail::getTelecom);
        this.putPath("telecomFirstRep", ContactDetail::getTelecomFirstRep);
    }

    @Override
    public String getName() {
        return "ContactDetail";
    }
}
