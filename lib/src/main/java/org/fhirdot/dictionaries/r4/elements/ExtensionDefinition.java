package org.fhirdot.dictionaries.r4.elements;

import org.fhirdot.dictionaries.framework.AbstractDefinition;
import org.hl7.fhir.r4.model.Base;
import org.hl7.fhir.r4.model.Extension;

public class ExtensionDefinition extends AbstractDefinition<Base, Extension> {
    @Override
    protected void initialize() {
        this.putAllPaths(new ElementDefinition().getPaths());
        // url
        this.putPath("url", Extension::getUrl);
        // value
        this.putPath("value", Extension::getValue);
    }

    @Override
    public String getName() {
        return "Extension";
    }
}
