package org.fhirpath.dictionaries.r4.elements;

import org.fhirpath.dictionaries.framework.Definitions;
import org.hl7.fhir.r4.model.Base;
import org.hl7.fhir.r4.model.Extension;
import org.hl7.fhir.r4.model.StringType;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ExtensionDefinitionsTest extends ElementDefinitionsTest {
    private final ExtensionDefinitions extensionDefinitions;
    private final Extension extension;

    public ExtensionDefinitionsTest() {
        this.extensionDefinitions = new ExtensionDefinitions();
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
    protected Definitions<Base> getDefinitions() {
        return this.extensionDefinitions;
    }
}
