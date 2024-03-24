package org.fhirdot.dictionaries.r4.elements;

import org.fhirdot.dictionaries.framework.AbstractDefinition;
import org.hl7.fhir.r4.model.Base;
import org.hl7.fhir.r4.model.Period;

public class PeriodDefinition extends AbstractDefinition<Base, Period> {
    @Override
    protected void initialize() {
        this.putAllPaths(new ElementDefinition().getPaths());
        // start
        this.putPath("start", Period::getStartElement);
        // end
        this.putPath("end", Period::getEndElement);
    }

    @Override
    public String getName() {
        return "Period";
    }
}
