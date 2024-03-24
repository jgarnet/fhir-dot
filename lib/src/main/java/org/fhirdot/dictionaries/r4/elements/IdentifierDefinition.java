package org.fhirdot.dictionaries.r4.elements;

import org.fhirdot.dictionaries.framework.AbstractDefinition;
import org.hl7.fhir.r4.model.Base;
import org.hl7.fhir.r4.model.Identifier;

public class IdentifierDefinition extends AbstractDefinition<Base, Identifier> {
    @Override
    protected void initialize() {
        this.putAllPaths(new ElementDefinition().getPaths());
        // use
        this.putPath("use", Identifier::getUse);
        // type
        this.putPath("type", Identifier::getType);
        // system
        this.putPath("system", Identifier::getSystemElement);
        // value
        this.putPath("value", Identifier::getValueElement);
        // period
        this.putPath("period", Identifier::getPeriod);
    }

    @Override
    public String getName() {
        return "Identifier";
    }
}
