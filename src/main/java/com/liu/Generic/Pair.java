package com.liu.Generic;

@SuppressWarnings("all")

public class Pair<T extends Comparable> {
    private Object first;
    private Object second;

    public Pair(){
    }
    public Pair(Object first, Object second) {
        this.first = first;
        this.second = second;
    }
    public Object getFirst() {
        return first;
    }
    public void setFirst(Object first) {
        this.first = first;
    }
    public Object getSecond() {
        return second;
    }
    public void setSecond(Object second) {
        this.second = second;
    }
}
