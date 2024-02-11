package org.fhirpath.dictionaries.r4.elements;

import org.fhirpath.dictionaries.framework.AbstractDefinitions;
import org.hl7.fhir.r4.model.Base;

public class PositiveIntTypeDefinitions extends AbstractDefinitions<Base> {
    @Override
    protected void initialize() {
        this.definitions.putAll(new PrimitiveTypeDefinitions().getDefinitions());
    }

    @Override
    public String getName() {
        return "PositiveIntType";
    }
}
