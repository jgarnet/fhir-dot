package org.fhirpath.evaluators;

import org.fhirpath.evaluators.framework.ConditionEvaluator;
import org.fhirpath.framework.Rules;
import org.fhirpath.utils.FhirPathUtils;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.Date;

public class GreaterThanConditionEvaluatorTest {

    @Test
    public void testGreaterThanConditionEvaluatorPattern() {
        GreaterThanConditionEvaluator evaluator = new GreaterThanConditionEvaluator();
        Assertions.assertTrue(evaluator.getPattern().matcher("x>y").matches());
        Assertions.assertFalse(evaluator.getPattern().matcher("x>=y").matches());
    }

    @Test
    public void testGreaterThanConditionEvaluator() {
        Rules rules = new Rules();
        rules.setDateFormat("yyyy-MM-dd");
        ConditionEvaluator evaluator = new GreaterThanConditionEvaluator().setRules(rules);
        // string equality
        Assertions.assertFalse(evaluator.getEvaluator().apply("a", "b"));
        Assertions.assertTrue(evaluator.getEvaluator().apply("b", "a"));
        // int equality
        Assertions.assertFalse(evaluator.getEvaluator().apply(5, "5"));
        Assertions.assertTrue(evaluator.getEvaluator().apply(6, "5"));
        Assertions.assertFalse(evaluator.getEvaluator().apply(4, "5"));
        // boolean equality
        Assertions.assertFalse(evaluator.getEvaluator().apply(true, "true"));
        Assertions.assertTrue(evaluator.getEvaluator().apply(true, "false"));
        Assertions.assertFalse(evaluator.getEvaluator().apply(false, "false"));
        Assertions.assertFalse(evaluator.getEvaluator().apply(false, "true"));
        // decimal equality
        Assertions.assertFalse(evaluator.getEvaluator().apply(BigDecimal.ONE, "1"));
        Assertions.assertTrue(evaluator.getEvaluator().apply(BigDecimal.TEN, "1"));
        Assertions.assertFalse(evaluator.getEvaluator().apply(BigDecimal.ZERO, "1"));
        // date equality
        try {
            FhirPathUtils utils = new FhirPathUtils();
            Date equalDate = utils.parseDate("2024-01-01", "yyyy-MM-dd");
            Assertions.assertFalse(evaluator.getEvaluator().apply(equalDate, "2024-01-01"));
            Date greaterDate = utils.parseDate("2024-01-02", "yyyy-MM-dd");
            Assertions.assertTrue(evaluator.getEvaluator().apply(greaterDate, "2024-01-01"));
            Date lesserDate = utils.parseDate("2023-12-31", "yyyy-MM-dd");
            Assertions.assertFalse(evaluator.getEvaluator().apply(lesserDate, "2024-01-01"));
        } catch (Exception e) {
            Assertions.fail("Failed to check date operations");
        }
    }

}
