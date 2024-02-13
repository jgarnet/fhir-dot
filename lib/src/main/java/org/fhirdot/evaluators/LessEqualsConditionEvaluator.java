package org.fhirdot.evaluators;

import org.fhirdot.evaluators.framework.AbstractConditionEvaluator;

import java.math.BigDecimal;
import java.util.Date;
import java.util.function.BiFunction;
import java.util.regex.Pattern;

@SuppressWarnings("unchecked")
public class LessEqualsConditionEvaluator extends AbstractConditionEvaluator {

    private final Pattern PATTERN = Pattern.compile("^.*<=.+$");
    private final BiFunction<?, String, Boolean> evaluator = (base, value) -> {
        if (base instanceof Integer) {
            return ((Integer) base) <= Integer.parseInt(value);
        } else if (base instanceof BigDecimal) {
            int comparison = ((BigDecimal) base).compareTo(new BigDecimal(value));
            return comparison <= 0;
        } else if (base instanceof Date) {
            try {
                int comparison = ((Date) base).compareTo(this.parseDate(value));
                return comparison <= 0;
            } catch (Exception ignored) {
                return false;
            }
        } else if (base instanceof Boolean) {
            int comparison = ((Boolean) base).compareTo(Boolean.parseBoolean(value));
            return comparison <= 0;
        }
        return base.toString().compareTo(value) <= 0;
    };

    @Override
    public Pattern getPattern() {
        return PATTERN;
    }

    @Override
    public String getOperator() {
        return "<=";
    }

    @Override
    public <Base> BiFunction<Base, String, Boolean> getEvaluator() {
        return (BiFunction<Base, String, Boolean>) this.evaluator;
    }

}
