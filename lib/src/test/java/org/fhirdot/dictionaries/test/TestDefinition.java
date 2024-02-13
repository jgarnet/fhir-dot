package org.fhirdot.dictionaries.test;

import org.fhirdot.dictionaries.framework.Definition;
import org.hl7.fhir.r4.model.Base;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

public class TestDefinition implements Definition<Base> {
    @Override
    public String getName() {
        return "Test";
    }

    @Override
    public Map<String, Function<Base, Object>> getPaths() {
        Map<String, Function<Base, Object>> map = new HashMap<>();
        map.put("test", Base::getIdBase);
        return map;
    }
}
