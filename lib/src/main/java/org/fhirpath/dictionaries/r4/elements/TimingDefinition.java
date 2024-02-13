package org.fhirpath.dictionaries.r4.elements;

import org.fhirpath.dictionaries.framework.AbstractDefinition;
import org.hl7.fhir.r4.model.Base;
import org.hl7.fhir.r4.model.Timing;

public class TimingDefinition extends AbstractDefinition<Base> {
    @Override
    protected void initialize() {
        this.paths.putAll(new ElementDefinition().getPaths());
        this.paths.put("repeat", arg -> ((Timing) arg).getRepeat());
    }

    @Override
    public String getName() {
        return "Timing";
    }
}
