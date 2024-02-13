package org.fhirpath.dictionaries.r4.elements;

import org.fhirpath.dictionaries.framework.AbstractDefinitions;
import org.hl7.fhir.r4.model.Base;
import org.hl7.fhir.r4.model.Coding;

public class CodingDefinitions extends AbstractDefinitions<Base> {
    @Override
    protected void initialize() {
        this.definitions.putAll(new ElementDefinitions().getDefinitions());
        // system
        this.definitions.put("system", arg -> ((Coding) arg).getSystemElement());
        // version
        this.definitions.put("version", arg -> ((Coding) arg).getVersionElement());
        // code
        this.definitions.put("code", arg -> ((Coding) arg).getCodeElement());
        // display
        this.definitions.put("display", arg -> ((Coding) arg).getDisplayElement());
        // userSelected
        this.definitions.put("userSelected", arg -> ((Coding) arg).getUserSelectedElement());
    }

    @Override
    public String getName() {
        return "Coding";
    }
}
