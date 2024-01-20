package org.fhirpath.nodes;

import org.apache.commons.lang3.StringUtils;
import org.fhirpath.evaluators.ConditionEvaluators;
import org.fhirpath.evaluators.framework.ConditionEvaluator;
import org.fhirpath.exceptions.FhirPathException;
import org.fhirpath.framework.Rules;
import org.fhirpath.nodes.framework.AbstractNode;
import org.fhirpath.nodes.framework.Node;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

@SuppressWarnings("unchecked")
public class ConditionNode extends AbstractNode {

    private final Pattern PATTERN = Pattern.compile("\\w+\\{.*}");
    private final ConditionEvaluators evaluators = new ConditionEvaluators(this.getRules());

    @Override
    public Node setRules(Rules rules) {
        this.evaluators.setRules(rules);
        return super.setRules(rules);
    }

    @Override
    public <Base> boolean matches(Base base, String path) {
        return PATTERN.matcher(path).find();
    }

    @Override
    public <Base, Result> Result evaluate(Base base, String path) throws FhirPathException {
        if (base instanceof List) {
            List<Base> parents = (List<Base>) base;
            List<Base> result = new ArrayList<>(parents.size());
            for (Base current : parents) {
                String index = "";
                if (path.matches("^.*\\{.*}\\[(\\d+|[Nn])]$")) {
                    int startBracketIndex = path.indexOf("[");
                    int endBracketIndex = path.indexOf("]");
                    index = path.substring(startBracketIndex + 1, endBracketIndex);
                    path = path.substring(0, startBracketIndex);
                }
                String field = path.substring(0, path.indexOf("{"));
                current = this.getValue(current, field);
                String conditionsString = path.substring(path.indexOf("{") + 1, path.length() - 1);
                // apply conditions
                current = (Base) ((List<Base>) current).stream()
                        .filter(item -> this.meetsConditions(item, conditionsString)).collect(Collectors.toList());
                if (StringUtils.isNotEmpty(index)) {
                    int idx = "N".equalsIgnoreCase(index) ? ((List<Base>) current).size() - 1 : Integer.parseInt(index);
                    current = ((List<Base>) current).get(idx);
                }
                if (current != null) {
                    if (current instanceof List) {
                        result.addAll((List<Base>) current);
                    } else {
                        result.add(current);
                    }
                }
            }
            return (Result) result;
        } else {
            Result result = (Result) base;
            String index = "";
            if (path.matches("^.*\\{.*}\\[(\\d+|[Nn])]$")) {
                int startBracketIndex = path.indexOf("[");
                int endBracketIndex = path.indexOf("]");
                index = path.substring(startBracketIndex + 1, endBracketIndex);
                path = path.substring(0, startBracketIndex);
            }
            String field = path.substring(0, path.indexOf("{"));
            result = this.getValue(result, field);
            String conditionsString = path.substring(path.indexOf("{") + 1, path.length() - 1);
            // apply conditions
            result = (Result) ((List<Base>) result).stream()
                    .filter(item -> this.meetsConditions(item, conditionsString)).collect(Collectors.toList());
            if (StringUtils.isNotEmpty(index)) {
                int idx = "N".equalsIgnoreCase(index) ? ((List<Base>) result).size() - 1 : Integer.parseInt(index);
                result = (Result) ((List<Base>) result).get(idx);
            }
            return result;
        }

    }

    /**
     * Determines if all supplied root-level conditions apply to the given item.
     */
    private <Base> boolean meetsConditions(Base base, String node) {
        try {
            // evaluate conditions on the current target
            String operator = node.contains("&&") ? "&&" : "||";
            boolean isAll = "&&".equalsIgnoreCase(operator);
            boolean isAny = "||".equalsIgnoreCase(operator);
            boolean matchesConditions = isAll;
            // get each root condition -- i.e. field1=test||field1=test2 -> [field1=test,field1=test1]
            String[] conditions = node.split(Pattern.quote(operator));
            for (String condition : conditions) {
                // find the evaluator that matches this condition (i.e. field=value, field<value, etc.)
                ConditionEvaluator evaluator = this.evaluators.getEvaluator(condition);
                boolean findNestedItem = condition.startsWith("has(");
                if (findNestedItem) {
                    condition = condition.substring(4, condition.length() - 1);
                }
                String[] conditionParts = condition.split(evaluator.getOperator());
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
                        target = this.getValue(target, currentField);
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
                if (!matches) {
                    if (isAll) {
                        matchesConditions = false;
                    }
                } else if (isAny) {
                    matchesConditions = true;
                }
                if (!matchesConditions) {
                    break;
                }
            }
            return matchesConditions;
        } catch (Exception ignored) {
            return false;
        }
    }

    protected <Base, Result> boolean matchesCondition(ConditionEvaluator evaluator, Base target, String fieldPath, String value) throws FhirPathException {
        int dotIndex = fieldPath.indexOf(".");
        while (dotIndex != -1) {
            String currentField = fieldPath.substring(0, dotIndex);
            fieldPath = fieldPath.substring(dotIndex + 1);
            // todo: account for collection items here
            target = this.getValue(target, currentField);
            dotIndex = fieldPath.indexOf(".");
        }
        Base targetValue = this.getValue(target, fieldPath);
        Result fieldTarget = (Result) this.getUtils().unwrapPrimitiveType(targetValue);
        return evaluator.getEvaluator().apply(fieldTarget, value);
    }

}
