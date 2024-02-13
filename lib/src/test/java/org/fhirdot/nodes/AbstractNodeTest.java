package org.fhirdot.nodes;

import org.fhirdot.dictionaries.framework.DictionaryFactory;
import org.fhirdot.framework.Rules;
import org.fhirdot.nodes.framework.Node;
import org.fhirdot.utils.FhirDotUtils;

public abstract class AbstractNodeTest {

    public AbstractNodeTest() {
        Rules rules = new Rules().setDateFormat("yyyy-MM-dd").setUnwrapPrimitives(true);
        DictionaryFactory factory = new DictionaryFactory();
        FhirDotUtils utils = new FhirDotUtils();
        this.getNode().setDictionaryFactory(factory).setRules(rules).setUtils(utils);
    }

    protected abstract Node getNode();

}
