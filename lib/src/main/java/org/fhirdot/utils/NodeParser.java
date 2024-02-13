package org.fhirdot.utils;

import org.apache.commons.lang3.StringUtils;

import java.util.ArrayList;
import java.util.List;

public class NodeParser {

    public List<String> parse(String path) {
        List<String> nodes = new ArrayList<>();
        do {
            // walk through String to extract each node while accounting for nested dots in conditions
            // account for nested braces using counter
            int braceCount = 0;
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < path.length(); i++) {
                char current = path.charAt(i);
                if (current == '{') {
                    braceCount++;
                    sb.append(current);
                } else if (current == '}') {
                    braceCount--;
                    sb.append(current);
                } else if (current == '.') {
                    if (braceCount > 0) {
                        sb.append(current);
                    } else {
                        break;
                    }
                } else {
                    sb.append(current);
                }
            }
            String node = sb.toString();
            nodes.add(node);
            path = path.substring(node.length());
            // account for leading dot edge-case
            if (StringUtils.isNotEmpty(path) && path.charAt(0) == '.') {
                path = path.substring(1);
            }
        } while (StringUtils.isNotEmpty(path));
        return nodes;
    }

}
