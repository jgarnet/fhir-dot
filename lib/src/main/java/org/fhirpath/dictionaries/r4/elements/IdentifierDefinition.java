package org.fhirpath.dictionaries.r4.elements;

import org.fhirpath.dictionaries.framework.AbstractDefinitions;
import org.hl7.fhir.r4.model.Base;
import org.hl7.fhir.r4.model.Identifier;

public class IdentifierDefinitions extends AbstractDefinitions<Base> {
    @Override
    protected void initialize() {
        this.definitions.putAll(new ElementDefinitions().getDefinitions());
        // use
        this.definitions.put("use", arg -> ((Identifier) arg).getUse());
        // type
        this.definitions.put("type", arg -> ((Identifier) arg).getType());
        // system
        this.definitions.put("system", arg -> ((Identifier) arg).getSystemElement());
        // value
        this.definitions.put("value", arg -> ((Identifier) arg).getValueElement());
        // period
        this.definitions.put("period", arg -> ((Identifier) arg).getPeriod());
    }

    @Override
    public String getName() {
        return "Identifier";
    }
}
