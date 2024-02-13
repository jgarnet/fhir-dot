package org.fhirpath.dictionaries.r4.elements;

import org.fhirpath.dictionaries.framework.Definition;
import org.fhirpath.dictionaries.r4.AbstractR4DefinitionTest;
import org.hl7.fhir.r4.model.Base;
import org.hl7.fhir.r4.model.Element;
import org.hl7.fhir.r4.model.Extension;
import org.hl7.fhir.r4.model.StringType;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

public class ElementDefinitionTest extends AbstractR4DefinitionTest {

    private final ElementDefinition elementDefinitions;

    public ElementDefinitionTest() {
        this.elementDefinitions = new ElementDefinition();
    }

    @Test
    public void testSuppliesId() {
        Element e = new Element() {
            @Override
            public Element copy() {
                return null;
            }
        };
        e.setId("Test");
        StringType id = this.evaluate("id", e);
        Assertions.assertEquals("Test", id.getValue());
    }

    @Test
    public void testSuppliesExtension() {
        Element e = new Element() {
            @Override
            public Element copy() {
                return null;
            }
        };
        Extension ext = e.addExtension();
        ext.setUrl("test").setValue(new StringType("test"));
        List<Extension> result = this.evaluate("extension", e);
        Assertions.assertTrue(result.contains(ext));
    }

    @Override
    protected Definition<Base> getDefinitions() {
        return this.elementDefinitions;
    }
}
