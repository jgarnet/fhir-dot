package org.fhirdot.evaluators;

import org.apache.commons.lang3.StringUtils;
import org.fhirdot.evaluators.framework.AbstractConditionEvaluator;

import java.util.function.BiFunction;
import java.util.regex.Pattern;

@SuppressWarnings("unchecked")
public class NotEqualsConditionEvaluator extends AbstractConditionEvaluator {

    private final Pattern PATTERN = Pattern.compile("^.+!=.+$");
    private final BiFunction<?, String, Boolean> evaluator = (base, value) -> {
        String targetStr = StringUtils.defaultString(
                this.getUtils().resolveStringValue(base, this.getRules()),
                ""
        );
        return !targetStr.equalsIgnoreCase(value);
    };

    @Override
    public Pattern getPattern() {
        return PATTERN;
    }

    @Override
    public String getOperator() {
        return "!=";
    }

    @Override
    public <Base> BiFunction<Base, String, Boolean> getEvaluator() {
        return (BiFunction<Base, String, Boolean>) this.evaluator;
    }

}
