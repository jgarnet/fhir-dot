package org.fhirdot.dictionaries.r4.elements;

import org.fhirdot.dictionaries.framework.AbstractDefinition;
import org.hl7.fhir.r4.model.Base;
import org.hl7.fhir.r4.model.Coding;

public class CodingDefinition extends AbstractDefinition<Base, Coding> {
    @Override
    protected void initialize() {
        this.putAllPaths(new ElementDefinition().getPaths());
        // system
        this.putPath("system", Coding::getSystemElement);
        // version
        this.putPath("version", Coding::getVersionElement);
        // code
        this.putPath("code", Coding::getCodeElement);
        // display
        this.putPath("display", Coding::getDisplayElement);
        // userSelected
        this.putPath("userSelected", Coding::getUserSelectedElement);
    }

    @Override
    public String getName() {
        return "Coding";
    }
}
