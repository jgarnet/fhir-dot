package org.fhirdot.nodes;

import org.apache.commons.collections4.CollectionUtils;
import org.fhirdot.exceptions.FhirDotException;
import org.fhirdot.nodes.framework.AbstractNode;

import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

@SuppressWarnings("unchecked")
public class CollectionNode extends AbstractNode {

    private final Pattern PATTERN = Pattern.compile("^\\w+$");
    private final Pattern DIGIT_PATTERN = Pattern.compile("^\\d+|[Nn]$");

    @Override
    public <Base> boolean matches(Base base, String path) {
        return base instanceof List
                && CollectionUtils.isNotEmpty((List<Base>) base)
                && !DIGIT_PATTERN.matcher(path).matches()
                && PATTERN.matcher(path).matches();
    }

    @Override
    public <Base, Result> Result evaluate(Base base, String path) throws FhirDotException {
        Map<String, Function<Base, Object>> fields = this.getPaths(((List<Base>) base).get(0));
        Function<Base, Object> mapper = fields.get(path);
        return (Result) ((List<Base>) base).stream().map(mapper).collect(Collectors.toList());
    }
}
