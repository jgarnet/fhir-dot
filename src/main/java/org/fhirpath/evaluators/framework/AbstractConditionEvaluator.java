package org.fhirpath.evaluators.framework;

import org.apache.commons.lang3.time.FastDateFormat;
import org.fhirpath.framework.Rules;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@SuppressWarnings("rawtypes")
public abstract class AbstractConditionEvaluator implements ConditionEvaluator {

    private Rules rules;

    @Override
    public Rules getRules() {
        return this.rules;
    }

    @Override
    public ConditionEvaluator setRules(Rules rules) {
        this.rules = rules;
        return this;
    }

    /**
     * Resolves String value of an Object for comparison.
     */
    protected <Base> String resolveStringValue(Base base) {
        if (base instanceof Date) {
            this.formatDate((Date) base);
        } else if (base instanceof org.hl7.fhir.r4.model.BaseDateTimeType) {
            return this.formatDate(((org.hl7.fhir.r4.model.BaseDateTimeType) base).getValue());
        } else if (base instanceof org.hl7.fhir.r5.model.BaseDateTimeType) {
            return this.formatDate(((org.hl7.fhir.r5.model.BaseDateTimeType) base).getValue());
        } else if (base instanceof org.hl7.fhir.dstu3.model.BaseDateTimeType) {
            return this.formatDate(((org.hl7.fhir.dstu3.model.BaseDateTimeType) base).getValue());
        } else if (base instanceof org.hl7.fhir.dstu2016may.model.BaseDateTimeType) {
            return this.formatDate(((org.hl7.fhir.dstu2016may.model.BaseDateTimeType) base).getValue());
        } else if (base instanceof org.hl7.fhir.dstu2.model.BaseDateTimeType) {
            return this.formatDate(((org.hl7.fhir.dstu2.model.BaseDateTimeType) base).getValue());
        } else if (base instanceof org.hl7.fhir.r4.model.PrimitiveType) {
            return ((org.hl7.fhir.r4.model.PrimitiveType) base).asStringValue();
        } else if (base instanceof org.hl7.fhir.r5.model.PrimitiveType) {
            return ((org.hl7.fhir.r5.model.PrimitiveType) base).asStringValue();
        } else if (base instanceof org.hl7.fhir.dstu3.model.PrimitiveType) {
            return ((org.hl7.fhir.dstu3.model.PrimitiveType) base).asStringValue();
        } else if (base instanceof org.hl7.fhir.dstu2016may.model.PrimitiveType) {
            return ((org.hl7.fhir.dstu2016may.model.PrimitiveType) base).asStringValue();
        } else if (base instanceof org.hl7.fhir.dstu2.model.PrimitiveType) {
            return ((org.hl7.fhir.dstu2.model.PrimitiveType) base).asStringValue();
        }
        return base.toString();
    }

    protected String formatDate(Date date) {
        String format = this.getRules().getDateFormat();
        return FastDateFormat.getInstance(format).format(date);
    }

    protected Date parseDate(String date) throws ParseException {
        String format = this.getRules().getDateFormat();
        return new SimpleDateFormat(format).parse(date);
    }

}
