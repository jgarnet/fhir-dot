package org.fhirdot.dictionaries.framework;

import org.fhirdot.dictionaries.test.TestDictionary;
import org.hl7.fhir.r4.model.Base;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Map;
import java.util.function.Function;

public class AbstractDictionaryTest {

    @Test
    public void testSuppliesDefinitions() {
        try {
            TestDictionary test = new TestDictionary();
            Map<String, Map<String, Function<Base, Object>>> result = test.getDefinitions();
            Assertions.assertTrue(result.containsKey("Test"));
            Assertions.assertTrue(result.get("Test").containsKey("test"));
        } catch (Exception e) {
            Assertions.fail();
        }
    }

}
