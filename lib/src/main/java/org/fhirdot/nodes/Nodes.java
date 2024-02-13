package org.fhirdot.nodes;

import org.fhirdot.dictionaries.framework.DictionaryFactory;
import org.fhirdot.framework.Rules;
import org.fhirdot.nodes.framework.Node;
import org.fhirdot.utils.FhirDotUtils;

import java.util.HashSet;
import java.util.Set;

public class Nodes {
    private final Set<Node> nodes;

    public Nodes(Rules rules, FhirDotUtils utils, DictionaryFactory factory) {
        this.nodes = new HashSet<>();
        this.nodes.add(new FieldNode().setRules(rules).setDictionaryFactory(factory).setUtils(utils));
        this.nodes.add(new CollectionItemNode().setRules(rules).setDictionaryFactory(factory).setUtils(utils));
        this.nodes.add(new CollectionNode().setRules(rules).setDictionaryFactory(factory).setUtils(utils));
        this.nodes.add(new ConditionNode().setRules(rules).setDictionaryFactory(factory).setUtils(utils));
    }

    public Set<Node> getNodes() {
        return this.nodes;
    }
}
