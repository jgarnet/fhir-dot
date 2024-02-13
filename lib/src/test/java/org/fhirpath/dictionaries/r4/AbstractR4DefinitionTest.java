package org.fhirpath.dictionaries.r4;

import org.fhirpath.dictionaries.framework.Definition;
import org.hl7.fhir.r4.model.Base;

@SuppressWarnings("unchecked")
public abstract class AbstractR4DefinitionsTest {

    protected <T> T evaluate(String field, Base base) {
        return (T) this.getDefinitions().getDefinitions().get(field).apply(base);
    }

    protected abstract Definition<Base> getDefinitions();
}
