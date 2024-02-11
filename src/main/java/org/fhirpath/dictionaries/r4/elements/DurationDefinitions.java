package org.fhirpath.dictionaries.r4.elements;

import org.fhirpath.dictionaries.framework.AbstractDefinitions;
import org.hl7.fhir.r4.model.Base;
import org.hl7.fhir.r4.model.Duration;

public class DurationDefinitions extends AbstractDefinitions<Base> {
    @Override
    protected void initialize() {
        this.definitions.putAll(new ElementDefinitions().getDefinitions());
        this.definitions.put("unit", arg -> ((Duration) arg).getUnitElement());
        this.definitions.put("value", arg -> ((Duration) arg).getValueElement());
    }

    @Override
    public String getName() {
        return "Duration";
    }
}
