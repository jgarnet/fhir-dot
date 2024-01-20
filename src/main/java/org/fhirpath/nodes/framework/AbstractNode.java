package org.fhirpath.nodes.framework;

import org.fhirpath.dictionaries.framework.FhirDictionary;
import org.fhirpath.dictionaries.framework.FhirDictionaryFactory;
import org.fhirpath.exceptions.FhirPathException;
import org.fhirpath.framework.Rules;
import org.fhirpath.utils.FhirPathUtils;

import java.util.Map;
import java.util.function.Function;

@SuppressWarnings("unchecked")
public abstract class AbstractNode implements Node {

    private Rules rules;
    private FhirPathUtils utils;
    private FhirDictionaryFactory dictionaryFactory;

    @Override
    public Rules getRules() {
        return this.rules;
    }

    @Override
    public Node setRules(Rules rules) {
        this.rules = rules;
        return this;
    }

    @Override
    public FhirPathUtils getUtils() {
        return utils;
    }

    @Override
    public Node setUtils(FhirPathUtils utils) {
        this.utils = utils;
        return this;
    }

    @Override
    public FhirDictionaryFactory getDictionaryFactory() {
        return this.dictionaryFactory;
    }

    @Override
    public Node setDictionaryFactory(FhirDictionaryFactory factory) {
        this.dictionaryFactory = factory;
        return this;
    }

    protected <Base, Result> Result getValue(Base base, String field) throws FhirPathException {
        Map<String, Function<Base, Object>> fields = this.getFieldDefinitions(base);
        return (Result) fields.get(field).apply(base);
    }

    protected  <Base> Map<String, Function<Base, Object>> getFieldDefinitions(Base base) throws FhirPathException {
        FhirDictionary<Base> dictionary = this.getDictionaryFactory().getDictionary(base);
        return dictionary.getBaseDefinitions(base);
    }

}
