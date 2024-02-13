package org.fhirdot.evaluators;

import org.fhirdot.evaluators.framework.ConditionEvaluator;
import org.fhirdot.exceptions.FhirDotException;
import org.fhirdot.framework.Rules;
import org.fhirdot.utils.FhirDotUtils;

import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ConditionEvaluators {

    private final Pattern operatorPattern = Pattern.compile("!?([<>%]=?|=)");
    private final Map<String, ConditionEvaluator> evaluators;

    public ConditionEvaluators(Rules rules, FhirDotUtils utils) {
        this.evaluators = new HashMap<>(8);
        this.evaluators.put("=", new EqualityConditionEvaluator().setRules(rules).setUtils(utils));
        this.evaluators.put("!=", new NotEqualsConditionEvaluator().setRules(rules).setUtils(utils));
        this.evaluators.put("<=", new LessEqualsConditionEvaluator().setRules(rules).setUtils(utils));
        this.evaluators.put("<", new LessThanConditionEvaluator().setRules(rules).setUtils(utils));
        this.evaluators.put(">=", new GreaterEqualsConditionEvaluator().setRules(rules).setUtils(utils));
        this.evaluators.put(">", new GreaterThanConditionEvaluator().setRules(rules).setUtils(utils));
        this.evaluators.put("%=", new LikeConditionEvaluator().setRules(rules).setUtils(utils));
        this.evaluators.put("!%=", new NotLikeConditionEvaluator().setRules(rules).setUtils(utils));
    }

    public ConditionEvaluator getEvaluator(String condition) throws FhirDotException {
        Matcher matcher = this.operatorPattern.matcher(condition);
        if (matcher.find()) {
            return this.evaluators.get(matcher.group());
        }
        throw new FhirDotException(String.format("%s contains invalid condition operator", condition));
    }

    public void setRules(Rules rules) {
        this.evaluators.forEach((key, evaluator) -> evaluator.setRules(rules));
    }

    public void setUtils(FhirDotUtils utils) {
        this.evaluators.forEach((key, evaluator) -> evaluator.setUtils(utils));
    }

}
