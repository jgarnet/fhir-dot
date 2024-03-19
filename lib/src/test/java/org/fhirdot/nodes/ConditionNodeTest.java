package org.fhirdot.nodes;

import org.fhirdot.exceptions.FhirDotException;
import org.fhirdot.nodes.framework.Node;
import org.hl7.fhir.r4.model.CodeableConcept;
import org.hl7.fhir.r4.model.Coding;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

public class ConditionNodeTest extends AbstractNodeTest {

    private Node conditionNode;

    @Test
    public void testConditionNodeMatches() {
        CodeableConcept codeableConcept = new CodeableConcept().addCoding(new Coding());
        Assertions.assertTrue(conditionNode.matches(codeableConcept, "coding{code=TEST}"));
        Assertions.assertFalse(conditionNode.matches(codeableConcept, "coding"));
    }

    @Test
    public void testConditionNode() {
        try {
            CodeableConcept codeableConcept = new CodeableConcept();
            codeableConcept.addCoding().setCode("CODE1");
            codeableConcept.addCoding().setCode("CODE2");
            List<Coding> output1 = conditionNode.evaluate(codeableConcept, "coding{code=CODE1}");
            Assertions.assertEquals(1, output1.size());
            Assertions.assertEquals("CODE1", output1.get(0).getCode());
        } catch (FhirDotException e) {
            Assertions.fail("Failed to evaluate path using ConditionNode");
        }
    }

    @Test
    public void testOrderOfOperations() {
        try {
            CodeableConcept codeableConcept = new CodeableConcept();
            codeableConcept.addCoding().setCode("CODE1").setSystem("TEST1");
            codeableConcept.addCoding().setCode("CODE2").setSystem("TEST1");
            codeableConcept.addCoding().setCode("CODE3").setSystem("TEST2");
            // AND, then OR should be evaluated first from left to right
            List<Coding> output = conditionNode.evaluate(codeableConcept, "coding{system=TEST1&&code=CODE1||code=CODE2}");
            Assertions.assertEquals(2, output.size());
            Assertions.assertEquals("CODE1", output.get(0).getCode());
            Assertions.assertEquals("CODE2", output.get(1).getCode());
            // OR, then AND should be evaluated first from left to right
            output = conditionNode.evaluate(codeableConcept, "coding{code=CODE1||code=CODE2&&system=TEST}");
            Assertions.assertEquals(1, output.size());
            Assertions.assertEquals("CODE1", output.get(0).getCode());
            // AND should be evaluated from left to right
            output = conditionNode.evaluate(codeableConcept, "coding{code=CODE1&&code=CODE2&&system=TEST}");
            Assertions.assertEquals(0, output.size());
            // AND should be evaluated from left to right
            output = conditionNode.evaluate(codeableConcept, "coding{code=CODE4||code=CODE5||code=CODE1}");
            Assertions.assertEquals(1, output.size());
            Assertions.assertEquals("CODE1", output.get(0).getCode());
        } catch (FhirDotException e) {
            Assertions.fail("Failed to evaluate path using ConditionNode");
        }
    }

    @Override
    protected Node getNode() {
        if (conditionNode == null) {
            conditionNode = new ConditionNode();
        }
        return conditionNode;
    }
}
