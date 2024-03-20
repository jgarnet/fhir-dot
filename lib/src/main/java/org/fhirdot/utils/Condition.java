package org.fhirdot.utils;

public class Condition {
    private String operation;
    private String operator;
    private Condition child;

    public String getOperation() {
        return operation;
    }

    public Condition setOperation(String operation) {
        this.operation = operation;
        return this;
    }

    public String getOperator() {
        return operator;
    }

    public Condition setOperator(String operator) {
        this.operator = operator;
        return this;
    }

    public Condition getChild() {
        return child;
    }

    public Condition setChild(Condition child) {
        this.child = child;
        return this;
    }
}
