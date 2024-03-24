package org.fhirdot.dictionaries.r4.resources;

import org.fhirdot.dictionaries.framework.AbstractDefinition;
import org.hl7.fhir.r4.model.Base;
import org.hl7.fhir.r4.model.Claim;

public class ClaimDefinition extends AbstractDefinition<Base, Claim> {
    @Override
    protected void initialize() {

    }

    @Override
    public String getName() {
        return "Claim";
    }
}
