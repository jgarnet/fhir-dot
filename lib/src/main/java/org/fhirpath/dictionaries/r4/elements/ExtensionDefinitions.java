package org.fhirpath.dictionaries.r4.elements;

import org.fhirpath.dictionaries.framework.AbstractDefinitions;
import org.hl7.fhir.r4.model.Base;
import org.hl7.fhir.r4.model.Extension;

public class ExtensionDefinitions extends AbstractDefinitions<Base> {
    @Override
    protected void initialize() {
        this.definitions.putAll(new ElementDefinitions().getDefinitions());
        // url
        this.definitions.put("url", arg -> ((Extension) arg).getUrl());
        // value
        this.definitions.put("value", arg -> ((Extension) arg).getValue());
    }

    @Override
    public String getName() {
        return "Extension";
    }
}
