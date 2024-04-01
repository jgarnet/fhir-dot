package org.fhirdot.nodes;

import org.fhirdot.evaluators.ConditionEvaluators;
import org.fhirdot.evaluators.framework.ConditionEvaluator;
import org.fhirdot.exceptions.FhirDotException;
import org.fhirdot.framework.Rules;
import org.fhirdot.nodes.framework.AbstractNode;
import org.fhirdot.nodes.framework.Node;
import org.fhirdot.utils.Condition;
import org.fhirdot.utils.ConditionsParser;
import org.fhirdot.utils.FhirDotUtils;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
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
        Collection<Condition> conditions = new ConditionsParser(conditionsString).build();
        if (base instanceof List) {
            List<Base> parents = (List<Base>) base;
            List<Result> results = new ArrayList<>(parents.size());
            for (Base current : parents) {
                results.addAll(this.extractTargets(current, field, conditions));
            }
            return (Result) results;
        }
        return (Result) this.extractTargets(base, field, conditions);
    }

    /**
     * Given a Base object, extracts and filters the Collection specified by the field parameter.
     * For each Object in the target Collection, the supplied Conditions are applied to filter only the applicable items.
     * @param base The Base Object which the target Collection resides on
     * @param field The field path to the target Collection on the Base object
     * @param conditions Collection of Conditions used to evaluate each item in the target Collection
     * @return The filtered Collection items which all Conditions apply to
     * @param <Base> The generic Base FHIR structure
     * @param <Result> Generic return type
     * @throws FhirDotException If errors occur during execution
     */
    private <Base, Result> List<Result> extractTargets(Base base, String field, Collection<Condition> conditions) throws FhirDotException {
        List<Base> targets = this.evaluatePath(base, field);
        return (List<Result>) targets
                .stream()
                .filter(target -> this.evaluateCondition(target, conditions.iterator()))
                .collect(Collectors.toList());
    }

    /**
     * Evaluates all Conditions against a target Object.
     * Condition operations (AND, OR) are executed from left-to-right.
     * @param target The Base Object which Conditions are being evaluated against
     * @param conditionIterator Iterator which provides Conditions to be evaluated
     * @return Boolean value indicating whether all Conditions apply to the target Object
     * @param <Base> The generic Base FHIR structure
     */
    private <Base> boolean evaluateCondition(Base target, Iterator<Condition> conditionIterator) {
        try {
            Condition condition = conditionIterator.next();
            // determine if the current Condition resolves to true or false
            boolean result = this.evaluateOperation(target, condition.getOperation());
            if (result) {
                if (conditionIterator.hasNext() && "AND".equalsIgnoreCase(condition.getOperator())) {
                    // if result is true, and there is an AND child relationship, ensure child condition is also true
                    result = this.evaluateCondition(target, conditionIterator);
                }
            } else if (conditionIterator.hasNext() && "OR".equalsIgnoreCase(condition.getOperator())) {
                // if result is false, and there is an OR child relationship, check if child condition is true
                result = this.evaluateCondition(target, conditionIterator);
            }
            return result;
        } catch (Exception e) {
            // if any Exception is thrown during evaluation, treat this as a mismatch against the Condition
            return false;
        }
    }

    /**
     * Evaluates whether a Condition operation is applicable for a target Object.
     * @param target The target Base Object which the Condition is being evaluated against
     * @param operation The operation being evaluated
     * @return Boolean value indicating whether the Condition applies to the target
     * @param <Base> The generic Base FHIR structure
     * @throws FhirDotException If errors occur during evaluation
     */
    private <Base, Result> boolean evaluateOperation(Base target, String operation) throws FhirDotException {
        ConditionEvaluator evaluator = this.evaluators.getEvaluator(operation);
        String[] conditionParts = operation.split(evaluator.getOperator());
        String fieldPath = conditionParts[0];
        String value = conditionParts[1];
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
        Result targetValue = this.getUtils().unwrapPrimitiveType(this.evaluatePath(target, fieldPath));
        return evaluator.getEvaluator().apply(targetValue, value);
    }
}
