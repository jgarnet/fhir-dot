package org.fhirdot.dictionaries.r4.elements;

import org.fhirdot.dictionaries.framework.AbstractDefinition;
import org.hl7.fhir.r4.model.Base;
import org.hl7.fhir.r4.model.Timing;

public class TimingRepeatComponentDefinition extends AbstractDefinition<Base, Timing.TimingRepeatComponent> {
    @Override
    protected void initialize() {
        this.putAllPaths(new ElementDefinition().getPaths());
        this.putPath("boundsDuration", Timing.TimingRepeatComponent::getBoundsDuration);
        this.putPath("period", Timing.TimingRepeatComponent::getPeriodElement);
        this.putPath("periodUnit", Timing.TimingRepeatComponent::getPeriodUnit);
    }

    @Override
    public String getName() {
        return "Timing$TimingRepeatComponent";
    }
}
