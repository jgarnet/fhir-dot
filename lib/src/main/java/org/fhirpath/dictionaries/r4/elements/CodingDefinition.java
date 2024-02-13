package org.fhirpath.dictionaries.r4.elements;

import org.fhirpath.dictionaries.framework.AbstractDefinition;
import org.hl7.fhir.r4.model.Base;
import org.hl7.fhir.r4.model.Coding;

public class CodingDefinition extends AbstractDefinition<Base> {
    @Override
    protected void initialize() {
        this.paths.putAll(new ElementDefinition().getPaths());
        // system
        this.paths.put("system", arg -> ((Coding) arg).getSystemElement());
        // version
        this.paths.put("version", arg -> ((Coding) arg).getVersionElement());
        // code
        this.paths.put("code", arg -> ((Coding) arg).getCodeElement());
        // display
        this.paths.put("display", arg -> ((Coding) arg).getDisplayElement());
        // userSelected
        this.paths.put("userSelected", arg -> ((Coding) arg).getUserSelectedElement());
    }

    @Override
    public String getName() {
        return "Coding";
    }
}
