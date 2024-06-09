package org.fhirdot.parsers;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

public class BaseNodeParserTest {
    @Test
    public void testParsesNodes() {
        String path = "nodeA.nodeB.nodeC(with.nested.path{and.braces}.field).condition{node.nested=1}.finalNode";
        List<String> nodes = new BaseNodeParser().parse(path);
        Assertions.assertEquals(5, nodes.size());
        Assertions.assertEquals("nodeA", nodes.get(0));
        Assertions.assertEquals("nodeB", nodes.get(1));
        Assertions.assertEquals("nodeC(with.nested.path{and.braces}.field)", nodes.get(2));
        Assertions.assertEquals("condition{node.nested=1}", nodes.get(3));
        Assertions.assertEquals("finalNode", nodes.get(4));
    }
}
