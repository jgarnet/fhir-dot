package org.fhirpath.dictionaries.r4.elements;

import org.fhirpath.dictionaries.framework.AbstractDefinitions;
import org.hl7.fhir.r4.model.Base;
import org.hl7.fhir.r4.model.ContactPoint;

public class ContactPointDefinitions extends AbstractDefinitions<Base> {
    @Override
    protected void initialize() {
        this.definitions.putAll(new ElementDefinitions().getDefinitions());
        // system
        this.definitions.put("system", arg -> ((ContactPoint) arg).getSystem());
        // value
        this.definitions.put("value", arg -> ((ContactPoint) arg).getValueElement());
        // use
        this.definitions.put("use", arg -> ((ContactPoint) arg).getUse());
        // rank
        this.definitions.put("rank", arg -> ((ContactPoint) arg).getRankElement());
        // period
        this.definitions.put("period", arg -> ((ContactPoint) arg).getPeriod());
    }

    @Override
    public String getName() {
        return "ContactPoint";
    }
}
