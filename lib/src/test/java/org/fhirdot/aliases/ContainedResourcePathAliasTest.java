package org.fhirdot.aliases;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ContainedResourcePathAliasTest {

    @Test
    public void testContainedResourcePathAliasPattern() {
        ContainedResourcePathAlias alias = new ContainedResourcePathAlias();
        String path = "contained(Patient)";
        Assertions.assertTrue(alias.getPattern().matcher(path).find());
    }

    @Test
    public void testContainedResourcePathAliasMutator() {
        ContainedResourcePathAlias alias = new ContainedResourcePathAlias();
        String path = "contained(Patient)";
        String output = alias.getMutator().apply(path);
        Assertions.assertEquals("contained{resourceType=Patient}", output);
    }

}
