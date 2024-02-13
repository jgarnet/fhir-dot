package org.fhirpath.nodes;

import org.fhirpath.exceptions.FhirPathException;
import org.fhirpath.nodes.framework.AbstractNode;

import java.util.List;
import java.util.regex.Pattern;

@SuppressWarnings("unchecked")
public class CollectionItemNode extends AbstractNode {

    private final Pattern PATTERN = Pattern.compile("^\\d+|[Nn]$");

    @Override
    public <Base> boolean matches(Base base, String path) {
        return base instanceof List && PATTERN.matcher(path).matches();
    }

    @Override
    public <Base, Result> Result evaluate(Base base, String path) throws FhirPathException {
        int index = "N".equalsIgnoreCase(path) ? ((List<Base>) base).size() - 1 : Integer.parseInt(path);
        return (Result) ((List<Base>) base).get(index);
    }
}
