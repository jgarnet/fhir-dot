package org.fhirpath.dictionaries.r4.elements;

import org.fhirpath.dictionaries.framework.AbstractDefinition;
import org.hl7.fhir.r4.model.Base;
import org.hl7.fhir.r4.model.Duration;

public class DurationDefinition extends AbstractDefinition<Base> {
    @Override
    protected void initialize() {
        this.paths.putAll(new ElementDefinition().getPaths());
        this.paths.put("unit", arg -> ((Duration) arg).getUnitElement());
        this.paths.put("value", arg -> ((Duration) arg).getValueElement());
    }

    @Override
    public String getName() {
        return "Duration";
    }
}
