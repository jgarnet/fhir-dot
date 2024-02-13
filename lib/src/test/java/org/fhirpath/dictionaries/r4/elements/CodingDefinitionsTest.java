package org.fhirpath.dictionaries.r4.elements;

import org.fhirpath.dictionaries.framework.Definitions;
import org.hl7.fhir.r4.model.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class CodingDefinitionsTest extends ElementDefinitionsTest {
    private final CodingDefinitions codingDefinitions;
    private final Coding coding;

    public CodingDefinitionsTest() {
        this.codingDefinitions = new CodingDefinitions();
        this.coding = new Coding();
        this.coding.setSystem("Test System");
        this.coding.setCode("Test Code");
        this.coding.setVersion("Test Version");
        this.coding.setDisplay("Test Display");
        this.coding.setUserSelected(true);
    }

    @Test
    public void testSuppliesSystem() {
        UriType result = this.evaluate("system", this.coding);
        Assertions.assertEquals("Test System", result.getValue());
    }

    @Test
    public void testSuppliesVersion() {
        StringType result = this.evaluate("version", this.coding);
        Assertions.assertEquals("Test Version", result.getValue());
    }

    @Test
    public void testSuppliesCode() {
        StringType result = this.evaluate("code", this.coding);
        Assertions.assertEquals("Test Code", result.getValue());
    }

    @Test
    public void testSuppliesDisplay() {
        StringType result = this.evaluate("display", this.coding);
        Assertions.assertEquals("Test Display", result.getValue());
    }

    @Test
    public void testSuppliesUserSelected() {
        BooleanType result = this.evaluate("userSelected", this.coding);
        Assertions.assertTrue(result.getValue());
    }

    @Override
    protected Definitions<Base> getDefinitions() {
        return this.codingDefinitions;
    }
}
