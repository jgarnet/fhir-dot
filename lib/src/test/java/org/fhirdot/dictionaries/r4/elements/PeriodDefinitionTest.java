package org.fhirdot.dictionaries.r4.elements;

import org.fhirdot.dictionaries.framework.Definition;
import org.fhirdot.utils.FhirDotUtils;
import org.hl7.fhir.r4.model.Base;
import org.hl7.fhir.r4.model.DateTimeType;
import org.hl7.fhir.r4.model.Period;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.text.ParseException;

public class PeriodDefinitionTest extends ElementDefinitionTest {
    private final PeriodDefinition periodDefinition;
    private final Period period;
    private final FhirDotUtils utils = new FhirDotUtils();
    private final String format = "yyyy-MM-dd";

    public PeriodDefinitionTest() throws ParseException {
        this.periodDefinition = new PeriodDefinition();
        this.period = new Period();
        this.period.setStart(this.utils.parseDate("2024-01-01", this.format));
        this.period.setEnd(((this.utils).parseDate("2024-01-02", this.format)));
    }

    @Test
    public void testSuppliesStart() {
        DateTimeType result = this.evaluate("start", this.period);
        Assertions.assertEquals("2024-01-01", this.utils.formatDate(result.getValue(), this.format));
    }

    @Test
    public void testSuppliesEnd() {
        DateTimeType result = this.evaluate("end", this.period);
        Assertions.assertEquals("2024-01-02", this.utils.formatDate(result.getValue(), this.format));
    }

    @Override
    protected Definition<Base> getDefinitions() {
        return this.periodDefinition;
    }
}
