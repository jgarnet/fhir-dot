package org.fhirdot.dictionaries.r4.elements;

import org.fhirdot.dictionaries.framework.Definition;
import org.hl7.fhir.r4.model.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

public class OrganizationContactDefinitionTest extends BackboneElementDefinitionTest {
    private final OrganizationContactDefinition organizationContactDefinition;
    private final Organization.OrganizationContactComponent contact;
    private final Address address;
    private final HumanName name;

    public OrganizationContactDefinitionTest() {
        this.organizationContactDefinition = new OrganizationContactDefinition();
        this.contact = new Organization.OrganizationContactComponent();
        this.address = new Address();
        CodeableConcept purpose = new CodeableConcept();
        purpose.setText("Test Purpose");
        this.contact.setPurpose(purpose);
        this.name = new HumanName();
        this.contact.setName(this.name);
        this.contact.addTelecom().setValue("123");
        this.contact.setAddress(this.address);
    }

    @Test
    public void testSuppliesPurpose() {
        CodeableConcept result = this.evaluate("purpose", this.contact);
        Assertions.assertEquals("Test Purpose", result.getText());
    }

    @Test
    public void testSuppliesName() {
        HumanName result = this.evaluate("name", this.contact);
        Assertions.assertEquals(this.name, result);
    }

    @Test
    public void testSuppliesTelecom() {
        List<ContactPoint> result = this.evaluate("telecom", this.contact);
        Assertions.assertEquals("123", result.get(0).getValue());
    }

    @Test
    public void testSuppliesAddress() {
        Address result = this.evaluate("address", this.contact);
        Assertions.assertEquals(this.address, result);
    }

    @Override
    protected Definition<Base> getDefinitions() {
        return this.organizationContactDefinition;
    }
}
