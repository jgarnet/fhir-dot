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

    @Override
    protected Node getNode() {
        if (conditionNode == null) {
            conditionNode = new ConditionNode();
        }
        return conditionNode;
    }
}
