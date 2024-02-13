package org.fhirdot.utils;

import org.apache.commons.lang3.time.FastDateFormat;

import java.text.ParseException;
import java.util.Date;

@SuppressWarnings("unchecked, rawtypes")
public class FhirDotUtils {

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

    public String formatDate(Date date, String format) {
        return FastDateFormat.getInstance(format).format(date);
    }

    public Date parseDate(String date, String format) throws ParseException {
        return FastDateFormat.getInstance(format).parse(date);
    }

}
