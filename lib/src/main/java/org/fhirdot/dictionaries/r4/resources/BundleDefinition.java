package org.fhirdot.dictionaries.r4.resources;

import org.fhirdot.dictionaries.framework.AbstractDefinition;
import org.hl7.fhir.r4.model.Base;
import org.hl7.fhir.r4.model.Bundle;

public class BundleDefinition extends AbstractDefinition<Base, Bundle> {
    @Override
    protected void initialize() {
        this.putAllPaths(new DomainResourceDefinition().getPaths());
        // identifier
        this.putPath("identifier", Bundle::getIdentifier);
        // type
        this.putPath("type", Bundle::getType);
        // timestamp
        this.putPath("timestamp", Bundle::getTimestampElement);
        // total
        this.putPath("total", Bundle::getTotalElement);
        // link
        this.putPath("link", Bundle::getLink);
        // entry
        this.putPath("entry", Bundle::getEntry);
        // signature
        this.putPath("signature", Bundle::getSignature);
    }

    @Override
    public String getName() {
        return "Bundle";
    }
}
