package com.strive.Array;

import org.junit.Test;
import org.junit.jupiter.api.DisplayName;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.assertIterableEquals;

public class TestDynamicArray {

    @Test
    public void test1(){
        DynamicArray dynamicArray = new DynamicArray();
        dynamicArray.addLast(1);
        dynamicArray.addLast(2);
        dynamicArray.addLast(3);
        dynamicArray.addLast(4);
        dynamicArray.addLast(5);
        dynamicArray.addLast(6);
        dynamicArray.add(2,5);
        for (int i = 0; i < 6; i++) {
            System.out.println(dynamicArray.get(i));
        }
    }

    @Test
    @DisplayName("测试遍历1")
    public void test2(){
        DynamicArray dynamicArray = new DynamicArray();
        dynamicArray.addLast(1);
        dynamicArray.addLast(2);
        dynamicArray.addLast(3);
        dynamicArray.addLast(4);
        dynamicArray.foreach((element)->{
            System.out.println(element);
        });
    }

    @Test
    @DisplayName("测试遍历2")
    public void test3(){
        DynamicArray dynamicArray = new DynamicArray();
        dynamicArray.addLast(1);
        dynamicArray.addLast(2);
        dynamicArray.addLast(3);
        dynamicArray.addLast(4);
        for(Integer element : dynamicArray){
            System.out.println(element);
        }
    }

    @Test
    @DisplayName("测试遍历3")
    public void test4(){
        DynamicArray dynamicArray = new DynamicArray();
        dynamicArray.addLast(1);
        dynamicArray.addLast(2);
        dynamicArray.addLast(3);
        dynamicArray.addLast(4);
        dynamicArray.stream().forEach(element ->{
            System.out.println(element);
        });
    }

    @Test
    @DisplayName("测试删除")
    public void test5(){
        DynamicArray dynamicArray = new DynamicArray();
        dynamicArray.addLast(1);
        dynamicArray.addLast(2);
        dynamicArray.addLast(3);
        dynamicArray.addLast(4);
        dynamicArray.addLast(5);
        int removed = dynamicArray.remove(2);
        assertEquals(3,removed);
        assertIterableEquals(List.of(1,2,4,5),dynamicArray);
        dynamicArray.stream().forEach(element->{
            System.out.println(element);
        });
    }

    @Test
    @DisplayName("测试")
    public void test6(){
        DynamicArray dynamicArray = new DynamicArray();
        dynamicArray.addLast(1);
        dynamicArray.addLast(2);
        dynamicArray.addLast(3);
        dynamicArray.addLast(4);
        dynamicArray.addLast(5);
    }
}
