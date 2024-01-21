package org.fhirpath.evaluators;

import org.fhirpath.evaluators.framework.ConditionEvaluator;
import org.fhirpath.framework.Rules;
import org.fhirpath.utils.FhirPathUtils;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.Date;

public class NotLikeConditionEvaluatorTest {

    @Test
    public void testNotLikeConditionEvaluatorPattern() {
        NotLikeConditionEvaluator evaluator = new NotLikeConditionEvaluator();
        Assertions.assertTrue(evaluator.getPattern().matcher("x!%=y").matches());
        Assertions.assertFalse(evaluator.getPattern().matcher("x%=y").matches());
    }

    @Test
    public void testNotLikeConditionEvaluator() {
        Rules rules = new Rules();
        rules.setDateFormat("yyyy-MM-dd");
        ConditionEvaluator evaluator = new NotLikeConditionEvaluator().setRules(rules);
        // string equality
        Assertions.assertFalse(evaluator.getEvaluator().apply("a", "a"));
        Assertions.assertTrue(evaluator.getEvaluator().apply("a", "b"));
        Assertions.assertFalse(evaluator.getEvaluator().apply("abcd", "a.*"));
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
        Assertions.assertFalse(evaluator.getEvaluator().apply(BigDecimal.TEN, "1*"));
        // date equality
        try {
            FhirPathUtils utils = new FhirPathUtils();
            Date equal = utils.parseDate("2024-01-01", "yyyy-MM-dd");
            Assertions.assertFalse(evaluator.getEvaluator().apply(equal, "2024-01-01"));
            Assertions.assertFalse(evaluator.getEvaluator().apply(equal, "\\d{4}-\\d{2}-\\d{2}"));
            Assertions.assertTrue(evaluator.getEvaluator().apply(equal, "test"));
        } catch (Exception e) {
            Assertions.fail("Failed to check date operations");
        }
    }

}
