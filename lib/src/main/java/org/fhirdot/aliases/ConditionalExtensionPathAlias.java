package org.fhirdot.aliases;

import org.fhirdot.aliases.framework.PathAlias;
import org.fhirdot.utils.ConditionParser;

import java.util.List;
import java.util.function.Function;
import java.util.regex.Pattern;

/**
 * Conditional Extension Alias.
 * Example Alias: extension(someUrl){condition1=test...} ->
 * Example Output: extension{url=someUrl&&condition1=test...}
 */
public class ConditionalExtensionPathAlias implements PathAlias {

    private final Pattern pattern = Pattern.compile("extension\\(.+?\\)\\{.+?}");
    private final Function<String, String> mutator = value -> {
        String url = value.replace("extension(", "");
        int firstEndParenthesis = url.indexOf(")");
        url = url.substring(0, firstEndParenthesis);
        List<String> conditions = new ConditionParser().parse(value);
        StringBuilder conditionsBuilder = new StringBuilder();
        conditions.forEach(condition -> {
            String conditionsStr = condition.substring(condition.indexOf("{") + 1, condition.length() - 1);
            conditionsBuilder.append(String.format("%s%s", "&&", conditionsStr));
        });
        return String.format("extension{url=%s%s}", url, conditionsBuilder);
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