package org.fhirdot.nodes.framework;

import org.fhirdot.dictionaries.framework.DictionaryFactory;
import org.fhirdot.exceptions.FhirDotException;
import org.fhirdot.framework.Rules;
import org.fhirdot.utils.FhirDotUtils;

public interface Node {
    Rules getRules();
    Node setRules(Rules rules);
    FhirDotUtils getUtils();
    Node setUtils(FhirDotUtils utils);
    DictionaryFactory getDictionaryFactory();
    Node setDictionaryFactory(DictionaryFactory factory);
    <Base> boolean matches(Base base, String path);
    <Base, Result> Result evaluate(Base base, String path) throws FhirDotException;
}
