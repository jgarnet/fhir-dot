package org.fhirdot.dictionaries.r4;

import org.fhirdot.dictionaries.framework.Definition;
import org.hl7.fhir.r4.model.Base;

@SuppressWarnings("unchecked")
public abstract class AbstractR4DefinitionTest {

    protected <T> T evaluate(String field, Base base) {
        return (T) this.getDefinitions().getPaths().get(field).apply(base);
    }

    protected abstract Definition<Base> getDefinitions();
}
