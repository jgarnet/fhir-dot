package org.fhirdot.utils;

import org.apache.commons.lang3.StringUtils;

import java.util.ArrayList;
import java.util.Collection;

public class ConditionsParser {
    private final String conditionsString;
    private final StringBuilder currentNode;
    private final ArrayList<Condition> conditions;

    public ConditionsParser(String conditionsString) {
        this.conditionsString = conditionsString;
        this.currentNode = new StringBuilder();
        this.conditions = new ArrayList<>();
    }

    public Collection<Condition> build() {
        if (StringUtils.isEmpty(this.conditionsString)) {
            return null;
        }
        char[] conditionsChars = conditionsString.toCharArray();
        for (int currentIndex = 0; currentIndex < conditionsChars.length; currentIndex++) {
            char currentChar = conditionsChars[currentIndex];
            if (isAnd(currentChar, conditionsChars, currentIndex)) {
                this.addCondition("AND");
                currentIndex++;
            } else if (isOr(currentChar, conditionsChars, currentIndex)) {
                this.addCondition("OR");
                currentIndex++;
            } else {
                this.currentNode.append(currentChar);
            }
        }
        if (!this.currentNode.isEmpty()) {
            this.addCondition(null);
        }
        return this.conditions;
    }

    private void addCondition(String operator) {
        Condition newCondition = new Condition()
                .setOperator(operator)
                .setOperation(this.currentNode.toString());
        this.conditions.add(newCondition);
        this.currentNode.setLength(0);
    }

    private boolean isAnd(char currentChar, char[] allChars, int currentIndex) {
        if (currentChar == '&') {
            return currentIndex + 1 < allChars.length && allChars[currentIndex + 1] == '&';
        }
        return false;
    }

    private boolean isOr(char currentChar, char[] allChars, int currentIndex) {
        if (currentChar == '|') {
            return currentIndex + 1 < allChars.length && allChars[currentIndex + 1] == '|';
        }
        return false;
    }
}
