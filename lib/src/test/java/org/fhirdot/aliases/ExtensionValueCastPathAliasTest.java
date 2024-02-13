package org.fhirdot.aliases;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ExtensionValueCastPathAliasTest {

    @Test
    public void testExtensionPathAliasPattern() {
        ExtensionValueCastPathAlias alias = new ExtensionValueCastPathAlias();
        String path = "extension(testUrl).valueCodeableConcept";
        String path2 = "extension.valueString";
        Assertions.assertTrue(alias.getPattern().matcher(path).find());
        Assertions.assertTrue(alias.getPattern().matcher(path2).find());
    }

    @Test
    public void testExtensionPathAliasMutator() {
        ExtensionValueCastPathAlias alias = new ExtensionValueCastPathAlias();
        String path = "extension(testUrl).valueCodeableConcept";
        String path2 = "extension.valueString";
        String output = alias.getMutator().apply(path);
        String output2 = alias.getMutator().apply(path2);
        Assertions.assertEquals("extension(testUrl).value", output);
        Assertions.assertEquals("extension.value", output2);
    }

}
