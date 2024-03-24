package org.fhirdot.dictionaries.r4.resources;

import org.fhirdot.dictionaries.framework.AbstractDefinition;
import org.hl7.fhir.r4.model.Base;
import org.hl7.fhir.r4.model.Organization;

public class OrganizationDefinition extends AbstractDefinition<Base, Organization> {
    @Override
    protected void initialize() {
        this.putAllPaths(new DomainResourceDefinition().getPaths());
        // identifier
        this.putPath("identifier", Organization::getIdentifier);
        // active
        this.putPath("active", Organization::getActiveElement);
        // type
        this.putPath("type", Organization::getType);
        // name
        this.putPath("name", Organization::getNameElement);
        // alias
        this.putPath("alias", Organization::getAlias);
        // telecom
        this.putPath("telecom", Organization::getTelecom);
        // address
        this.putPath("address", Organization::getAddress);
        // contact
        this.putPath("contact", Organization::getContact);
    }

    @Override
    public String getName() {
        return "Organization";
    }
}
