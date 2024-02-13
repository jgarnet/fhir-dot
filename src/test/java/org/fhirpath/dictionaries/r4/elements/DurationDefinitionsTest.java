package org.fhirpath.dictionaries.r4.elements;

import org.fhirpath.dictionaries.framework.Definitions;
import org.hl7.fhir.r4.model.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

public class DurationDefinitionsTest extends ElementDefinitionsTest {
    private final DurationDefinitions durationDefinitions;
    private final Duration duration;

    public DurationDefinitionsTest() {
        this.durationDefinitions = new DurationDefinitions();
        this.duration = new Duration();
        this.duration.setUnit("Test Unit");
        this.duration.setValue(1);
    }

    @Test
    public void testSuppliesUnit() {
        StringType result = this.evaluate("unit", this.duration);
        Assertions.assertEquals("Test Unit", result.getValue());
    }

    @Test
    public void testSuppliesValue() {
        DecimalType result = this.evaluate("value", this.duration);
        Assertions.assertEquals(BigDecimal.ONE, result.getValue());
    }

    @Override
    protected Definitions<Base> getDefinitions() {
        return this.durationDefinitions;
    }
}
