package org.fhirdot.dictionaries.r4.elements;

import org.fhirdot.dictionaries.framework.AbstractDefinition;
import org.hl7.fhir.r4.model.Base;
import org.hl7.fhir.r4.model.Quantity;

public class QuantityDefinition extends AbstractDefinition<Base, Quantity> {
    @Override
    protected void initialize() {
        this.putAllPaths(new ElementDefinition().getPaths());
        this.putPath("value", Quantity::getValueElement);
        this.putPath("comparator", Quantity::getComparator);
        this.putPath("unit", Quantity::getUnitElement);
        this.putPath("system", Quantity::getSystemElement);
        this.putPath("code", Quantity::getCodeElement);
    }

    @Override
    public String getName() {
        return "Quantity";
    }
}
