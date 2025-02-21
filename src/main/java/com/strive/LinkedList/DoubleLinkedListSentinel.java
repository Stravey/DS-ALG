package com.strive.LinkedList;

import java.util.Iterator;

public class DoubleLinkedListSentinel implements Iterable<Integer>{
    static class Node{
        Node prev;
        int value;
        Node next;

        public Node(Node prev, int value, Node next) {
            this.prev = prev;
            this.value = value;
            this.next = next;
        }
    }
    private Node head;//todo:头哨兵
    private Node tail;//todo:尾哨兵

    public DoubleLinkedListSentinel(){
        head = new Node(null,666,null);
        tail = new Node(null,888,null);
        head.next = tail;
        tail.prev = head;
    }

    private Node findNode(int index){
        int i = -1;
        for(Node p = head;p != tail;p = p.next,i++){
            if(i == index){
                return p;
            }
        }
        return null;
    }

    public void addFirst(int value){
        insert(0,value);
    }

    public void removeFirst(){
        remove(0);
    }
    public void addLast(int value){
        Node last = tail.prev;
        Node added = new Node(last,value,tail);
        last.next = added;
        tail.prev = added;
    }
    public void removeLast(){
        Node removed = tail.prev;
        if(removed == head){
            return;
        }
        Node prev = removed.prev;
        prev.next = tail;
        tail.prev = prev;
    }
    public void insert(int index,int value){
        Node prev = findNode(index - 1);
        assert prev != null;
        Node next = prev.next;
        Node inserted = new Node(prev,value,next);
        prev.next = inserted;
        next.prev = inserted;
    }
    public void remove(int index){
        Node prev = findNode(index - 1);
        assert prev != null;
        Node removed = prev.next;
        assert removed != tail;
        Node next = removed.next;
        prev.next = next;
        next.prev = prev;
    }

    @Override
    public Iterator<Integer> iterator() {
        return new Iterator<Integer>() {
            Node p = head.next;
            @Override
            public boolean hasNext() {
                return p != tail;
            }

            @Override
            public Integer next() {
                int value = p.value;
                p = p.next;
                return null;
            }
        };
    }
}
