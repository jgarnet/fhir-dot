package org.fhirpath.dictionaries.r4.resources;

import org.fhirpath.dictionaries.framework.AbstractDefinitions;
import org.hl7.fhir.r4.model.Base;
import org.hl7.fhir.r4.model.Bundle;

public class BundleDefinitions extends AbstractDefinitions<Base> {
    @Override
    protected void initialize() {
        this.definitions.putAll(new DomainResourceDefinitions().getDefinitions());
        // identifier
        this.definitions.put("identifier", arg -> ((Bundle) arg).getIdentifier());
        // type
        this.definitions.put("type", arg -> ((Bundle) arg).getType());
        // timestamp
        this.definitions.put("timestamp", arg -> ((Bundle) arg).getTimestampElement());
        // total
        this.definitions.put("total", arg -> ((Bundle) arg).getTotalElement());
        // link
        this.definitions.put("link", arg -> ((Bundle) arg).getLink());
        // entry
        this.definitions.put("entry", arg -> ((Bundle) arg).getEntry());
        // signature
        this.definitions.put("signature", arg -> ((Bundle) arg).getSignature());
    }

    @Override
    public String getName() {
        return "Bundle";
    }
}
