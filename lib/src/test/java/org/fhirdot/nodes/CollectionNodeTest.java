package org.fhirdot.nodes;

import org.fhirdot.exceptions.FhirDotException;
import org.fhirdot.nodes.framework.Node;
import org.hl7.fhir.r4.model.CodeType;
import org.hl7.fhir.r4.model.CodeableConcept;
import org.hl7.fhir.r4.model.Coding;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

public class CollectionNodeTest extends AbstractNodeTest {

    private Node collectionNode;

    @Test
    public void testCollectionNodeMatches() {
        CodeableConcept codeableConcept = new CodeableConcept().addCoding(new Coding());
        Assertions.assertTrue(collectionNode.matches(codeableConcept.getCoding(), "code"));
    }

    @Test
    public void testCollectionNode() {
        try {
            CodeableConcept codeableConcept = new CodeableConcept();
            codeableConcept.addCoding().setCode("CODE1");
            codeableConcept.addCoding().setCode("CODE2");
            List<CodeType> output = collectionNode.evaluate(codeableConcept.getCoding(), "code");
            Assertions.assertEquals(2, output.size());
        } catch (FhirDotException e) {
            Assertions.fail("Failed to evaluate path using CollectionNode");
        }
    }

    @Override
    protected Node getNode() {
        if (collectionNode == null) {
            collectionNode = new CollectionNode();
        }
        return collectionNode;
    }
}
