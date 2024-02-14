package org.fhirdot.nodes.framework;

import org.fhirdot.dictionaries.framework.DictionaryFactory;
import org.fhirdot.exceptions.FhirDotException;
import org.fhirdot.framework.Rules;
import org.fhirdot.utils.FhirDotUtils;

/**
 * Represents a Node in a path and provides operational logic to evaluate the Node value
 */
public interface Node {
    /**
     * Provides an instance of global Rules used for configuration
     * @return Rules used for configuration
     */
    Rules getRules();

    /**
     * Allows Rules instance to be supplied as needed
     * @param rules Rules used for configuration
     * @return Node instance for chained operations
     */
    Node setRules(Rules rules);

    /**
     * Provides an instance of a global FhirDotUtils class
     * @return FhirDotUtils used by Nodes
     */
    FhirDotUtils getUtils();

    /**
     * Allows FhirDotUtils instance to be supplied as needed
     * @param utils FhirDotUtils used for common operations
     * @return Node instance for chained operations
     */
    Node setUtils(FhirDotUtils utils);

    /**
     * Allows Dictionary lookup based on a given FHIR structure
     * @return DictionaryFactory used to provide Dictionary instances during Node evaluation
     */
    DictionaryFactory getDictionaryFactory();

    /**
     * Allows the DictionaryFactory instance to be supplied as needed
     * @param factory DictionaryFactory instance used during Node evaluation
     * @return Node instance for chained operations
     */
    Node setDictionaryFactory(DictionaryFactory factory);

    /**
     * Determines if the supplied path matches the current Node criteria on the given Base FHIR structure
     * @param base The Base FHIR structure to evaluate
     * @param path The path being evaluated
     * @param <Base> The Base FHIR structure class
     * @return Boolean value which denotes whether the Node is applicable for the given FHIR structure and path
     */
    <Base> boolean matches(Base base, String path);

    /**
     * Evaluates the path against the Base FHIR structure and returns the result
     * @param base The Base FHIR structure being evaluated
     * @param path The path being evaluated
     * @param <Base> The Base FHIR structure class
     * @param <Result> Generic result class being returned
     * @return Result containing determination from Node evaluation
     * @throws FhirDotException When errors occur during evaluation
     */
    <Base, Result> Result evaluate(Base base, String path) throws FhirDotException;
}
