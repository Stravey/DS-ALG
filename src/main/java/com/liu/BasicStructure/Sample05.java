package com.liu.BasicStructure;

public class Sample05 {
    public static void main(String[] args) {

    }

    static class Tree {
        int data;
        Tree left;
        Tree right;
        Tree() {

        }
        Tree(int data) {
            this.data = data;
        }
        Tree(int data, Tree left, Tree right) {
            this.data = data;
            this.left = left;
            this.right = right;
        }
    }
}
