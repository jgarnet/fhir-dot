package org.fhirpath.dictionaries.r4.elements;

import org.fhirpath.dictionaries.framework.AbstractDefinition;
import org.hl7.fhir.r4.model.Base;
import org.hl7.fhir.r4.model.Period;

public class PeriodDefinition extends AbstractDefinition<Base> {
    @Override
    protected void initialize() {
        this.paths.putAll(new ElementDefinition().getPaths());
        // start
        this.paths.put("start", arg -> ((Period) arg).getStartElement());
        // end
        this.paths.put("end", arg -> ((Period) arg).getEndElement());
    }

    @Override
    public String getName() {
        return "Period";
    }
}
