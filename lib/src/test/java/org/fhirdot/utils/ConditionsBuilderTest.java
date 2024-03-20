package org.fhirdot.utils;

import org.fhirdot.utils.Condition;
import org.fhirdot.utils.ConditionBuilder;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ConditionsBuilderTest {
    @Test
    public void testBuildsConditions() {
        String path = "some.field=1&&another.field!=2||c>=5&&test=1";
        Condition condition = new ConditionBuilder(path).build();
        Assertions.assertNotNull(condition);
        Assertions.assertEquals("some.field=1", condition.getOperation());
        Assertions.assertEquals("AND", condition.getOperator());
        condition = condition.getChild();
        Assertions.assertNotNull(condition);
        Assertions.assertEquals("another.field!=2", condition.getOperation());
        Assertions.assertEquals("OR", condition.getOperator());
        condition = condition.getChild();
        Assertions.assertNotNull(condition);
        Assertions.assertEquals("c>=5", condition.getOperation());
        Assertions.assertEquals("AND", condition.getOperator());
        condition = condition.getChild();
        Assertions.assertNotNull(condition);
        Assertions.assertEquals("test=1", condition.getOperation());
        Assertions.assertNull(condition.getOperator());
        condition = condition.getChild();
        Assertions.assertNull(condition);
    }
    @Test
    public void testBuildsOneCondition() {
        String path = "some.field=1";
        Condition condition = new ConditionBuilder(path).build();
        Assertions.assertNotNull(condition);
        Assertions.assertEquals("some.field=1", condition.getOperation());
        Assertions.assertNull(condition.getOperator());
        condition = condition.getChild();
        Assertions.assertNull(condition);
    }
    @Test
    public void testBuildsNoConditions() {
        Assertions.assertNull(new ConditionBuilder(null).build());
    }
}
