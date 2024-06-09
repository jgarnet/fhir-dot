package org.fhirdot.parsers;

import java.util.List;

public interface NodeParser {
    List<String> parse(String path);
}
