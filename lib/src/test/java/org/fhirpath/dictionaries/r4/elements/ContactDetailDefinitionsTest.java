package org.fhirpath.dictionaries.r4.elements;

import org.fhirpath.dictionaries.framework.Definitions;
import org.hl7.fhir.r4.model.Base;
import org.hl7.fhir.r4.model.ContactDetail;
import org.hl7.fhir.r4.model.ContactPoint;
import org.hl7.fhir.r4.model.StringType;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

public class ContactDetailDefinitionsTest extends ElementDefinitionsTest {
    private final ContactDetailDefinitions contactDetailDefinitions;
    private final ContactDetail contactDetail;

    public ContactDetailDefinitionsTest() {
        this.contactDetailDefinitions = new ContactDetailDefinitions();
        this.contactDetail = new ContactDetail();
        this.contactDetail.setName("Test Name");
        this.contactDetail.addTelecom().setValue("123-456-7890");
    }

    @Test
    public void testSuppliesName() {
        StringType result = this.evaluate("name", this.contactDetail);
        Assertions.assertEquals("Test Name", result.getValue());
    }

    @Test
    public void testSuppliesTelecom() {
        List<ContactPoint> result = this.evaluate("telecom", this.contactDetail);
        Assertions.assertEquals("123-456-7890", result.get(0).getValue());
    }

    @Test
    public void testSuppliesTelecomFirstRep() {
        ContactPoint result = this.evaluate("telecomFirstRep", this.contactDetail);
        Assertions.assertEquals("123-456-7890", result.getValue());
    }

    @Override
    protected Definitions<Base> getDefinitions() {
        return this.contactDetailDefinitions;
    }
}
