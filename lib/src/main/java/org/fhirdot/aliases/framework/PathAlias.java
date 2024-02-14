package org.fhirdot.aliases.framework;

import java.util.function.Function;
import java.util.regex.Pattern;

/**
 * Provides ability to leverage short-hand aliases in place of longform, chained path operations.
 */
public interface PathAlias {
    /**
     * Provides a Pattern which is used to determine if the Alias is present in a given Path.
     * @return Pattern used to evaluate if the Alias is present in a path.
     */
    Pattern getPattern();

    /**
     * Provides a Function which will replace the short-hand alias with its longform operations.
     * @return Function which mutates a String path.
     */
    Function<String, String> getMutator();
}
