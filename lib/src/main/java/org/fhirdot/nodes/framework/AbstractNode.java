package org.fhirdot.nodes.framework;

import org.fhirdot.cache.LruInMemoryNodeCache;
import org.fhirdot.cache.framework.NodeCache;
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
    protected final NodeCache cache = new LruInMemoryNodeCache();

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

    /**
     * Evaluates an individual field path against a Base FHIR structure and returns the result
     * @param base The Base FHIR structure being evaluated
     * @param field The field being evaluated
     * @param <Base> The Base FHIR structure class
     * @param <Result> Generic result class
     * @return Result containing evaluation determination
     * @throws FhirDotException When errors occur reading from Dictionary or evaluating paths
     */
    protected <Base, Result> Result evaluatePath(Base base, String field) throws FhirDotException {
        Result result = this.cache.get(base, field);
        if (result != null) {
            return result;
        }
        Map<String, Function<Base, Object>> fields = this.getPaths(base);
        if (fields == null) {
            throw new FhirDotException(String.format("Paths are not defined for %s", base.getClass().getName()));
        }
        Function<Base, Object> evaluator = fields.get(field);
        if (evaluator == null) {
            throw new FhirDotException(String.format("Path %s is not defined for %s", field, base.getClass().getName()));
        }
        result = (Result) evaluator.apply(base);
        this.cache.put(base, field, result);
        return result;
    }

    /**
     * Provides all available paths for a given Base FHIR structure
     * @param base The Base FHIR structure being evaluated
     * @param <Base> The Base FHIR structure class
     * @return All available Paths for a given FHIR structure
     * @throws FhirDotException When errors occur retrieving Dictionary instance
     */
    protected <Base> Map<String, Function<Base, Object>> getPaths(Base base) throws FhirDotException {
        Dictionary<Base> dictionary = this.getDictionaryFactory().getDictionary(base);
        return dictionary.getPaths(base);
    }

}
