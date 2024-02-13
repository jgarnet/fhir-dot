package org.fhirpath.dictionaries.r4.resources;

import org.fhirpath.dictionaries.framework.AbstractDefinitions;
import org.hl7.fhir.r4.model.Base;
import org.hl7.fhir.r4.model.Resource;

public class ResourceDefinitions extends AbstractDefinitions<Base> {
    @Override
    protected void initialize() {
        // id
        this.definitions.put("id", arg -> ((Resource) arg).getIdElement());
        // meta
        this.definitions.put("meta", arg -> ((Resource) arg).getMeta());
        // implicitRules
        this.definitions.put("implicitRules", arg -> ((Resource) arg).getImplicitRulesElement());
        // language
        this.definitions.put("language", arg -> ((Resource) arg).getLanguageElement());
        // resourceType
        this.definitions.put("resourceType", arg -> ((Resource) arg).getResourceType());
    }

    @Override
    public String getName() {
        return "Resource";
    }
}
