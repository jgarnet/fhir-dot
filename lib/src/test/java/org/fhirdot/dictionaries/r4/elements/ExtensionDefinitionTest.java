package org.fhirdot.dictionaries.r4.elements;

import org.fhirdot.dictionaries.framework.Definition;
import org.hl7.fhir.r4.model.Base;
import org.hl7.fhir.r4.model.Extension;
import org.hl7.fhir.r4.model.StringType;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ExtensionDefinitionTest extends ElementDefinitionTest {
    private final ExtensionDefinition extensionDefinitions;
    private final Extension extension;

    public ExtensionDefinitionTest() {
        this.extensionDefinitions = new ExtensionDefinition();
        this.extension = new Extension();
        this.extension.setUrl("Test URL");
        this.extension.setValue(new StringType("Test Value"));
    }

    @Test
    public void testSuppliesUrl() {
        String result = this.evaluate("url", this.extension);
        Assertions.assertEquals("Test URL", result);
    }

    @Test
    public void testSuppliesValue() {
        StringType result = this.evaluate("value", this.extension);
        Assertions.assertEquals("Test Value", result.getValue());
    }

    @Override
    protected Definition<Base> getDefinitions() {
        return this.extensionDefinitions;
    }
}
