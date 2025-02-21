package com.strive.LinkedList;

import java.util.Iterator;
import java.util.function.Consumer;

//todo:单向链表(带哨兵)
public class SinglyLinkedList implements Iterable<Integer>{
    //todo:带哨兵
    private Node head = new Node(666,null); //todo:头指针

    @Override
    public Iterator<Integer> iterator() {
        return new Iterator<Integer>() {
            Node p = head;
            @Override
            public boolean hasNext() {  //todo:是否有下一个元素
                return p != null;
            }

            @Override
            public Integer next() {  //todo:返回当前值，并指向下一个元素
                int v = p.value;
                p = p.next;
                return v;
            }
        };
    }

    //todo:节点类
    private static class Node{
        int value; //todo:值
        Node next; //todo:下一个节点指针

        public Node(int value, Node next) {
            this.value = value;
            this.next = next;
        }
    }

    public void addFirst(int value){
        //todo:链表为空
        //head = new Node(value,null);
        //todo:链表非空
        //head = new Node(value,head);
        insert(0,value);
    }

    public void loop1(Consumer<Integer> consumer){
        Node p = head;
        while(p != null){
            consumer.accept(p.value);
            p = p.next;
        }
    }

    public void loop2(Consumer<Integer> consumer){
        for(Node p = head;p != null;p = p.next){
            consumer.accept(p.value);
        }
    }

    //todo:递归遍历
    public void loop3(){
        recursion(head);
    }
    public void recursion(Node curr){
        if(curr == null){
            return;
        }
        System.out.println(curr.value);
        recursion(curr.next);
    }

    private Node findLast(){
        /*  if(head == null){
            return null;
        }*/
        Node p;
        for(p = head;p.next != null;p = p.next){

        }
        return p;
    }

    public void addLast(int value){
        Node last = findLast();
        assert last != null;
        last.next = new Node(value,null);
    }

    public void test(){
        int i =0;
        for(Node p = head;p != null;p = p.next,i++){
            System.out.println(p.value + "索引是：" + i);
        }
    }

    private Node findNode(int index){
        int i = -1;
        for(Node p = head;p != null;p = p.next,i++){
            if(i == index){
                return p;
            }
        }
        return null;
    }

    public int get(int index){
        Node node = findNode(index);
        if(node == null){
            throw new IllegalArgumentException(
                    String.format("index[%d] 不合法%n",index));
        }
        return node.value;
    }

    public void insert(int index,int value){
        if(index == 0){
            addFirst(value);
            return;
        }
        Node prev = findNode(index - 1);
        if(prev == null){
            throw new IllegalArgumentException(
                    String.format("index[%d] 不合法%n",index));
        }
        prev.next = new Node(value,prev.next);
    }

    public void removeFirst(){
        if(head == null){
            throw new IllegalArgumentException(
                    String.format("index[%d] 不合法%n"));
        }
        head = head.next;
    }

    public void remove(int index){
        Node prev = findNode(index - 1);  //todo:上一个节点
        if(prev == null){
            throw new IllegalArgumentException(
                    String.format("index[%d] 不合法%n",index));
        }
        Node removed = prev.next;  //todo:被删除的节点
        if(removed == null){
            throw new IllegalArgumentException(
                    String.format("index[%d] 不合法%n",index));
        }
        prev.next = removed.next;
    }
}
