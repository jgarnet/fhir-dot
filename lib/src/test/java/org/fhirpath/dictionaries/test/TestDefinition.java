package org.fhirpath.dictionaries.test;

import org.fhirpath.dictionaries.framework.Definitions;
import org.hl7.fhir.r4.model.Base;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

public class TestDefinitions implements Definitions<Base> {
    @Override
    public String getName() {
        return "Test";
    }

    @Override
    public Map<String, Function<Base, Object>> getDefinitions() {
        Map<String, Function<Base, Object>> map = new HashMap<>();
        map.put("test", Base::getIdBase);
        return map;
    }
}
