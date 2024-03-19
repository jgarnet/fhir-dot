package org.fhirdot.nodes;

import org.fhirdot.evaluators.ConditionEvaluators;
import org.fhirdot.evaluators.framework.ConditionEvaluator;
import org.fhirdot.exceptions.FhirDotException;
import org.fhirdot.framework.Rules;
import org.fhirdot.nodes.framework.AbstractNode;
import org.fhirdot.nodes.framework.Node;
import org.fhirdot.nodes.helpers.Condition;
import org.fhirdot.nodes.helpers.ConditionBuilder;
import org.fhirdot.utils.FhirDotUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

@SuppressWarnings("unchecked")
public class ConditionNode extends AbstractNode {

    private final Pattern PATTERN = Pattern.compile("\\w+\\{.*}");
    private final ConditionEvaluators evaluators = new ConditionEvaluators(this.getRules(), this.getUtils());

    @Override
    public Node setRules(Rules rules) {
        this.evaluators.setRules(rules);
        return super.setRules(rules);
    }

    @Override
    public Node setUtils(FhirDotUtils utils) {
        this.evaluators.setUtils(utils);
        return super.setUtils(utils);
    }

    @Override
    public <Base> boolean matches(Base base, String path) {
        return PATTERN.matcher(path).find();
    }

    @Override
    public <Base, Result> Result evaluate(Base base, String path) throws FhirDotException {
        // todo: implement caching for path evaluation, condition evaluation
        String field = path.substring(0, path.indexOf("{"));
        String conditionsString = path.substring(path.indexOf("{") + 1, path.length() - 1);
        Condition condition = new ConditionBuilder(conditionsString).build();
        if (base instanceof List) {
            List<Base> parents = (List<Base>) base;
            List<Result> results = new ArrayList<>(parents.size());
            for (Base current : parents) {
                results.addAll(this.extractTargets(current, field, condition));
            }
            return (Result) results;
        }
        return (Result) this.extractTargets(base, field, condition);
    }

    private <Base, Result> List<Result> extractTargets(Base base, String field, Condition condition) throws FhirDotException {
        List<Base> targets = this.evaluatePath(base, field);
        return (List<Result>) targets
                .stream()
                .filter(target -> this.evaluateCondition(target, condition))
                .collect(Collectors.toList());
    }

    private <Base> boolean evaluateCondition(Base target, Condition condition) {
        try {
            boolean result = this.evaluateOperation(target, condition);
            Condition child = condition.getChild();
            if (result) {
                if (child != null && "AND".equalsIgnoreCase(condition.getOperator())) {
                    result = this.evaluateCondition(target, child);
                }
            } else if (child != null && "OR".equalsIgnoreCase(condition.getOperator())) {
                result = this.evaluateCondition(target, child);
            }
            return result;
        } catch (Exception e) {
            return false;
        }
    }

    private <Base> boolean evaluateOperation(Base base, Condition condition) throws FhirDotException {
        String operation = condition.getOperation();
        ConditionEvaluator evaluator = this.evaluators.getEvaluator(condition.getOperation());
        boolean findNestedItem = operation.startsWith("has(");
        if (findNestedItem) {
            operation = operation.substring(4, operation.length() - 1);
        }
        String[] conditionParts = operation.split(evaluator.getOperator());
        String fieldPath = conditionParts[0];
        String value = conditionParts[1];
        Base target = base;
        boolean matches = false;
        if (findNestedItem) {
            // extract field from nested path (i.e. item{extension.url=TEST} or identifier{type.codingFirstRep.system=TEST}
            int dotIndex = fieldPath.indexOf(".");
            if (dotIndex != -1) {
                String currentField = fieldPath.substring(0, dotIndex);
                fieldPath = fieldPath.substring(dotIndex + 1);
                target = this.evaluatePath(target, currentField);
            }
            for (Base item : (List<Base>) target) {
                matches = this.matchesCondition(evaluator, item, fieldPath, value);
                if (matches) {
                    break;
                }
            }
        } else {
            matches = this.matchesCondition(evaluator, target, fieldPath, value);
        }
        return matches;
    }

    protected <Base, Result> boolean matchesCondition(ConditionEvaluator evaluator, Base target, String fieldPath, String value) throws FhirDotException {
        int dotIndex = fieldPath.indexOf(".");
        while (dotIndex != -1) {
            String currentField = fieldPath.substring(0, dotIndex);
            fieldPath = fieldPath.substring(dotIndex + 1);
            // account for collection indexes on nested paths
            if (target instanceof List) {
                int index = "N".equalsIgnoreCase(currentField) ? ((List<Base>) target).size() - 1 : Integer.parseInt(currentField);
                target = ((List<Base>) target).get(index);
            } else {
                target = this.evaluatePath(target, currentField);
            }
            dotIndex = fieldPath.indexOf(".");
        }
        Base targetValue = this.evaluatePath(target, fieldPath);
        Result fieldTarget = (Result) this.getUtils().unwrapPrimitiveType(targetValue);
        return evaluator.getEvaluator().apply(fieldTarget, value);
    }

}
