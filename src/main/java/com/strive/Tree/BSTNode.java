package com.strive.Tree;

public class BSTNode {
    int key;
    Object value;
    BSTNode left;
    BSTNode right;

    //todo 带key参数的构造方法
    public BSTNode(int key) {
        this.key = key;
    }

    //todo 带key和value两个参数的构造方法
    public BSTNode(int key, Object value) {
        this.key = key;
        this.value = value;
    }

    //todo 带key value left right四个参数的构造方法
    public BSTNode(int key, Object value, BSTNode left, BSTNode right) {
        this.key = key;
        this.value = value;
        this.left = left;
        this.right = right;
    }
}
