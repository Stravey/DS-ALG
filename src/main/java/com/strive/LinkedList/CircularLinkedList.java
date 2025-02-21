package com.strive.LinkedList;

import java.util.Iterator;

public class CircularLinkedList implements Iterable<Integer>{

    @Override
    public Iterator<Integer> iterator() {
        return new Iterator<Integer>() {
            Node p = sentinel.next;
            @Override
            public boolean hasNext() {
                return p != sentinel;
            }

            @Override
            public Integer next() {
                int value = p.value;
                p = p.next;
                return value;
            }
        };
    }

    private static class Node{
        Node prev;
        int value;
        Node next;

        public Node(Node prev, int value, Node next) {
            this.prev = prev;
            this.value = value;
            this.next = next;
        }
    }
    private final Node sentinel = new Node(null, -1, null);
    public CircularLinkedList(){
        sentinel.prev = sentinel;
        sentinel.next = sentinel;
    }
    public void addFirst(int value){
        Node a = sentinel;
        Node b = sentinel.next;
        Node added = new Node(a,value,b);
        a.next = added;
        b.next = added;
    }
    public void addLast(int value){
       Node a = sentinel.prev;
       Node b = sentinel;
       Node added = new Node(a,value,b);
       a.next = added;
       b.prev = added;
    }
    public void removeFirst(){
        Node removed = sentinel.next;
        assert removed != sentinel;
        Node a = sentinel;
        Node b = removed.next;
        a.next = b;
        b.prev = a;
    }
    public void removeLast(){
        Node removed = sentinel.prev;
        assert removed != sentinel;
        Node a = removed.prev;
        Node b = sentinel;
        a.next = b;
        b.prev = a;
    }
    public void removeByValue(int index){
        Node removed = sentinel.prev;
        if(removed == null){
            return;
        }
        Node a = removed.prev;
        Node b = removed.next;
        a.next = b;
        b.prev = a;
    }
    private Node findByValue(int value){
        Node p = sentinel.next;
        while(p != sentinel){
            if(p.value == value){
                return p;
            }
            p = p.next;
        }
        return null;
    }
}
