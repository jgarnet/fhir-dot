package org.fhirpath.dictionaries.r4.elements;

import org.fhirpath.dictionaries.framework.AbstractDefinitions;
import org.hl7.fhir.r4.model.Base;
import org.hl7.fhir.r4.model.HumanName;

public class HumanNameDefinitions extends AbstractDefinitions<Base> {
    @Override
    protected void initialize() {
        this.definitions.putAll(new ElementDefinitions().getDefinitions());
        // use
        this.definitions.put("use", arg -> ((HumanName) arg).getUse());
        // text
        this.definitions.put("text", arg -> ((HumanName) arg).getTextElement());
        // family
        this.definitions.put("family", arg -> ((HumanName) arg).getFamilyElement());
        // given
        this.definitions.put("given", arg -> ((HumanName) arg).getGiven());
        // prefix
        this.definitions.put("prefix", arg -> ((HumanName) arg).getPrefix());
        // suffix
        this.definitions.put("suffix", arg -> ((HumanName) arg).getSuffix());
        // period
        this.definitions.put("period", arg -> ((HumanName) arg).getPeriod());
        // nameAsSingleString
        this.definitions.put("nameAsSingleString", arg -> ((HumanName) arg).getNameAsSingleString());
        // givenAsSingleString
        this.definitions.put("givenAsSingleString", arg -> ((HumanName) arg).getGivenAsSingleString());
        // prefixAsSingleString
        this.definitions.put("prefixAsSingleString", arg -> ((HumanName) arg).getPrefixAsSingleString());
        // suffixAsSingleString
        this.definitions.put("suffixAsSingleString", arg -> ((HumanName) arg).getSuffixAsSingleString());
    }

    @Override
    public String getName() {
        return "HumanName";
    }
}
