package org.fhirpath.dictionaries.framework;

import java.util.Map;
import java.util.function.Function;

public interface Definition<Base> {
    String getName();
    Map<String, Function<Base, Object>> getPaths();
}
