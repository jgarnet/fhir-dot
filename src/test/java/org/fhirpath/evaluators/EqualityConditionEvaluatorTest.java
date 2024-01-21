package org.fhirpath.evaluators;

import org.fhirpath.evaluators.framework.ConditionEvaluator;
import org.fhirpath.framework.Rules;
import org.fhirpath.utils.FhirPathUtils;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.Date;

public class EqualityConditionEvaluatorTest {

    @Test
    public void testEqualityConditionEvaluatorPattern() {
        EqualityConditionEvaluator evaluator = new EqualityConditionEvaluator();
        String operation = "x=y";
        Assertions.assertTrue(evaluator.getPattern().matcher(operation).matches());
    }

    @Test
    public void testEqualityConditionEvaluator() {
        Rules rules = new Rules();
        rules.setDateFormat("yyyy-MM-dd");
        ConditionEvaluator evaluator = new EqualityConditionEvaluator().setRules(rules);
        // string equality
        Assertions.assertTrue(evaluator.getEvaluator().apply("a", "a"));
        Assertions.assertFalse(evaluator.getEvaluator().apply("a", "b"));
        // int equality
        Assertions.assertTrue(evaluator.getEvaluator().apply(5, "5"));
        Assertions.assertFalse(evaluator.getEvaluator().apply(4, "5"));
        // boolean equality
        Assertions.assertTrue(evaluator.getEvaluator().apply(true, "true"));
        Assertions.assertFalse(evaluator.getEvaluator().apply(true, "false"));
        Assertions.assertTrue(evaluator.getEvaluator().apply(false, "false"));
        Assertions.assertFalse(evaluator.getEvaluator().apply(false, "true"));
        // decimal equality
        Assertions.assertTrue(evaluator.getEvaluator().apply(BigDecimal.ONE, "1"));
        Assertions.assertFalse(evaluator.getEvaluator().apply(BigDecimal.TEN, "1"));
        // date equality
        try {
            FhirPathUtils utils = new FhirPathUtils();
            Date equal = utils.parseDate("2024-01-01", "yyyy-MM-dd");
            Assertions.assertTrue(evaluator.getEvaluator().apply(equal, "2024-01-01"));
            Date notEqual = utils.parseDate("2024-01-02", "yyyy-MM-dd");
            Assertions.assertFalse(evaluator.getEvaluator().apply(notEqual, "2024-01-01"));
        } catch (Exception e) {
            Assertions.fail("Failed to check date operations");
        }
    }

}
