package org.fhirdot.dictionaries.r4.elements;

import org.fhirdot.dictionaries.framework.Definition;
import org.hl7.fhir.r4.model.BackboneElement;
import org.hl7.fhir.r4.model.Base;
import org.hl7.fhir.r4.model.Extension;
import org.hl7.fhir.r4.model.StringType;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

public class BackboneElementDefinitionTest extends ElementDefinitionTest {

    private final BackboneElementDefinition backboneElementDefinitions;

    public BackboneElementDefinitionTest() {
        this.backboneElementDefinitions = new BackboneElementDefinition();
    }

    @Test
    public void testSuppliesModifierExtension() {
        BackboneElement e = new BackboneElement() {
            @Override
            public BackboneElement copy() {
                return null;
            }
        };
        Extension ext = e.addModifierExtension();
        ext.setUrl("test").setValue(new StringType("test"));
        List<Extension> result = this.evaluate("modifierExtension", e);
        Assertions.assertTrue(result.contains(ext));
    }

    @Override
    protected Definition<Base> getDefinitions() {
        return this.backboneElementDefinitions;
    }
}
