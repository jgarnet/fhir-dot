package org.fhirpath.dictionaries.r4.elements;

import org.fhirpath.dictionaries.framework.AbstractDefinitions;
import org.hl7.fhir.r4.model.Base;
import org.hl7.fhir.r4.model.Quantity;

public class QuantityDefinitions extends AbstractDefinitions<Base> {
    @Override
    protected void initialize() {
        this.definitions.putAll(new ElementDefinitions().getDefinitions());
        this.definitions.put("value", arg -> ((Quantity) arg).getValueElement());
        this.definitions.put("comparator", arg -> ((Quantity) arg).getComparator());
        this.definitions.put("unit", arg -> ((Quantity) arg).getUnitElement());
        this.definitions.put("system", arg -> ((Quantity) arg).getSystemElement());
        this.definitions.put("code", arg -> ((Quantity) arg).getCodeElement());
    }

    @Override
    public String getName() {
        return "Quantity";
    }
}
