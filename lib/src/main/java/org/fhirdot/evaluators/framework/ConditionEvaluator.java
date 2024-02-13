package org.fhirdot.evaluators.framework;

import org.fhirdot.framework.Rules;

import java.util.function.BiFunction;
import java.util.regex.Pattern;

public interface ConditionEvaluator {
    Rules getRules();
    ConditionEvaluator setRules(Rules rules);
    Pattern getPattern();
    String getOperator();
    <Base> BiFunction<Base, String, Boolean> getEvaluator();
}
