package org.fhirpath.nodes.framework;

import org.fhirpath.dictionaries.framework.FhirDictionaryFactory;
import org.fhirpath.exceptions.FhirPathException;
import org.fhirpath.framework.Rules;
import org.fhirpath.utils.FhirPathUtils;

public interface Node {
    Rules getRules();
    Node setRules(Rules rules);
    FhirPathUtils getUtils();
    Node setUtils(FhirPathUtils utils);
    FhirDictionaryFactory getDictionaryFactory();
    Node setDictionaryFactory(FhirDictionaryFactory factory);
    <Base> boolean matches(Base base, String path);
    <Base, Result> Result evaluate(Base base, String path) throws FhirPathException;
}
