package org.fhirpath.dictionaries.r4.resources;

import org.fhirpath.dictionaries.framework.AbstractDefinition;
import org.hl7.fhir.r4.model.Base;
import org.hl7.fhir.r4.model.Resource;

public class ResourceDefinition extends AbstractDefinition<Base> {
    @Override
    protected void initialize() {
        // id
        this.paths.put("id", arg -> ((Resource) arg).getIdElement());
        // meta
        this.paths.put("meta", arg -> ((Resource) arg).getMeta());
        // implicitRules
        this.paths.put("implicitRules", arg -> ((Resource) arg).getImplicitRulesElement());
        // language
        this.paths.put("language", arg -> ((Resource) arg).getLanguageElement());
        // resourceType
        this.paths.put("resourceType", arg -> ((Resource) arg).getResourceType());
    }

    @Override
    public String getName() {
        return "Resource";
    }
}
