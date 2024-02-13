package org.fhirpath.dictionaries.r4.elements;

import org.fhirpath.dictionaries.framework.AbstractDefinition;
import org.hl7.fhir.r4.model.Address;
import org.hl7.fhir.r4.model.Base;

public class AddressDefinition extends AbstractDefinition<Base> {
    @Override
    protected void initialize() {
        this.paths.putAll(new ElementDefinition().getPaths());
        this.paths.put("use", arg -> ((Address) arg).getUse());
        this.paths.put("type", arg -> ((Address) arg).getType());
        this.paths.put("text", arg -> ((Address) arg).getTextElement());
        this.paths.put("line", arg -> ((Address) arg).getLine());
        this.paths.put("city", arg -> ((Address) arg).getCityElement());
        this.paths.put("district", arg -> ((Address) arg).getDistrictElement());
        this.paths.put("state", arg -> ((Address) arg).getStateElement());
        this.paths.put("postalCode", arg -> ((Address) arg).getPostalCodeElement());
        this.paths.put("country", arg -> ((Address) arg).getCountryElement());
        this.paths.put("period", arg -> ((Address) arg).getPeriod());
    }

    @Override
    public String getName() {
        return "Address";
    }
}
