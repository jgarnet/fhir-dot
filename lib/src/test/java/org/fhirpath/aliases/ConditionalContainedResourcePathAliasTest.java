package org.fhirpath.aliases;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ConditionalContainedResourcePathAliasTest {

    @Test
    public void testConditionalContainedResourcePathAliasPattern() {
        ConditionalContainedResourcePathAlias alias = new ConditionalContainedResourcePathAlias();
        String path = "contained(Patient){name.given=TEST}";
        Assertions.assertTrue(alias.getPattern().matcher(path).find());
    }

    @Test
    public void testConditionalContainedResourcePathAliasMutator() {
        ConditionalContainedResourcePathAlias alias = new ConditionalContainedResourcePathAlias();
        String path = "contained(Patient){name.given=TEST}";
        String output = alias.getMutator().apply(path);
        Assertions.assertEquals("contained{resourceType=Patient&&name.given=TEST}", output);
    }

}