package org.fhirpath.evaluators;

import org.fhirpath.evaluators.framework.ConditionEvaluator;
import org.fhirpath.exceptions.FhirPathException;
import org.fhirpath.framework.Rules;

import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ConditionEvaluators {

    private final Pattern operatorPattern = Pattern.compile("!?([<>%]=?|=)");
    private final Map<String, ConditionEvaluator> evaluators;

    public ConditionEvaluators(Rules rules) {
        this.evaluators = new HashMap<>(8);
        this.evaluators.put("=", new EqualityConditionEvaluator().setRules(rules));
        this.evaluators.put("!=", new NotEqualsConditionEvaluator().setRules(rules));
        this.evaluators.put("<=", new LessEqualsConditionEvaluator().setRules(rules));
        this.evaluators.put("<", new LessThanConditionEvaluator().setRules(rules));
        this.evaluators.put(">=", new GreaterEqualsConditionEvaluator().setRules(rules));
        this.evaluators.put(">", new GreaterThanConditionEvaluator().setRules(rules));
        this.evaluators.put("%=", new LikeConditionEvaluator().setRules(rules));
        this.evaluators.put("!%=", new NotLikeConditionEvaluator().setRules(rules));
    }

    public ConditionEvaluator getEvaluator(String condition) throws FhirPathException {
        Matcher matcher = this.operatorPattern.matcher(condition);
        if (matcher.find()) {
            return this.evaluators.get(matcher.group());
        }
        throw new FhirPathException(String.format("%s contains invalid condition operator", condition));
    }

    public void setRules(Rules rules) {
        this.evaluators.forEach((key, evaluator) -> evaluator.setRules(rules));
    }

}
