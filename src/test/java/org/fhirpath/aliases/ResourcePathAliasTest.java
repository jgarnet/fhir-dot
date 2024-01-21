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
        String path = "$ClaimResponse.patient";
        String output = alias.getMutator().apply(path);
        Assertions.assertEquals("entry{resource.resourceType=ClaimResponse}.0.resource", output);
    }

}
