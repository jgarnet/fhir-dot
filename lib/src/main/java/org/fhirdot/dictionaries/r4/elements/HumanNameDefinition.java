package org.fhirdot.dictionaries.r4.elements;

import org.fhirdot.dictionaries.framework.AbstractDefinition;
import org.hl7.fhir.r4.model.Base;
import org.hl7.fhir.r4.model.HumanName;

public class HumanNameDefinition extends AbstractDefinition<Base> {
    @Override
    protected void initialize() {
        this.paths.putAll(new ElementDefinition().getPaths());
        // use
        this.paths.put("use", arg -> ((HumanName) arg).getUse());
        // text
        this.paths.put("text", arg -> ((HumanName) arg).getTextElement());
        // family
        this.paths.put("family", arg -> ((HumanName) arg).getFamilyElement());
        // given
        this.paths.put("given", arg -> ((HumanName) arg).getGiven());
        // prefix
        this.paths.put("prefix", arg -> ((HumanName) arg).getPrefix());
        // suffix
        this.paths.put("suffix", arg -> ((HumanName) arg).getSuffix());
        // period
        this.paths.put("period", arg -> ((HumanName) arg).getPeriod());
        // nameAsSingleString
        this.paths.put("nameAsSingleString", arg -> ((HumanName) arg).getNameAsSingleString());
        // givenAsSingleString
        this.paths.put("givenAsSingleString", arg -> ((HumanName) arg).getGivenAsSingleString());
        // prefixAsSingleString
        this.paths.put("prefixAsSingleString", arg -> ((HumanName) arg).getPrefixAsSingleString());
        // suffixAsSingleString
        this.paths.put("suffixAsSingleString", arg -> ((HumanName) arg).getSuffixAsSingleString());
    }

    @Override
    public String getName() {
        return "HumanName";
    }
}
