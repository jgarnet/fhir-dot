package org.fhirdot.utils;

import org.apache.commons.lang3.StringUtils;

public class ConditionBuilder {
    private final String conditionsString;
    private final StringBuilder currentNode;
    private Condition rootCondition;
    private Condition currentCondition;

    public ConditionBuilder(String conditionsString) {
        this.conditionsString = conditionsString;
        this.currentNode = new StringBuilder();
    }

    public Condition build() {
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
        return rootCondition;
    }

    private void addCondition(String operator) {
        Condition newCondition = new Condition()
                .setOperator(operator)
                .setOperation(this.currentNode.toString());
        if (this.currentCondition == null) {
            this.rootCondition = newCondition;
        } else {
            this.currentCondition.setChild(newCondition);
        }
        this.currentCondition = newCondition;
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
