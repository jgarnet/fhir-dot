package org.fhirdot.readers;

import org.fhirdot.aliases.PathAliases;
import org.fhirdot.aliases.framework.PathAlias;
import org.fhirdot.cache.LruInMemoryNodeCache;
import org.fhirdot.cache.framework.NodeCache;
import org.fhirdot.dictionaries.framework.DictionaryFactory;
import org.fhirdot.exceptions.FhirDotException;
import org.fhirdot.framework.Rules;
import org.fhirdot.nodes.Nodes;
import org.fhirdot.nodes.framework.Node;
import org.fhirdot.parsers.BaseNodeParser;
import org.fhirdot.parsers.NodeParser;
import org.fhirdot.readers.framework.PathReader;
import org.fhirdot.utils.FhirDotUtils;

import java.util.List;
import java.util.regex.Matcher;

@SuppressWarnings("unchecked")
public class BasePathReader implements PathReader {

    private Nodes nodes;
    private NodeCache cache;
    private PathAliases pathAliases;
    private FhirDotUtils utils;
    private Rules rules;
    private NodeParser nodeParser;

    public BasePathReader() {
        DictionaryFactory factory = new DictionaryFactory();
        this.cache = new LruInMemoryNodeCache();
        this.rules = new Rules().setDateFormat("yyyy-MM-dd").setUnwrapPrimitives(true);
        this.utils = new FhirDotUtils();
        this.nodes = new Nodes(rules, utils, factory);
        this.pathAliases = new PathAliases();
        this.nodeParser = new BaseNodeParser();
    }

    public BasePathReader(Nodes nodes, NodeCache cache, PathAliases pathAliases, FhirDotUtils utils, Rules rules, NodeParser nodeParser) {
        this.nodes = nodes;
        this.cache = cache;
        this.pathAliases = pathAliases;
        this.utils = utils;
        this.rules = rules;
        this.nodeParser = nodeParser;
    }

    @Override
    public <Base, Result> Result read(Base base, String path) throws FhirDotException {
        Result cacheResult = this.cache.get(base, path);
        if (cacheResult != null) {
            return cacheResult;
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
        List<String> _nodes = this.nodeParser.parse(mutatedPath);
        // retrieve target
        Base target = base;
        for (String node : _nodes) {
            Base nodeCacheResult = this.cache.get(target, node);
            if (nodeCacheResult != null) {
                target = nodeCacheResult;
                continue;
            }
            for (Node _node : this.nodes.getNodes()) {
                if (_node.matches(target, node)) {
                    Base current = target;
                    target = _node.evaluate(target, node);
                    this.cache.put(current, node, target);
                    break;
                }
            }
        }
        Result result = (Result) target;
        if (this.rules.shouldUnwrapPrimitives()) {
            result = this.utils.unwrapPrimitiveType(result);
        }
        this.cache.put(base, path, result);
        return result;
    }

    public void setNodes(Nodes nodes) {
        this.nodes = nodes;
    }

    public void setCache(NodeCache cache) {
        this.cache = cache;
    }

    public void setPathAliases(PathAliases pathAliases) {
        this.pathAliases = pathAliases;
    }

    public void setUtils(FhirDotUtils utils) {
        this.utils = utils;
    }

    public void setRules(Rules rules) {
        this.rules = rules;
    }

    public void setNodeParser(NodeParser nodeParser) {
        this.nodeParser = nodeParser;
    }
}
