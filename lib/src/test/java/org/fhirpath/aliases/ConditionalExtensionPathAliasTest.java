package org.fhirpath.aliases;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ConditionalExtensionPathAliasTest {

    @Test
    public void testConditionalExtensionPathAliasPattern() {
        ConditionalExtensionPathAlias alias = new ConditionalExtensionPathAlias();
        String path = "extension(testUrl){value=TEST}";
        Assertions.assertTrue(alias.getPattern().matcher(path).find());
    }

    @Test
    public void testConditionalExtensionPathAliasMutator() {
        ConditionalExtensionPathAlias alias = new ConditionalExtensionPathAlias();
        String path = "extension(testUrl){value=TEST}";
        String output = alias.getMutator().apply(path);
        Assertions.assertEquals("extension{url=testUrl&&value=TEST}", output);
    }

}