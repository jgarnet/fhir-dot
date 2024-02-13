package org.fhirpath.dictionaries.r4.elements;

import org.fhirpath.dictionaries.framework.AbstractDefinition;
import org.hl7.fhir.r4.model.Base;
import org.hl7.fhir.r4.model.PrimitiveType;

public class PrimitiveTypeDefinition extends AbstractDefinition<Base> {
    @Override
    protected void initialize() {
        this.paths.putAll(new ElementDefinition().getPaths());
        this.paths.put("value", arg -> ((PrimitiveType<?>) arg).getValue());
    }

    @Override
    public String getName() {
        return "PrimitiveType";
    }
}
