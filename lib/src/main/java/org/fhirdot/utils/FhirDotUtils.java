package org.fhirdot.utils;

import org.apache.commons.lang3.time.FastDateFormat;
import org.fhirdot.framework.Rules;

import java.text.ParseException;
import java.util.Date;

@SuppressWarnings("unchecked, rawtypes")
public class FhirDotUtils {

    /**
     * Retrieves underlying value from FHIR PrimitiveType wrapper
     * @param obj Possible PrimitiveType object
     * @param <T> Generic return result
     * @return The unwrapped value
     */
    public <T> T unwrapPrimitiveType(T obj) {
        if (obj instanceof org.hl7.fhir.r4.model.PrimitiveType) {
            return (T) ((org.hl7.fhir.r4.model.PrimitiveType) obj).getValue();
        } else if (obj instanceof org.hl7.fhir.r5.model.PrimitiveType) {
            return (T) ((org.hl7.fhir.r5.model.PrimitiveType) obj).getValue();
        } else if (obj instanceof org.hl7.fhir.dstu3.model.PrimitiveType) {
            return (T) ((org.hl7.fhir.dstu3.model.PrimitiveType) obj).getValue();
        } else if (obj instanceof org.hl7.fhir.dstu2016may.model.PrimitiveType) {
            return (T) ((org.hl7.fhir.dstu2016may.model.PrimitiveType) obj).getValue();
        }
        return obj;
    }

    /**
     * Resolves String value of an Object for comparison.
     */
    public <Base> String resolveStringValue(Base base, Rules rules) {
        if (base instanceof Date) {
            return this.formatDate((Date) base, rules.getDateFormat());
        } else if (base instanceof org.hl7.fhir.r4.model.BaseDateTimeType) {
            return this.formatDate(((org.hl7.fhir.r4.model.BaseDateTimeType) base).getValue(), rules.getDateFormat());
        } else if (base instanceof org.hl7.fhir.r5.model.BaseDateTimeType) {
            return this.formatDate(((org.hl7.fhir.r5.model.BaseDateTimeType) base).getValue(), rules.getDateFormat());
        } else if (base instanceof org.hl7.fhir.dstu3.model.BaseDateTimeType) {
            return this.formatDate(((org.hl7.fhir.dstu3.model.BaseDateTimeType) base).getValue(), rules.getDateFormat());
        } else if (base instanceof org.hl7.fhir.dstu2016may.model.BaseDateTimeType) {
            return this.formatDate(((org.hl7.fhir.dstu2016may.model.BaseDateTimeType) base).getValue(), rules.getDateFormat());
        } else if (base instanceof org.hl7.fhir.r4.model.PrimitiveType) {
            return ((org.hl7.fhir.r4.model.PrimitiveType) base).asStringValue();
        } else if (base instanceof org.hl7.fhir.r5.model.PrimitiveType) {
            return ((org.hl7.fhir.r5.model.PrimitiveType) base).asStringValue();
        } else if (base instanceof org.hl7.fhir.dstu3.model.PrimitiveType) {
            return ((org.hl7.fhir.dstu3.model.PrimitiveType) base).asStringValue();
        } else if (base instanceof org.hl7.fhir.dstu2016may.model.PrimitiveType) {
            return ((org.hl7.fhir.dstu2016may.model.PrimitiveType) base).asStringValue();
        }
        return base.toString();
    }

    public String formatDate(Date date, String format) {
        return FastDateFormat.getInstance(format).format(date);
    }

    public Date parseDate(String date, String format) throws ParseException {
        return FastDateFormat.getInstance(format).parse(date);
    }

}
