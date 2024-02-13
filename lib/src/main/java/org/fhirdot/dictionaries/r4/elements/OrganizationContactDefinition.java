package org.fhirdot.dictionaries.r4.elements;

import org.fhirdot.dictionaries.framework.AbstractDefinition;
import org.hl7.fhir.r4.model.Base;
import org.hl7.fhir.r4.model.Organization;

public class OrganizationContactDefinition extends AbstractDefinition<Base> {
    @Override
    protected void initialize() {
        this.paths.putAll(new BackboneElementDefinition().getPaths());
        // purpose
        this.paths.put("purpose", arg -> ((Organization.OrganizationContactComponent) arg).getPurpose());
        // name
        this.paths.put("name", arg -> ((Organization.OrganizationContactComponent) arg).getName());
        // telecom
        this.paths.put("telecom", arg -> ((Organization.OrganizationContactComponent) arg).getTelecom());
        // address
        this.paths.put("address", arg -> ((Organization.OrganizationContactComponent) arg).getAddress());
    }

    @Override
    public String getName() {
        return "Organization$OrganizationContactComponent";
    }
}
