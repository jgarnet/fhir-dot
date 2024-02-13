package org.fhirdot.readers;

import org.fhirdot.aliases.PathAliases;
import org.fhirdot.aliases.framework.PathAlias;
import org.fhirdot.dictionaries.framework.DictionaryFactory;
import org.fhirdot.exceptions.FhirDotException;
import org.fhirdot.framework.Rules;
import org.fhirdot.nodes.CollectionItemNode;
import org.fhirdot.nodes.CollectionNode;
import org.fhirdot.nodes.ConditionNode;
import org.fhirdot.nodes.FieldNode;
import org.fhirdot.nodes.framework.Node;
import org.fhirdot.readers.framework.PathReader;
import org.fhirdot.utils.FhirDotUtils;
import org.fhirdot.utils.NodeParser;

import java.util.*;
import java.util.regex.Matcher;

@SuppressWarnings("unchecked")
public class BasePathReader implements PathReader {

    private final Set<Node> nodes;
    private final Map<Integer, Map<String, Object>> cache;
    private final PathAliases pathAliases;
    private final FhirDotUtils utils;
    private final Rules rules;

    public BasePathReader() {
        DictionaryFactory factory = new DictionaryFactory();
        this.cache = new HashMap<>();
        this.rules = new Rules().setDateFormat("yyyy-MM-dd").setUnwrapPrimitives(true);
        this.utils = new FhirDotUtils();
        this.nodes = new HashSet<>();
        this.nodes.add(new FieldNode().setRules(rules).setDictionaryFactory(factory).setUtils(utils));
        this.nodes.add(new CollectionItemNode().setRules(rules).setDictionaryFactory(factory).setUtils(utils));
        this.nodes.add(new CollectionNode().setRules(rules).setDictionaryFactory(factory).setUtils(utils));
        this.nodes.add(new ConditionNode().setRules(rules).setDictionaryFactory(factory).setUtils(utils));
        this.pathAliases = new PathAliases();
    }

    @Override
    public Rules getRules() {
        return this.rules;
    }

    @Override
    public <Base, Result> Result read(Base base, String path) throws FhirDotException {
        Map<String, Object> pathCache = this.getNodeCache(base);
        Object cacheResult = pathCache.get(path);
        if (cacheResult != null) {
            return (Result) cacheResult;
        }
        // replace aliases in path before evaluating nodes
        String mutatedPath = path;
        for (PathAlias alias : this.pathAliases.getAliases()) {
            Matcher aliasMatcher = alias.getPattern().matcher(mutatedPath);
            while (aliasMatcher.find()) {
                String _alias = aliasMatcher.group();
                mutatedPath = mutatedPath.replace(_alias, alias.getMutator().apply(_alias));
            }
        }
        // extract nodes
        List<String> _nodes = new NodeParser().parse(mutatedPath);
        // retrieve target
        Base target = base;
        for (String node : _nodes) {
            Map<String, Object> nodeCache = this.getNodeCache(target);
            Object nodeCacheResult = nodeCache.get(node);
            if (nodeCacheResult != null) {
                target = (Base) nodeCacheResult;
                continue;
            }
            for (Node _node : this.nodes) {
                if (_node.matches(target, node)) {
                    target = _node.evaluate(target, node);
                    nodeCache.put(node, target);
                    break;
                }
            }
        }
        Result result = (Result) target;
        if (this.getRules().shouldUnwrapPrimitives()) {
            result = this.utils.unwrapPrimitiveType(result);
        }
        pathCache.put(path, result);
        return result;
    }

    protected <Base> Map<String, Object> getNodeCache(Base base) {
        return this.cache.computeIfAbsent(base.hashCode(), k -> new HashMap<>());
    }
}
