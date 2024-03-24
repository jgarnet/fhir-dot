package org.fhirdot.dictionaries.r4.elements;

import org.fhirdot.dictionaries.framework.AbstractDefinition;
import org.hl7.fhir.r4.model.Base;
import org.hl7.fhir.r4.model.Timing;

public class TimingDefinition extends AbstractDefinition<Base, Timing> {
    @Override
    protected void initialize() {
        this.putAllPaths(new ElementDefinition().getPaths());
        this.putPath("repeat", Timing::getRepeat);
    }

    @Override
    public String getName() {
        return "Timing";
    }
}
