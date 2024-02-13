package org.fhirpath.utils;

import org.apache.commons.lang3.StringUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * Parses dot-notation String to find all outermost conditions.
 */
public class ConditionParser {

    public List<String> parse(String path) {
        List<String> conditionalFields = new ArrayList<>();
        int firstBrace;
        do {
            // walk through String to extract each field matching pattern: field{...}
            // account for nested braces using counter
            int braceCount = 0;
            firstBrace = path.indexOf("{");
            if (firstBrace != -1) {
                StringBuilder sb = new StringBuilder();
                // edge-case for multiple conditions
                // i.e. someField{condition1}.field2.item{condition2} --> field2.item{condition2} (not valid)
                int lastDot = path.substring(0, firstBrace).indexOf('.');
                if (lastDot == -1) {
                    sb.append(path, 0, firstBrace);
                } else {
                    for (int i = firstBrace; i < path.length(); i++) {
                        sb.append(path.charAt(i));
                    }
                }
                for (int i = firstBrace; i < path.length(); i++) {
                    char current = path.charAt(i);
                    sb.append(current);
                    if (current == '{') {
                        braceCount++;
                    } else if (current == '}') {
                        if (braceCount == 1) {
                            break;
                        } else {
                            braceCount--;
                        }
                    }
                }
                String value = sb.toString();
                conditionalFields.add(value);
                path = path.replace(value, "");
                // edge-case for leading dot
                if (StringUtils.isNotEmpty(path) && path.charAt(0) == '.') {
                    path = path.substring(1);
                }
            }
        } while (firstBrace > 0);
        return conditionalFields;
    }

}
