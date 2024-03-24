package org.fhirdot.dictionaries.r4.resources;

import org.fhirdot.dictionaries.framework.AbstractDefinition;
import org.hl7.fhir.r4.model.Base;
import org.hl7.fhir.r4.model.Resource;

public class ResourceDefinition extends AbstractDefinition<Base, Resource> {
    @Override
    protected void initialize() {
        // id
        this.putPath("id", Resource::getIdElement);
        // meta
        this.putPath("meta", Resource::getMeta);
        // implicitRules
        this.putPath("implicitRules", Resource::getImplicitRulesElement);
        // language
        this.putPath("language", Resource::getLanguageElement);
        // resourceType
        this.putPath("resourceType", Resource::getResourceType);
    }

    @Override
    public String getName() {
        return "Resource";
    }
}
