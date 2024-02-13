package org.fhirdot.dictionaries.r4.elements;

import org.fhirdot.dictionaries.framework.AbstractDefinition;
import org.hl7.fhir.r4.model.Base;
import org.hl7.fhir.r4.model.ContactPoint;

public class ContactPointDefinition extends AbstractDefinition<Base> {
    @Override
    protected void initialize() {
        this.paths.putAll(new ElementDefinition().getPaths());
        // system
        this.paths.put("system", arg -> ((ContactPoint) arg).getSystem());
        // value
        this.paths.put("value", arg -> ((ContactPoint) arg).getValueElement());
        // use
        this.paths.put("use", arg -> ((ContactPoint) arg).getUse());
        // rank
        this.paths.put("rank", arg -> ((ContactPoint) arg).getRankElement());
        // period
        this.paths.put("period", arg -> ((ContactPoint) arg).getPeriod());
    }

    @Override
    public String getName() {
        return "ContactPoint";
    }
}
