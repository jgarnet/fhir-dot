package org.fhirpath.dictionaries.r4.resources;

import org.fhirpath.dictionaries.framework.AbstractDefinition;
import org.hl7.fhir.r4.model.Base;
import org.hl7.fhir.r4.model.Organization;

public class OrganizationDefinition extends AbstractDefinition<Base> {
    @Override
    protected void initialize() {
        this.paths.putAll(new DomainResourceDefinition().getPaths());
        // identifier
        this.paths.put("identifier", arg -> ((Organization) arg).getIdentifier());
        // active
        this.paths.put("active", arg -> ((Organization) arg).getActiveElement());
        // type
        this.paths.put("type", arg -> ((Organization) arg).getType());
        // name
        this.paths.put("name", arg -> ((Organization) arg).getNameElement());
        // alias
        this.paths.put("alias", arg -> ((Organization) arg).getAlias());
        // telecom
        this.paths.put("telecom", arg -> ((Organization) arg).getTelecom());
        // address
        this.paths.put("address", arg -> ((Organization) arg).getAddress());
        // contact
        this.paths.put("contact", arg -> ((Organization) arg).getContact());
    }

    @Override
    public String getName() {
        return "Organization";
    }
}
