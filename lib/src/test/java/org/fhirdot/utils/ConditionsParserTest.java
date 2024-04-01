package org.fhirdot.utils;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Collection;
import java.util.Iterator;

public class ConditionsParserTest {
    @Test
    public void testBuildsConditions() {
        String path = "some.field=1&&another.field!=2||c>=5&&test=1";
        Collection<Condition> conditions = new ConditionsParser(path).build();
        Assertions.assertNotNull(conditions);
        Iterator<Condition> conditionIterator = conditions.iterator();
        Condition condition = conditionIterator.next();
        Assertions.assertEquals("some.field=1", condition.getOperation());
        Assertions.assertEquals("AND", condition.getOperator());
        condition = conditionIterator.next();
        Assertions.assertNotNull(condition);
        Assertions.assertEquals("another.field!=2", condition.getOperation());
        Assertions.assertEquals("OR", condition.getOperator());
        condition = conditionIterator.next();
        Assertions.assertNotNull(condition);
        Assertions.assertEquals("c>=5", condition.getOperation());
        Assertions.assertEquals("AND", condition.getOperator());
        condition = conditionIterator.next();
        Assertions.assertNotNull(condition);
        Assertions.assertEquals("test=1", condition.getOperation());
        Assertions.assertNull(condition.getOperator());
        Assertions.assertFalse(conditionIterator.hasNext());
    }

    @Test
    public void testBuildsOneCondition() {
        String path = "some.field=1";
        Collection<Condition> conditions = new ConditionsParser(path).build();
        Assertions.assertNotNull(conditions);
        Iterator<Condition> conditionIterator = conditions.iterator();
        Condition condition = conditionIterator.next();
        Assertions.assertEquals("some.field=1", condition.getOperation());
        Assertions.assertNull(condition.getOperator());
        Assertions.assertFalse(conditionIterator.hasNext());
    }

    @Test
    public void testBuildsNoConditions() {
        Assertions.assertNull(new ConditionsParser(null).build());
    }
}
