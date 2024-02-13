package org.fhirpath.dictionaries.r4.elements;

import org.fhirpath.dictionaries.framework.AbstractDefinition;
import org.hl7.fhir.r4.model.Base;
import org.hl7.fhir.r4.model.Timing;

public class TimingRepeatComponentDefinition extends AbstractDefinition<Base> {
    @Override
    protected void initialize() {
        this.paths.putAll(new ElementDefinition().getPaths());
        this.paths.put("boundsDuration", arg -> ((Timing.TimingRepeatComponent) arg).getBoundsDuration());
        this.paths.put("period", arg -> ((Timing.TimingRepeatComponent) arg).getPeriodElement());
        this.paths.put("periodUnit", arg -> ((Timing.TimingRepeatComponent) arg).getPeriodUnit());
    }

    @Override
    public String getName() {
        return "Timing$TimingRepeatComponent";
    }
}
