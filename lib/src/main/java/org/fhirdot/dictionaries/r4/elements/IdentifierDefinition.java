package org.fhirdot.dictionaries.r4.elements;

import org.fhirdot.dictionaries.framework.AbstractDefinition;
import org.hl7.fhir.r4.model.Base;
import org.hl7.fhir.r4.model.Identifier;

public class IdentifierDefinition extends AbstractDefinition<Base> {
    @Override
    protected void initialize() {
        this.paths.putAll(new ElementDefinition().getPaths());
        // use
        this.paths.put("use", arg -> ((Identifier) arg).getUse());
        // type
        this.paths.put("type", arg -> ((Identifier) arg).getType());
        // system
        this.paths.put("system", arg -> ((Identifier) arg).getSystemElement());
        // value
        this.paths.put("value", arg -> ((Identifier) arg).getValueElement());
        // period
        this.paths.put("period", arg -> ((Identifier) arg).getPeriod());
    }

    @Override
    public String getName() {
        return "Identifier";
    }
}
