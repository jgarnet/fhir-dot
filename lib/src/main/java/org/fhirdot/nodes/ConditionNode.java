package org.fhirdot.nodes;

import org.fhirdot.evaluators.ConditionEvaluators;
import org.fhirdot.evaluators.framework.ConditionEvaluator;
import org.fhirdot.exceptions.FhirDotException;
import org.fhirdot.framework.Rules;
import org.fhirdot.nodes.framework.AbstractNode;
import org.fhirdot.nodes.framework.Node;
import org.fhirdot.utils.Condition;
import org.fhirdot.utils.ConditionBuilder;
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

    /**
     * Given a Base object, extracts and filters the Collection specified by the field parameter.
     * For each Object in the target Collection, the supplied Conditions are applied to filter only the applicable items.
     * @param base The Base Object which the target Collection resides on
     * @param field The field path to the target Collection on the Base object
     * @param condition The Condition Node which holds all Conditions to apply to each item in the target Collection
     * @return The filtered Collection items which all Conditions apply to
     * @param <Base> The generic Base FHIR structure
     * @param <Result> Generic return type
     * @throws FhirDotException If errors occur during execution
     */
    private <Base, Result> List<Result> extractTargets(Base base, String field, Condition condition) throws FhirDotException {
        List<Base> targets = this.evaluatePath(base, field);
        return (List<Result>) targets
                .stream()
                .filter(target -> this.evaluateCondition(target, condition))
                .collect(Collectors.toList());
    }

    /**
     * Recursively evaluates all Conditions against a target Object.
     * Condition operations (AND, OR) are executed from left-to-right.
     * @param target The Base Object which Conditions are being evaluated against
     * @param condition A linked-Node structure holding all Conditions and their relationships
     * @return Boolean value indicating whether all Conditions apply to the target Object
     * @param <Base> The generic Base FHIR structure
     */
    private <Base> boolean evaluateCondition(Base target, Condition condition) {
        try {
            // determine if the current Condition resolves to true or false
            boolean result = this.evaluateOperation(target, condition);
            Condition child = condition.getChild();
            if (result) {
                if (child != null && "AND".equalsIgnoreCase(condition.getOperator())) {
                    // if result is true, and there is an AND child relationship, ensure child condition is also true
                    result = this.evaluateCondition(target, child);
                }
            } else if (child != null && "OR".equalsIgnoreCase(condition.getOperator())) {
                // if result is false, and there is an OR child relationship, check if child condition is true
                result = this.evaluateCondition(target, child);
            }
            return result;
        } catch (Exception e) {
            // if any Exception is thrown during evaluation, treat this as a mismatch against the Condition
            return false;
        }
    }

    /**
     * Evaluates whether a Condition is applicable for a target Object.
     * Extracts the operation from the Condition, and determines the appropriate Evaluator to evaluate the operation.
     * @param base The target Base Object which the Condition is being evaluated against
     * @param condition The Condition being evaluated
     * @return Boolean value indicating whether the Condition applies to the target
     * @param <Base> The generic Base FHIR structure
     * @throws FhirDotException If errors occur during evaluation
     */
    private <Base> boolean evaluateOperation(Base base, Condition condition) throws FhirDotException {
        String operation = condition.getOperation();
        ConditionEvaluator evaluator = this.evaluators.getEvaluator(condition.getOperation());
        String[] conditionParts = operation.split(evaluator.getOperator());
        String fieldPath = conditionParts[0];
        String value = conditionParts[1];
        return this.matchesCondition(evaluator, base, fieldPath, value);
    }
    private <Base, Result> boolean matchesCondition(ConditionEvaluator evaluator, Base target, String fieldPath, String value) throws FhirDotException {
        // if condition operation contains nested field path, extract the field
        // i.e. object{some.nested.field=1}
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
