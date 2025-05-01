package com.se.API.liu.Generic;

import java.io.Serializable;

public class Interval<T extends Comparable & Serializable> implements Serializable {
    private T lower;
    private T upper;

    public Interval(T first, T second) {
        if(first.compareTo(second) <= 0) {
            lower = first;
            upper = second;
        }else{
            lower = second;
            upper = first;
        }
    }

    public T getLower() {
        return lower;
    }

    public void setLower(T lower) {
        this.lower = lower;
    }

    public T getUpper() {
        return upper;
    }

    public void setUpper(T upper) {
        this.upper = upper;
    }
}
