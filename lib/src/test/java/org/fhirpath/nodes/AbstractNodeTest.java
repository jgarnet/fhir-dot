package org.fhirpath.nodes;

import org.fhirpath.dictionaries.framework.DictionaryFactory;
import org.fhirpath.framework.Rules;
import org.fhirpath.nodes.framework.Node;
import org.fhirpath.utils.FhirPathUtils;

public abstract class AbstractNodeTest {

    public AbstractNodeTest() {
        Rules rules = new Rules().setDateFormat("yyyy-MM-dd").setUnwrapPrimitives(true);
        DictionaryFactory factory = new DictionaryFactory();
        FhirPathUtils utils = new FhirPathUtils();
        this.getNode().setDictionaryFactory(factory).setRules(rules).setUtils(utils);
    }

    protected abstract Node getNode();

}
