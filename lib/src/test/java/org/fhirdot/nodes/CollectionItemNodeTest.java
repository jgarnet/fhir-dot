package org.fhirdot.nodes;

import org.fhirdot.exceptions.FhirDotException;
import org.fhirdot.nodes.framework.Node;
import org.hl7.fhir.r4.model.CodeableConcept;
import org.hl7.fhir.r4.model.Coding;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class CollectionItemNodeTest extends AbstractNodeTest {

    private Node collectionItemNode;

    @Test
    public void testCollectionItemNodeMatches() {
        CodeableConcept codeableConcept = new CodeableConcept().addCoding(new Coding());
        Assertions.assertTrue(collectionItemNode.matches(codeableConcept.getCoding(), "N"));
        Assertions.assertTrue(collectionItemNode.matches(codeableConcept.getCoding(), "n"));
        Assertions.assertTrue(collectionItemNode.matches(codeableConcept.getCoding(), "0"));
        Assertions.assertTrue(collectionItemNode.matches(codeableConcept.getCoding(), "10"));
        Assertions.assertFalse(collectionItemNode.matches(codeableConcept.getCoding(), "10n"));
        Assertions.assertFalse(collectionItemNode.matches(codeableConcept.getCoding(), "test"));
    }

    @Test
    public void testCollectionItemNode() {
        try {
            CodeableConcept codeableConcept = new CodeableConcept();
            codeableConcept.addCoding().setCode("CODE1");
            codeableConcept.addCoding().setCode("CODE2");
            Coding output1 = collectionItemNode.evaluate(codeableConcept.getCoding(), "0");
            Coding output2 = collectionItemNode.evaluate(codeableConcept.getCoding(), "1");
            Coding output3 = collectionItemNode.evaluate(codeableConcept.getCoding(), "N");
            Coding output4 = collectionItemNode.evaluate(codeableConcept.getCoding(), "n");
            Assertions.assertEquals("CODE1", output1.getCode());
            Assertions.assertEquals("CODE2", output2.getCode());
            Assertions.assertEquals("CODE2", output3.getCode());
            Assertions.assertEquals("CODE2", output4.getCode());
        } catch (FhirDotException e) {
            Assertions.fail("Failed to evaluate path using CollectionItemNode");
        }
    }

    @Override
    protected Node getNode() {
        if (collectionItemNode == null) {
            collectionItemNode = new CollectionItemNode();
        }
        return collectionItemNode;
    }
}

