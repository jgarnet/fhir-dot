package org.fhirdot.aliases;

import org.fhirdot.aliases.framework.PathAlias;

import java.util.function.Function;
import java.util.regex.Pattern;

/**
 * Extension Path Alias.
 * extension(someUrl) -> extension{url=someUrl}
 */
public class ExtensionPathAlias implements PathAlias {

    private final Pattern pattern = Pattern.compile("extension\\(.+?\\)");
    private final Function<String, String> mutator = value -> {
        value = value.replace("extension(", "");
        value = value.substring(0, value.length() - 1);
        return String.format("extension{url=%s}", value);
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