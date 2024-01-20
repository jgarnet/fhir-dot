package org.fhirpath.aliases;

import org.fhirpath.aliases.framework.PathAlias;

import java.util.ArrayList;
import java.util.List;

public class PathAliases {
    private final List<PathAlias> aliases;

    public PathAliases() {
        // insertion order is important here as it will impact order of mutation operations
        this.aliases = new ArrayList<>(7);
        this.aliases.add(new ConditionalResourcePathAlias());
        this.aliases.add(new ResourcePathAlias());
        this.aliases.add(new ConditionalExtensionPathAlias());
        this.aliases.add(new ExtensionPathAlias());
        this.aliases.add(new ExtensionValueCastPathAlias());
        this.aliases.add(new ConditionalContainedResourcePathAlias());
        this.aliases.add(new ContainedResourcePathAlias());
    }

    public List<PathAlias> getAliases() {
        return this.aliases;
    }

}
