package org.fhirdot.evaluators.framework;

import org.fhirdot.framework.Rules;
import org.fhirdot.utils.FhirDotUtils;

import java.util.function.BiFunction;
import java.util.regex.Pattern;

public interface ConditionEvaluator {
    Rules getRules();
    ConditionEvaluator setRules(Rules rules);
    FhirDotUtils getUtils();
    ConditionEvaluator setUtils(FhirDotUtils utils);
    Pattern getPattern();
    String getOperator();
    <Base> BiFunction<Base, String, Boolean> getEvaluator();
}
