package org.fhirpath.dictionaries.r4.elements;

import org.fhirpath.dictionaries.framework.AbstractDefinitions;
import org.hl7.fhir.r4.model.Base;
import org.hl7.fhir.r4.model.Timing;

public class TimingDefinitions extends AbstractDefinitions<Base> {
    @Override
    protected void initialize() {
        this.definitions.putAll(new ElementDefinitions().getDefinitions());
        this.definitions.put("repeat", arg -> ((Timing) arg).getRepeat());
    }

    @Override
    public String getName() {
        return "Timing";
    }
}
