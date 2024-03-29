package org.fhirdot.aliases;

import org.fhirdot.aliases.framework.PathAlias;
import org.fhirdot.utils.ConditionsStringParser;

import java.util.List;
import java.util.function.Function;
import java.util.regex.Pattern;

/**
 * Conditional Contained Resource Alias.
 * Example Alias: contained(Resource){conditon=1...}
 * Example Output: contained{resourceType=Resource&&condition=1...}
 */
public class ConditionalContainedResourcePathAlias implements PathAlias {

    private final Pattern pattern = Pattern.compile("contained\\(.+?\\)\\{.+?}");
    private final Function<String, String> mutator = value -> {
        List<String> conditions = new ConditionsStringParser().parse(value);
        String resource = value.replace("contained(", "");
        int firstEndParenthesis = resource.indexOf(")");
        resource = resource.substring(0, firstEndParenthesis);
        StringBuilder conditionsBuilder = new StringBuilder();
        conditions.forEach(condition -> {
            String conditionsStr = condition.substring(condition.indexOf("{") + 1, condition.length() - 1);
            conditionsBuilder.append(String.format("%s%s", "&&", conditionsStr));
        });
        return String.format("contained{resourceType=%s%s}", resource, conditionsBuilder);
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
