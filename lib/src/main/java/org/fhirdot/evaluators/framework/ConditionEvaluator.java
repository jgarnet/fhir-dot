package org.fhirdot.evaluators.framework;

import org.fhirdot.framework.Rules;
import org.fhirdot.utils.FhirDotUtils;

import java.util.function.BiFunction;
import java.util.regex.Pattern;

/**
 * Provides common logic for evaluating Conditions on a path Node when reading FHIR structures
 */
public interface ConditionEvaluator {
    /**
     * Provides an instance of global Rules used for configuration
     * @return Rules used for configuration
     */
    Rules getRules();

    /**
     * Allows Rules instance to be supplied as needed
     * @param rules Rules used for configuration
     * @return ConditionEvaluator instance for chained operations
     */
    ConditionEvaluator setRules(Rules rules);

    /**
     * Provides an instance of a global FhirDotUtils class
     * @return FhirDotUtils used by evaluators
     */
    FhirDotUtils getUtils();

    /**
     * Allows FhirDotUtils instance to be supplied as needed
     * @param utils FhirDotUtils used for common operations
     * @return ConditionEvaluator instance for chained operations
     */
    ConditionEvaluator setUtils(FhirDotUtils utils);

    /**
     * Provides Pattern used to determine if the condition applies for a Node
     * @return Pattern which defines the condition syntax
     */
    Pattern getPattern();

    /**
     * Provides the operator used in the Condition
     * @return String operation used in Condition
     */
    String getOperator();

    /**
     * Provides Function which evaluates whether a Node value matches the Condition
     * @param <Base> Base FHIR structure class
     * @return Boolean value which denotes whether the Node matches the Condition
     */
    <Base> BiFunction<Base, String, Boolean> getEvaluator();
}
