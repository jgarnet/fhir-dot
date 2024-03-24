package org.fhirdot.dictionaries.r4.elements;

import org.fhirdot.dictionaries.framework.AbstractDefinition;
import org.hl7.fhir.r4.model.Address;
import org.hl7.fhir.r4.model.Base;

public class AddressDefinition extends AbstractDefinition<Base, Address> {
    @Override
    protected void initialize() {
        this.putAllPaths(new ElementDefinition().getPaths());
        this.putPath("use", Address::getUse);
        this.putPath("type", Address::getType);
        this.putPath("text", Address::getTextElement);
        this.putPath("line", Address::getLine);
        this.putPath("city", Address::getCityElement);
        this.putPath("district", Address::getDistrictElement);
        this.putPath("state", Address::getStateElement);
        this.putPath("postalCode", Address::getPostalCodeElement);
        this.putPath("country", Address::getCountryElement);
        this.putPath("period", Address::getPeriod);
    }

    @Override
    public String getName() {
        return "Address";
    }
}
