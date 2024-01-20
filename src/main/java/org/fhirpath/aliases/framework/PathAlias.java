package org.fhirpath.aliases.framework;

import java.util.function.Function;
import java.util.regex.Pattern;

public interface PathAlias {
    Pattern getPattern();
    Function<String, String> getMutator();
}
