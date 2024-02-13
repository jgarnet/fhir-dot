package org.fhirdot.dictionaries.test;

import org.fhirdot.dictionaries.framework.AbstractDictionary;
import org.hl7.fhir.r4.model.Base;

public class TestDictionary extends AbstractDictionary<Base> {
    @Override
    protected String getPackage() {
        return "org.fhirdot.dictionaries.test";
    }

    @Override
    public Class<Base> getBaseClass() {
        return Base.class;
    }
}
