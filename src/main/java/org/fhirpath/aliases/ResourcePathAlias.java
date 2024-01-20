package org.fhirpath.aliases;

import org.fhirpath.aliases.framework.PathAlias;

import java.util.function.Function;
import java.util.regex.Pattern;

/**
 * Resource Alias.
 * $Resource -> entry{resource.resourceType=Resource}.resource.0
 */
public class ResourcePathAlias implements PathAlias {

    private final Pattern pattern = Pattern.compile("\\$\\w+\\.");
    private final Function<String, String> mutator = value -> {
        String resource = value.substring(1, value.length() - 1);
        return String.format("entry{resource.resourceType=%s}.resource.0.", resource);
    };

    @Override
    public Pattern getPattern() {
        return pattern;
    }

    @Override
    public Function<String, String> getMutator() {
        return mutator;
    }

}
