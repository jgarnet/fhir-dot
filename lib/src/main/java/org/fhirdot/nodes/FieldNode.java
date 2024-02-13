package org.fhirdot.nodes;

import org.fhirdot.exceptions.FhirDotException;
import org.fhirdot.nodes.framework.AbstractNode;

import java.util.List;
import java.util.regex.Pattern;

public class FieldNode extends AbstractNode {

    private final Pattern PATTERN = Pattern.compile("^\\w+$");

    @Override
    public <Base> boolean matches(Base base, String path) {
        return !(base instanceof List) && PATTERN.matcher(path).matches();
    }

    @Override
    public <Base, Result> Result evaluate(Base base, String path) throws FhirDotException {
        return this.evaluatePath(base, path);
    }
}
