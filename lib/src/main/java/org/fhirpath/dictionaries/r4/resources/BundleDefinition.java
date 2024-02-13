package org.fhirpath.dictionaries.r4.resources;

import org.fhirpath.dictionaries.framework.AbstractDefinition;
import org.hl7.fhir.r4.model.Base;
import org.hl7.fhir.r4.model.Bundle;

public class BundleDefinition extends AbstractDefinition<Base> {
    @Override
    protected void initialize() {
        this.paths.putAll(new DomainResourceDefinition().getPaths());
        // identifier
        this.paths.put("identifier", arg -> ((Bundle) arg).getIdentifier());
        // type
        this.paths.put("type", arg -> ((Bundle) arg).getType());
        // timestamp
        this.paths.put("timestamp", arg -> ((Bundle) arg).getTimestampElement());
        // total
        this.paths.put("total", arg -> ((Bundle) arg).getTotalElement());
        // link
        this.paths.put("link", arg -> ((Bundle) arg).getLink());
        // entry
        this.paths.put("entry", arg -> ((Bundle) arg).getEntry());
        // signature
        this.paths.put("signature", arg -> ((Bundle) arg).getSignature());
    }

    @Override
    public String getName() {
        return "Bundle";
    }
}
