package org.fhirpath.dictionaries.r4.elements;

import org.fhirpath.dictionaries.framework.AbstractDefinition;
import org.hl7.fhir.r4.model.Base;

public class PositiveIntTypeDefinition extends AbstractDefinition<Base> {
    @Override
    protected void initialize() {
        this.paths.putAll(new PrimitiveTypeDefinition().getPaths());
    }

    @Override
    public String getName() {
        return "PositiveIntType";
    }
}
