package org.fhirdot.evaluators.framework;

import org.apache.commons.lang3.time.FastDateFormat;
import org.fhirdot.framework.Rules;
import org.fhirdot.utils.FhirDotUtils;

import java.text.ParseException;
import java.util.Date;

@SuppressWarnings("rawtypes")
public abstract class AbstractConditionEvaluator implements ConditionEvaluator {

    private Rules rules;
    private FhirDotUtils utils;

    @Override
    public Rules getRules() {
        return this.rules;
    }

    @Override
    public ConditionEvaluator setRules(Rules rules) {
        this.rules = rules;
        return this;
    }

    @Override
    public FhirDotUtils getUtils() {
        return utils;
    }

    @Override
    public ConditionEvaluator setUtils(FhirDotUtils utils) {
        this.utils = utils;
        return this;
    }
}
