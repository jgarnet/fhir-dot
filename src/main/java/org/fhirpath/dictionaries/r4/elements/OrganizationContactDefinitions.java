package org.fhirpath.dictionaries.r4.elements;

import org.fhirpath.dictionaries.framework.AbstractDefinitions;
import org.hl7.fhir.r4.model.Base;
import org.hl7.fhir.r4.model.Organization;

public class OrganizationContactDefinitions extends AbstractDefinitions<Base> {
    @Override
    protected void initialize() {
        this.definitions.putAll(new BackboneElementDefinitions().getDefinitions());
        // purpose
        this.definitions.put("purpose", arg -> ((Organization.OrganizationContactComponent) arg).getPurpose());
        // name
        this.definitions.put("name", arg -> ((Organization.OrganizationContactComponent) arg).getName());
        // telecom
        this.definitions.put("telecom", arg -> ((Organization.OrganizationContactComponent) arg).getTelecom());
        // address
        this.definitions.put("address", arg -> ((Organization.OrganizationContactComponent) arg).getAddress());
    }

    @Override
    public String getName() {
        return "Organization$OrganizationContactComponent";
    }
}
