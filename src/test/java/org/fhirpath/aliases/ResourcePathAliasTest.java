package org.fhirpath.aliases;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ResourcePathAliasTest {

    @Test
    public void testResourcePathAliasPattern() {
        ResourcePathAlias alias = new ResourcePathAlias();
        String path = "$ClaimResponse.patient";
        Assertions.assertTrue(alias.getPattern().matcher(path).find());
    }

    @Test
    public void testResourcePathAliasMutator() {
        ResourcePathAlias alias = new ResourcePathAlias();
        String path1 = "$ClaimResponse.patient";
        String path2 = "$ClaimResponse";
        String output1 = alias.getMutator().apply(path1);
        String output2 = alias.getMutator().apply(path2);
        Assertions.assertEquals("entry{resource.resourceType=ClaimResponse}.0.resource", output1);
        Assertions.assertEquals("entry{resource.resourceType=ClaimResponse}.0.resource", output2);
    }

}
