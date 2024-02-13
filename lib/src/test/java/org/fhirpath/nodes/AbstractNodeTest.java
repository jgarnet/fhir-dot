package org.fhirpath.nodes;

import org.fhirpath.dictionaries.framework.FhirDictionaryFactory;
import org.fhirpath.framework.Rules;
import org.fhirpath.nodes.framework.Node;
import org.fhirpath.utils.FhirPathUtils;

public abstract class AbstractNodeTest {

    public AbstractNodeTest() {
        Rules rules = new Rules().setDateFormat("yyyy-MM-dd").setUnwrapPrimitives(true);
        FhirDictionaryFactory factory = new FhirDictionaryFactory();
        FhirPathUtils utils = new FhirPathUtils();
        this.getNode().setDictionaryFactory(factory).setRules(rules).setUtils(utils);
    }

    protected abstract Node getNode();

}
