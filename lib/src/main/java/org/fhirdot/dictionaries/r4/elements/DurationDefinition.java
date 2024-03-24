package org.fhirdot.dictionaries.r4.elements;

import org.fhirdot.dictionaries.framework.AbstractDefinition;
import org.hl7.fhir.r4.model.Base;
import org.hl7.fhir.r4.model.Duration;
import org.hl7.fhir.r4.model.Quantity;

public class DurationDefinition extends AbstractDefinition<Base, Duration> {
    @Override
    protected void initialize() {
        this.putAllPaths(new ElementDefinition().getPaths());
        this.putPath("unit", Quantity::getUnitElement);
        this.putPath("value", Quantity::getValueElement);
    }

    @Override
    public String getName() {
        return "Duration";
    }
}
