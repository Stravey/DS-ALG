package com.strive.Tree;

//todo:泛型上限
@SuppressWarnings("all")
public class BST2<T extends Comparable<T>,V> {
    static class BSTNode<T,V> {
        T key;
        V value;
        BSTNode<T,V> left;
        BSTNode<T,V> right;

        public BSTNode(T key) {
            this.key = key;
        }

        public BSTNode(T key, V value) {
            this.key = key;
            this.value = value;
        }

        public BSTNode(T key, V value, BSTNode<T,V> left, BSTNode<T,V> right) {
            this.key = key;
            this.value = value;
            this.left = left;
            this.right = right;
        }
    }

    BSTNode<T,V> root;
    public Object get(T key){
        BSTNode<T,V> p = root;
        while(p != null){
           /*
                -1  key < p.key
                0  key == p.key
                1  key > p.key
           */
          int result = key.compareTo(p.key);
          if(result < 0){
              p = p.left;
          } else if (result > 0 ) {
              p = p.right;
          }else {
              return p.value;
          }
        }
        return null;
    }

}
