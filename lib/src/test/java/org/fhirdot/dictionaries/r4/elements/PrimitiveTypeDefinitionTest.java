package org.fhirdot.dictionaries.r4.elements;

import org.fhirdot.dictionaries.framework.Definition;
import org.hl7.fhir.r4.model.Base;
import org.hl7.fhir.r4.model.PrimitiveType;
import org.hl7.fhir.r4.model.StringType;
import org.hl7.fhir.r4.model.Type;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class PrimitiveTypeDefinitionTest extends ElementDefinitionTest {
    private final PrimitiveTypeDefinition primitiveTypeDefinition;
    private final PrimitiveType<String> primitiveType;

    public PrimitiveTypeDefinitionTest() {
        this.primitiveTypeDefinition = new PrimitiveTypeDefinition();
        this.primitiveType = new PrimitiveType<String>() {
            @Override
            public Type copy() {
                return null;
            }

            @Override
            protected String encode(String theValue) {
                return null;
            }

            @Override
            protected String parse(String theValue) {
                return null;
            }
        };
        this.primitiveType.setValue("Test Value");
    }

    @Test
    public void testSuppliesValue() {
        String result = this.evaluate("value", this.primitiveType);
        Assertions.assertEquals("Test Value", result);
    }

    @Override
    protected Definition<Base> getDefinitions() {
        return this.primitiveTypeDefinition;
    }
}
