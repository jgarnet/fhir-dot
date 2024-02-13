package org.fhirdot.evaluators;

import org.fhirdot.evaluators.framework.ConditionEvaluator;
import org.fhirdot.framework.Rules;
import org.fhirdot.utils.FhirDotUtils;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.Date;

public class NotEqualsConditionEvaluatorTest {

    @Test
    public void testNotEqualsConditionEvaluatorPattern() {
        NotEqualsConditionEvaluator evaluator = new NotEqualsConditionEvaluator();
        Assertions.assertTrue(evaluator.getPattern().matcher("x!=y").matches());
        Assertions.assertFalse(evaluator.getPattern().matcher("x=y").matches());
    }

    @Test
    public void testNotEqualsConditionEvaluator() {
        Rules rules = new Rules();
        rules.setDateFormat("yyyy-MM-dd");
        ConditionEvaluator evaluator = new NotEqualsConditionEvaluator().setRules(rules);
        // string equality
        Assertions.assertFalse(evaluator.getEvaluator().apply("a", "a"));
        Assertions.assertTrue(evaluator.getEvaluator().apply("a", "b"));
        // int equality
        Assertions.assertFalse(evaluator.getEvaluator().apply(5, "5"));
        Assertions.assertTrue(evaluator.getEvaluator().apply(4, "5"));
        // boolean equality
        Assertions.assertFalse(evaluator.getEvaluator().apply(true, "true"));
        Assertions.assertTrue(evaluator.getEvaluator().apply(true, "false"));
        Assertions.assertFalse(evaluator.getEvaluator().apply(false, "false"));
        Assertions.assertTrue(evaluator.getEvaluator().apply(false, "true"));
        // decimal equality
        Assertions.assertFalse(evaluator.getEvaluator().apply(BigDecimal.ONE, "1"));
        Assertions.assertTrue(evaluator.getEvaluator().apply(BigDecimal.TEN, "1"));
        // date equality
        try {
            FhirDotUtils utils = new FhirDotUtils();
            Date equal = utils.parseDate("2024-01-01", "yyyy-MM-dd");
            Assertions.assertFalse(evaluator.getEvaluator().apply(equal, "2024-01-01"));
            Date notEqual = utils.parseDate("2024-01-02", "yyyy-MM-dd");
            Assertions.assertTrue(evaluator.getEvaluator().apply(notEqual, "2024-01-01"));
        } catch (Exception e) {
            Assertions.fail("Failed to check date operations");
        }
    }

}
