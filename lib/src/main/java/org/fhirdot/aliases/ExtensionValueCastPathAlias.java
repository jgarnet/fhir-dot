package org.fhirdot.aliases;

import org.fhirdot.aliases.framework.PathAlias;

import java.util.function.Function;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Extension Value Cast Alias.
 * Example Alias: extension(url).valueX, extension.valueX
 * Example Output: extension(url).value, extension.value
 */
public class ExtensionValueCastPathAlias implements PathAlias {

    private final Pattern pattern = Pattern.compile("extension.*\\.value\\w+");
    private final Pattern EXTENSION_VALUE_PATTERN = Pattern.compile("value\\w+");
    private final Function<String, String> mutator = value -> {
        Matcher matcher = EXTENSION_VALUE_PATTERN.matcher(value);
        if (matcher.find()) {
            return value.replace(matcher.group(), "value");
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
