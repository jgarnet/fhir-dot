package org.fhirpath.dictionaries.r4.elements;

import org.fhirpath.dictionaries.framework.Definition;
import org.hl7.fhir.r4.model.Address;
import org.hl7.fhir.r4.model.Base;
import org.hl7.fhir.r4.model.Period;
import org.hl7.fhir.r4.model.StringType;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Date;
import java.util.List;

public class AddressDefinitionTest extends ElementDefinitionTest {
    private final AddressDefinition addressDefinitions;
    private final Address address;
    private final Period period;

    public AddressDefinitionTest() {
        this.addressDefinitions = new AddressDefinition();
        this.address = new Address();
        this.address.setUse(Address.AddressUse.HOME);
        this.address.addLine("Test Line 1");
        this.address.setType(Address.AddressType.PHYSICAL);
        this.address.setText("Test Text");
        this.address.setCity("Test City");
        this.address.setDistrict("Test District");
        this.address.setState("Test State");
        this.address.setPostalCode("12345");
        this.address.setCountry("Test Country");
        this.period = new Period();
        this.period.setStart(new Date());
        this.period.setEnd(new Date());
        this.address.setPeriod(this.period);
    }

    @Test
    public void testSuppliesUse() {
        Address.AddressUse result = this.evaluate("use", this.address);
        Assertions.assertEquals(Address.AddressUse.HOME, result);
    }

    @Test
    public void testSuppliesAddressLines() {
        List<StringType> result = this.evaluate("line", this.address);
        Assertions.assertEquals("Test Line 1", result.get(0).getValue());
    }

    @Test
    public void testSuppliesAddressType() {
        Address.AddressType result = this.evaluate("type", this.address);
        Assertions.assertEquals(Address.AddressType.PHYSICAL, result);
    }

    @Test
    public void testSuppliesText() {
        StringType result = this.evaluate("text", this.address);
        Assertions.assertEquals("Test Text", result.getValue());
    }

    @Test
    public void testSuppliesCity() {
        StringType result = this.evaluate("city", this.address);
        Assertions.assertEquals("Test City", result.getValue());
    }

    @Test
    public void testSuppliesDistrict() {
        StringType result = this.evaluate("district", this.address);
        Assertions.assertEquals("Test District", result.getValue());
    }

    @Test
    public void testSuppliesState() {
        StringType result = this.evaluate("state", this.address);
        Assertions.assertEquals("Test State", result.getValue());
    }

    @Test
    public void testSuppliesPostalCode() {
        StringType result = this.evaluate("postalCode", this.address);
        Assertions.assertEquals("12345", result.getValue());
    }

    @Test
    public void testSuppliesCountry() {
        StringType result = this.evaluate("country", this.address);
        Assertions.assertEquals("Test Country", result.getValue());
    }

    @Test
    public void testSuppliesPeriod() {
        Period result = this.evaluate("period", this.address);
        Assertions.assertEquals(this.period, result);
    }

    @Override
    protected Definition<Base> getDefinitions() {
        return this.addressDefinitions;
    }
}
