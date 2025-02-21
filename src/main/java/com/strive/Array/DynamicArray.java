package com.strive.Array;

import java.util.Arrays;
import java.util.Iterator;
import java.util.function.Consumer;
import java.util.stream.IntStream;

//todo:动态数组
public class DynamicArray implements Iterable<Integer>{
    public int size = 0; //todo:逻辑大小
    public int capacity = 8; //todo:容量
    private int[] array = new int[capacity]; //todo:开始为空数组

    public void addLast(int element){
        /*array[size] = element;
        size++;*/
        add(size,element);
    }

    public void add(int index,int element){
        checkAndGrow();

        //todo:添加逻辑
        if(index >= 0 && index < size) {
            System.arraycopy(array, index,
                    array, index + 1, size - index);
        }
        array[index] = element;
        size++;
    }

    private void checkAndGrow() {
        //todo:容量检查
        if(size == capacity){
            //todo:需要进行扩容  java 中 用1.5倍
            capacity += capacity >> 1;
            int[] newArray = new int[capacity];
            System.arraycopy(array,0,
                    newArray,0,size);
            array = newArray;
        }
    }

    public int remove(int index){
        int removed = array[index];
        if(index < size - 1) {
            System.arraycopy(array, index + 1,
                    array, index, size - index - 1);
        }
        size--;
        return removed;
    }

    public int get(int index){
        return array[index];
    }

    //todo:遍历方法1 consumer
    public void foreach(Consumer<Integer> consumer){
        for (int i = 0; i < size; i++) {
            //System.out.println(array[i]);
            consumer.accept(array[i]);
        }
    }

    //todo:遍历方法2 迭代器遍历
    @Override
    public Iterator<Integer> iterator() {
        return new Iterator<Integer>(){
            int i = 0;
            @Override
            public boolean hasNext() { //todo:有没有下一个元素
                return i < size;
            }

            @Override
            public Integer next() {   //todo:返回当前元素，并移动到下一个元素
                return array[i++];
            }
        };
    }

    //todo:遍历方法3
    public IntStream stream(){
        return IntStream.of(Arrays.copyOfRange(array,0,size));
    }
}
