package org.fhirdot.nodes.framework;

import org.fhirdot.dictionaries.framework.Dictionary;
import org.fhirdot.dictionaries.framework.DictionaryFactory;
import org.fhirdot.exceptions.FhirDotException;
import org.fhirdot.framework.Rules;
import org.fhirdot.utils.FhirDotUtils;

import java.util.Map;
import java.util.function.Function;

@SuppressWarnings("unchecked")
public abstract class AbstractNode implements Node {

    private Rules rules;
    private FhirDotUtils utils;
    private DictionaryFactory dictionaryFactory;

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
    public FhirDotUtils getUtils() {
        return utils;
    }

    @Override
    public Node setUtils(FhirDotUtils utils) {
        this.utils = utils;
        return this;
    }

    @Override
    public DictionaryFactory getDictionaryFactory() {
        return this.dictionaryFactory;
    }

    @Override
    public Node setDictionaryFactory(DictionaryFactory factory) {
        this.dictionaryFactory = factory;
        return this;
    }

    protected <Base, Result> Result evaluatePath(Base base, String field) throws FhirDotException {
        Map<String, Function<Base, Object>> fields = this.getPaths(base);
        return (Result) fields.get(field).apply(base);
    }

    protected <Base> Map<String, Function<Base, Object>> getPaths(Base base) throws FhirDotException {
        Dictionary<Base> dictionary = this.getDictionaryFactory().getDictionary(base);
        return dictionary.getPaths(base);
    }

}
