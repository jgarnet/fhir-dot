package org.fhirpath.dictionaries.r4.elements;

import org.fhirpath.dictionaries.framework.AbstractDefinitions;
import org.hl7.fhir.r4.model.Base;
import org.hl7.fhir.r4.model.Period;

public class PeriodDefinitions extends AbstractDefinitions<Base> {
    @Override
    protected void initialize() {
        this.definitions.putAll(new ElementDefinitions().getDefinitions());
        // start
        this.definitions.put("start", arg -> ((Period) arg).getStartElement());
        // end
        this.definitions.put("end", arg -> ((Period) arg).getEndElement());
    }

    @Override
    public String getName() {
        return "Period";
    }
}
