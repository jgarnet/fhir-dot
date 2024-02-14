package org.fhirdot.dictionaries.r4.elements;

import org.fhirdot.dictionaries.framework.Definition;
import org.hl7.fhir.r4.model.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class IdentifierDefinitionTest extends ElementDefinitionTest {
    private final IdentifierDefinition identifierDefinition;
    private final Identifier identifier;
    private final Period period;

    public IdentifierDefinitionTest() {
        this.identifierDefinition = new IdentifierDefinition();
        this.identifier = new Identifier();
        this.identifier.setUse(Identifier.IdentifierUse.OFFICIAL);
        CodeableConcept type = new CodeableConcept();
        type.setText("Test Type");
        this.identifier.setType(type);
        this.identifier.setSystem("Test System");
        this.identifier.setValue("Test Value");
        this.period = new Period();
        this.identifier.setPeriod(this.period);
    }

    @Test
    public void testSuppliesUse() {
        Identifier.IdentifierUse result = this.evaluate("use", this.identifier);
        Assertions.assertEquals(Identifier.IdentifierUse.OFFICIAL, result);
    }

    @Test
    public void testSuppliesType() {
        CodeableConcept result = this.evaluate("type", this.identifier);
        Assertions.assertEquals("Test Type", result.getText());
    }

    @Test
    public void testSuppliesSystem() {
        UriType result = this.evaluate("system", this.identifier);
        Assertions.assertEquals("Test System", result.getValue());
    }

    @Test
    public void testSuppliesValue() {
        StringType result = this.evaluate("value", this.identifier);
        Assertions.assertEquals("Test Value", result.getValue());
    }

    @Test
    public void testSuppliesPeriod() {
        Period result = this.evaluate("period", this.identifier);
        Assertions.assertEquals(this.period, result);
    }

    @Override
    protected Definition<Base> getDefinitions() {
        return this.identifierDefinition;
    }
}
