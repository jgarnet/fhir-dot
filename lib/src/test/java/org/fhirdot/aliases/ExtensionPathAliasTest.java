package org.fhirdot.aliases;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ExtensionPathAliasTest {

    @Test
    public void testExtensionPathAliasPattern() {
        ExtensionPathAlias alias = new ExtensionPathAlias();
        String path = "extension(testUrl)";
        Assertions.assertTrue(alias.getPattern().matcher(path).find());
    }

    @Test
    public void testExtensionPathAliasMutator() {
        ExtensionPathAlias alias = new ExtensionPathAlias();
        String path = "extension(testUrl)";
        String output = alias.getMutator().apply(path);
        Assertions.assertEquals("extension{url=testUrl}", output);
    }

}
