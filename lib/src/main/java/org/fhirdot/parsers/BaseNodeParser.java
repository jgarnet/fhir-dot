package org.fhirdot.parsers;

import java.util.ArrayList;
import java.util.List;

public class BaseNodeParser implements NodeParser {
    @Override
    public List<String> parse(String path) {
        List<String> nodes = new ArrayList<>();
        StringBuilder currentNode = new StringBuilder();
        int bracesCount = 0;
        int parenthesesCount = 0;
        for (int i = 0; i < path.length(); i++) {
            char currentChar = path.charAt(i);
            if (currentChar == '.' && bracesCount == 0 && parenthesesCount == 0) {
                nodes.add(currentNode.toString());
                currentNode.setLength(0);
            } else {
                if (currentChar == '{') {
                    bracesCount++;
                } else if (currentChar == '}') {
                    bracesCount--;
                } else if (currentChar == '(') {
                    parenthesesCount++;
                } else if (currentChar == ')') {
                    parenthesesCount--;
                }
                currentNode.append(path.charAt(i));
            }
        }
        if (!currentNode.isEmpty()) {
            nodes.add(currentNode.toString());
        }
        return nodes;
    }
}
