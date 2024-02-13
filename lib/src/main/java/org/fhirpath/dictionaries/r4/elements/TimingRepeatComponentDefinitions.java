package org.fhirpath.dictionaries.r4.elements;

import org.fhirpath.dictionaries.framework.AbstractDefinitions;
import org.hl7.fhir.r4.model.Base;
import org.hl7.fhir.r4.model.Timing;

public class TimingRepeatComponentDefinitions extends AbstractDefinitions<Base> {
    @Override
    protected void initialize() {
        this.definitions.putAll(new ElementDefinitions().getDefinitions());
        this.definitions.put("boundsDuration", arg -> ((Timing.TimingRepeatComponent) arg).getBoundsDuration());
        this.definitions.put("period", arg -> ((Timing.TimingRepeatComponent) arg).getPeriodElement());
        this.definitions.put("periodUnit", arg -> ((Timing.TimingRepeatComponent) arg).getPeriodUnit());
    }

    @Override
    public String getName() {
        return "Timing$TimingRepeatComponent";
    }
}
