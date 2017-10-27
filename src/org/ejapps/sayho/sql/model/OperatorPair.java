package org.ejapps.sayho.sql.model;

public class OperatorPair{
    private String left;
    private String right;

    public OperatorPair(String left, String right) {
        this.left = left;
        this.right = right;
    }

    public String getLeft() {
        return left;
    }

    public void setLeft(String left) {
        this.left = left;
    }

    public String getRight() {
        return right;
    }

    public void setRight(String right) {
        this.right = right;
    }
}