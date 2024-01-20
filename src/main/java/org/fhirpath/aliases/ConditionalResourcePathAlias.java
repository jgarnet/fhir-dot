package org.fhirpath.aliases;

import org.fhirpath.aliases.framework.PathAlias;
import org.fhirpath.utils.ConditionParser;

import java.util.List;
import java.util.function.Function;
import java.util.regex.Pattern;

/**
 * Conditional Resource Alias.
 * $Resource{condition=1...} -> entry{resource.resourceType=Resource&&condition1...}.resource.0
 */
public class ConditionalResourcePathAlias implements PathAlias {

    private final Pattern pattern = Pattern.compile("(\\$\\w+\\{.+?})");
    private final Function<String, String> mutator = value -> {
        List<String> conditions = new ConditionParser().parse(value);
        int firstCurlyBrace = value.indexOf("{");
        String resource = value.substring(1, firstCurlyBrace);
        StringBuilder conditionsBuilder = new StringBuilder();
        conditions.forEach(condition -> {
            String conditionsStr = condition.substring(condition.indexOf("{") + 1, condition.length() - 1);
            conditionsBuilder.append(String.format("%s%s", "&&", conditionsStr));
        });
        return String.format("entry{resource.resourceType=%s%s}.resource.0.", resource, conditionsBuilder);
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
