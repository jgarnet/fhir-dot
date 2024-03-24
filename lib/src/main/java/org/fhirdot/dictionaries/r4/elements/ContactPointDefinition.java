package org.fhirdot.dictionaries.r4.elements;

import org.fhirdot.dictionaries.framework.AbstractDefinition;
import org.hl7.fhir.r4.model.Base;
import org.hl7.fhir.r4.model.ContactPoint;

public class ContactPointDefinition extends AbstractDefinition<Base, ContactPoint> {
    @Override
    protected void initialize() {
        this.putAllPaths(new ElementDefinition().getPaths());
        // system
        this.putPath("system", ContactPoint::getSystem);
        // value
        this.putPath("value", ContactPoint::getValueElement);
        // use
        this.putPath("use", ContactPoint::getUse);
        // rank
        this.putPath("rank", ContactPoint::getRankElement);
        // period
        this.putPath("period", ContactPoint::getPeriod);
    }

    @Override
    public String getName() {
        return "ContactPoint";
    }
}
