package org.fhirdot.dictionaries.r4.elements;

import org.fhirdot.dictionaries.framework.AbstractDefinition;
import org.hl7.fhir.r4.model.Base;
import org.hl7.fhir.r4.model.PrimitiveType;

public class PrimitiveTypeDefinition extends AbstractDefinition<Base, PrimitiveType<?>> {
    @Override
    protected void initialize() {
        this.putAllPaths(new ElementDefinition().getPaths());
        this.putPath("value", PrimitiveType::getValue);
    }

    @Override
    public String getName() {
        return "PrimitiveType";
    }
}
