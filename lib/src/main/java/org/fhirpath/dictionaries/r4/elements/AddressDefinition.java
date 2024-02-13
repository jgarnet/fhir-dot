package org.fhirpath.dictionaries.r4.elements;

import org.fhirpath.dictionaries.framework.AbstractDefinitions;
import org.hl7.fhir.r4.model.Address;
import org.hl7.fhir.r4.model.Base;

public class AddressDefinitions extends AbstractDefinitions<Base> {
    @Override
    protected void initialize() {
        this.definitions.putAll(new ElementDefinitions().getDefinitions());
        this.definitions.put("use", arg -> ((Address) arg).getUse());
        this.definitions.put("type", arg -> ((Address) arg).getType());
        this.definitions.put("text", arg -> ((Address) arg).getTextElement());
        this.definitions.put("line", arg -> ((Address) arg).getLine());
        this.definitions.put("city", arg -> ((Address) arg).getCityElement());
        this.definitions.put("district", arg -> ((Address) arg).getDistrictElement());
        this.definitions.put("state", arg -> ((Address) arg).getStateElement());
        this.definitions.put("postalCode", arg -> ((Address) arg).getPostalCodeElement());
        this.definitions.put("country", arg -> ((Address) arg).getCountryElement());
        this.definitions.put("period", arg -> ((Address) arg).getPeriod());
    }

    @Override
    public String getName() {
        return "Address";
    }
}
