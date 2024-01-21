package org.fhirpath.aliases;

import org.fhirpath.aliases.framework.PathAlias;

import java.util.function.Function;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Resource Alias.
 * $Resource -> entry{resource.resourceType=Resource}.resource.0
 */
public class ResourcePathAlias implements PathAlias {

    private final Pattern pattern = Pattern.compile("\\$\\w+");
    private final Function<String, String> mutator = value -> {
        Matcher matcher = this.pattern.matcher(value);
        if (matcher.find()) {
            String resource = matcher.group();
            resource = resource.substring(1);
            return String.format("entry{resource.resourceType=%s}.0.resource", resource);
        }
        return value;
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
