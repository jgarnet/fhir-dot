package org.fhirdot.dictionaries.r4;

import org.fhirdot.dictionaries.framework.AbstractDictionary;
import org.hl7.fhir.r4.model.Base;

public class R4Dictionary extends AbstractDictionary<Base> {
    @Override
    protected String getPackage() {
        return "org.fhirdot.dictionaries.r4";
    }

    @Override
    public Class<Base> getBaseClass() {
        return Base.class;
    }
}
