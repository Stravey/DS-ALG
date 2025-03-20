package com.strive.Graph;

import java.util.Objects;

public class Node {
    //坐标的x和y
    private int x;
    private int y;

    private String value;
    private double fValue = 0;
    private double gValue = 0;
    private double hValue = 0;
    private boolean reachable;
    private Node parentNode;

    public Node() {

    }

    public Node(int x,int y,String value,boolean reachable) {
        this.x = x;
        this.y = y;
        this.value = value;
        this.reachable = reachable;
    }

    public boolean isObstacle() {
        return "*".equals(value);
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public Node getParentNode() {
        return parentNode;
    }

    public void setParentNode(Node parentNode) {
        this.parentNode = parentNode;
    }

    public boolean isReachable() {
        return reachable;
    }

    public void setReachable(boolean reachable) {
        this.reachable = reachable;
    }

    public double getgValue() {
        return gValue;
    }

    public void setgValue(double gValue) {
        this.gValue = gValue;
    }

    public double gethValue() {
        return hValue;
    }

    public void sethValue(double hValue) {
        this.hValue = hValue;
    }

    public double getfValue() {
        return fValue;
    }

    public void setfValue(double fValue) {
        this.fValue = fValue;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Node node = (Node) o;
        return x == node.x && y == node.y && Double.compare(fValue, node.fValue) == 0 && Double.compare(gValue, node.gValue) == 0 && Double.compare(hValue, node.hValue) == 0 && reachable == node.reachable && Objects.equals(value, node.value) && Objects.equals(parentNode, node.parentNode);
    }

}
