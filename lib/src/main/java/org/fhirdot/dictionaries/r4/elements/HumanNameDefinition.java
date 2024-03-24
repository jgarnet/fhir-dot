package org.fhirdot.dictionaries.r4.elements;

import org.fhirdot.dictionaries.framework.AbstractDefinition;
import org.hl7.fhir.r4.model.Base;
import org.hl7.fhir.r4.model.HumanName;

public class HumanNameDefinition extends AbstractDefinition<Base, HumanName> {
    @Override
    protected void initialize() {
        this.putAllPaths(new ElementDefinition().getPaths());
        // use
        this.putPath("use", HumanName::getUse);
        // text
        this.putPath("text", HumanName::getTextElement);
        // family
        this.putPath("family", HumanName::getFamilyElement);
        // given
        this.putPath("given", HumanName::getGiven);
        // prefix
        this.putPath("prefix", HumanName::getPrefix);
        // suffix
        this.putPath("suffix", HumanName::getSuffix);
        // period
        this.putPath("period", HumanName::getPeriod);
        // nameAsSingleString
        this.putPath("nameAsSingleString", HumanName::getNameAsSingleString);
        // givenAsSingleString
        this.putPath("givenAsSingleString", HumanName::getGivenAsSingleString);
        // prefixAsSingleString
        this.putPath("prefixAsSingleString", HumanName::getPrefixAsSingleString);
        // suffixAsSingleString
        this.putPath("suffixAsSingleString", HumanName::getSuffixAsSingleString);
    }

    @Override
    public String getName() {
        return "HumanName";
    }
}
