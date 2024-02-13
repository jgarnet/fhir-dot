package org.fhirdot.dictionaries.r4.elements;

import org.fhirdot.dictionaries.framework.AbstractDefinition;
import org.hl7.fhir.r4.model.Base;
import org.hl7.fhir.r4.model.Extension;

public class ExtensionDefinition extends AbstractDefinition<Base> {
    @Override
    protected void initialize() {
        this.paths.putAll(new ElementDefinition().getPaths());
        // url
        this.paths.put("url", arg -> ((Extension) arg).getUrl());
        // value
        this.paths.put("value", arg -> ((Extension) arg).getValue());
    }

    @Override
    public String getName() {
        return "Extension";
    }
}
