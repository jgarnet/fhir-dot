package org.fhirpath.dictionaries.r4.elements;

import org.fhirpath.dictionaries.framework.Definition;
import org.hl7.fhir.r4.model.Base;
import org.hl7.fhir.r4.model.HumanName;
import org.hl7.fhir.r4.model.Period;
import org.hl7.fhir.r4.model.StringType;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

public class HumanNameDefinitionsTest extends ElementDefinitionsTest {
    private final HumanNameDefinition humanNameDefinitions;
    private final HumanName humanName;
    private final Period period;

    public HumanNameDefinitionsTest() {
        this.humanNameDefinitions = new HumanNameDefinition();
        this.period = new Period();
        this.humanName = new HumanName();
        this.humanName.setText("Test Text");
        this.humanName.setUse(HumanName.NameUse.OFFICIAL);
        this.humanName.setFamily("Test Family");
        this.humanName.addGiven("Test Given");
        this.humanName.addPrefix("Test Prefix");
        this.humanName.addSuffix("Test Suffix");
        this.humanName.setPeriod(this.period);
    }

    @Test
    public void testSuppliesUse() {
        HumanName.NameUse result = this.evaluate("use", this.humanName);
        Assertions.assertEquals(HumanName.NameUse.OFFICIAL, result);
    }

    @Test
    public void testSuppliesText() {
        StringType result = this.evaluate("text", this.humanName);
        Assertions.assertEquals("Test Text", result.getValue());
    }

    @Test
    public void testSuppliesFamily() {
        StringType result = this.evaluate("family", this.humanName);
        Assertions.assertEquals("Test Family", result.getValue());
    }

    @Test
    public void testSuppliesGiven() {
        List<StringType> result = this.evaluate("given", this.humanName);
        Assertions.assertEquals("Test Given", result.get(0).getValue());
    }

    @Test
    public void testSuppliesPrefix() {
        List<StringType> result = this.evaluate("prefix", this.humanName);
        Assertions.assertEquals("Test Prefix", result.get(0).getValue());
    }

    @Test
    public void testSuppliesSuffix() {
        List<StringType> result = this.evaluate("suffix", this.humanName);
        Assertions.assertEquals("Test Suffix", result.get(0).getValue());
    }

    @Test
    public void testSuppliesPeriod() {
        Period result = this.evaluate("period", this.humanName);
        Assertions.assertEquals(this.period, result);
    }

    @Test
    public void testSuppliesNameAsSingleString() {
        String result = this.evaluate("nameAsSingleString", this.humanName);
        Assertions.assertEquals("Test Prefix Test Given Test Family Test Suffix", result);
    }

    @Test
    public void testSuppliesGivenAsSingleString() {
        String result = this.evaluate("givenAsSingleString", this.humanName);
        Assertions.assertEquals("Test Given", result);
    }

    @Test
    public void testSuppliesPrefixAsSingleString() {
        String result = this.evaluate("prefixAsSingleString", this.humanName);
        Assertions.assertEquals("Test Prefix", result);
    }

    @Test
    public void testSuppliesSuffixAsSingleString() {
        String result = this.evaluate("suffixAsSingleString", this.humanName);
        Assertions.assertEquals("Test Suffix", result);
    }

    @Override
    protected Definition<Base> getDefinitions() {
        return this.humanNameDefinitions;
    }
}
