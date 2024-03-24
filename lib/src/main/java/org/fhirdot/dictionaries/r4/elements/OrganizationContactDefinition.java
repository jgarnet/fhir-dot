package org.fhirdot.dictionaries.r4.elements;

import org.fhirdot.dictionaries.framework.AbstractDefinition;
import org.hl7.fhir.r4.model.Base;
import org.hl7.fhir.r4.model.Organization;

public class OrganizationContactDefinition extends AbstractDefinition<Base, Organization.OrganizationContactComponent> {
    @Override
    protected void initialize() {
        this.putAllPaths(new BackboneElementDefinition().getPaths());
        // purpose
        this.putPath("purpose", Organization.OrganizationContactComponent::getPurpose);
        // name
        this.putPath("name", Organization.OrganizationContactComponent::getName);
        // telecom
        this.putPath("telecom", Organization.OrganizationContactComponent::getTelecom);
        // address
        this.putPath("address", Organization.OrganizationContactComponent::getAddress);
    }

    @Override
    public String getName() {
        return "Organization$OrganizationContactComponent";
    }
}
