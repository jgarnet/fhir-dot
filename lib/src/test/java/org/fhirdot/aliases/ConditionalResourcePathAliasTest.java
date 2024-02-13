package org.fhirdot.aliases;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ConditionalResourcePathAliasTest {

    @Test
    public void testConditionalResourcePathAliasPattern() {
        ConditionalResourcePathAlias alias = new ConditionalResourcePathAlias();
        String path = "$ClaimResponse{id=TEST}";
        Assertions.assertTrue(alias.getPattern().matcher(path).find());
    }

    @Test
    public void testConditionalResourcePathAliasMutator() {
        ConditionalResourcePathAlias alias = new ConditionalResourcePathAlias();
        String path1 = "$ClaimResponse{id=TEST}.patient";
        String path2 = "$ClaimResponse{id=TEST}";
        String output1 = alias.getMutator().apply(path1);
        String output2 = alias.getMutator().apply(path2);
        Assertions.assertEquals("entry{resource.resourceType=ClaimResponse&&id=TEST}.0.resource", output1);
        Assertions.assertEquals("entry{resource.resourceType=ClaimResponse&&id=TEST}.0.resource", output2);
    }

}