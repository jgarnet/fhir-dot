package org.fhirpath.dictionaries.r4.resources;

import org.fhirpath.dictionaries.framework.AbstractDefinitions;
import org.hl7.fhir.r4.model.Base;
import org.hl7.fhir.r4.model.Organization;

public class OrganizationDefinitions extends AbstractDefinitions<Base> {
    @Override
    protected void initialize() {
        this.definitions.putAll(new DomainResourceDefinitions().getDefinitions());
        // identifier
        this.definitions.put("identifier", arg -> ((Organization) arg).getIdentifier());
        // active
        this.definitions.put("active", arg -> ((Organization) arg).getActiveElement());
        // type
        this.definitions.put("type", arg -> ((Organization) arg).getType());
        // name
        this.definitions.put("name", arg -> ((Organization) arg).getNameElement());
        // alias
        this.definitions.put("alias", arg -> ((Organization) arg).getAlias());
        // telecom
        this.definitions.put("telecom", arg -> ((Organization) arg).getTelecom());
        // address
        this.definitions.put("address", arg -> ((Organization) arg).getAddress());
        // contact
        this.definitions.put("contact", arg -> ((Organization) arg).getContact());
    }

    @Override
    public String getName() {
        return "Organization";
    }
}
