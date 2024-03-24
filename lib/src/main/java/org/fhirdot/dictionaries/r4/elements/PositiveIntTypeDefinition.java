package org.fhirdot.dictionaries.r4.elements;

import org.fhirdot.dictionaries.framework.AbstractDefinition;
import org.hl7.fhir.r4.model.Base;
import org.hl7.fhir.r4.model.PositiveIntType;

public class PositiveIntTypeDefinition extends AbstractDefinition<Base, PositiveIntType> {
    @Override
    protected void initialize() {
        this.putAllPaths(new PrimitiveTypeDefinition().getPaths());
    }

    @Override
    public String getName() {
        return "PositiveIntType";
    }
}
