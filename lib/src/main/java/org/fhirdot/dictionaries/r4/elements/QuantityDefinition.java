package org.fhirdot.dictionaries.r4.elements;

import org.fhirdot.dictionaries.framework.AbstractDefinition;
import org.hl7.fhir.r4.model.Base;
import org.hl7.fhir.r4.model.Quantity;

public class QuantityDefinition extends AbstractDefinition<Base> {
    @Override
    protected void initialize() {
        this.paths.putAll(new ElementDefinition().getPaths());
        this.paths.put("value", arg -> ((Quantity) arg).getValueElement());
        this.paths.put("comparator", arg -> ((Quantity) arg).getComparator());
        this.paths.put("unit", arg -> ((Quantity) arg).getUnitElement());
        this.paths.put("system", arg -> ((Quantity) arg).getSystemElement());
        this.paths.put("code", arg -> ((Quantity) arg).getCodeElement());
    }

    @Override
    public String getName() {
        return "Quantity";
    }
}
