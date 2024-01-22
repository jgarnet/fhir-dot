package org.fhirpath.nodes;

import org.fhirpath.exceptions.FhirPathException;
import org.fhirpath.nodes.framework.Node;
import org.hl7.fhir.r4.model.HumanName;
import org.hl7.fhir.r4.model.StringType;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class FieldNodeTest extends AbstractNodeTest {

    private Node fieldNode;

    @Test
    public void testFieldNodeMatches() {
        HumanName name = new HumanName();
        Assertions.assertTrue(fieldNode.matches(name, "given"));
    }

    @Test
    public void testFieldNode() {
        try {
            HumanName name = new HumanName().setFamily("Test");
            StringType output = fieldNode.evaluate(name, "family");
            StringType expected = new StringType("Test");
            Assertions.assertEquals(expected.asStringValue(), output.asStringValue());
        } catch (FhirPathException e) {
            Assertions.fail("Failed to evaluate path using FieldNode");
        }
    }

    @Override
    protected Node getNode() {
        if (fieldNode == null) {
            fieldNode = new FieldNode();
        }
        return fieldNode;
    }
}
