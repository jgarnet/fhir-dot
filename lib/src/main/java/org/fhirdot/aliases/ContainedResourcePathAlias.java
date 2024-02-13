package org.fhirdot.aliases;

import org.fhirdot.aliases.framework.PathAlias;

import java.util.function.Function;
import java.util.regex.Pattern;

/**
 * Contained Resource Alias
 * contained(Resource) -> contained{resourceType=Resource}
 */
public class ContainedResourcePathAlias implements PathAlias {

    private final Pattern pattern = Pattern.compile("contained\\(.+?\\)");
    private final Function<String, String> mutator = value -> {
        String resource = value.replace("contained(", "");
        resource = resource.substring(0, resource.length() - 1);
        return String.format("contained{resourceType=%s}", resource);
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
