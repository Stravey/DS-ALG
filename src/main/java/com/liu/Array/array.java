package com.liu.Array;

import java.util.Arrays;

public class array {
    public static void swap(int[] array){
        int tmp = array[0];
        array[0] = array[1];
        array[1] = tmp;
    }
    //数组对象是在堆上的
    //引用变量目前是在main函数里面的，它属于局部变量，当函数结束就会被回收内存
    public static void main(String[] args) {
        int[] tmp = {1,2};
        System.out.println("交换前: "+tmp[0]+" "+tmp[1]);
        swap(tmp);
        System.out.println("交换后: "+tmp[0]+" "+tmp[1]);
    }
    //对于数组作为参数传递
    public static int[] func3(){
        int[] tmp = {1,2,3,4,5,6,7};
        return tmp;
    }
    public static void main9(String[] args) {
        int[] ret = func3();
        System.out.println(Arrays.toString(ret));
    }
    public static void func1(int[] array){
        array = new int[10];
    }
    public static void func2(int[] array){
        array[0] = 99;
    }
    public static void main8(String[] args) {
        int[] array = {1,2,3,4};
        func1(array);
        System.out.println(Arrays.toString(array));
        func2(array);
        System.out.println(Arrays.toString(array));
    }
    public static void main7(String[] args) {
        int[] array = {1,2,3,4};
        int[] array2 = {4,5,6,7,8};
        array = array2;
        System.out.println(Arrays.toString(array));
        System.out.println(Arrays.toString(array2));
       /* int[] array3 = null;
        System.out.println(array3.length);*/
    }
    public static void main6(String[] args) {
        int[] array = {1,2,3,4};
        System.out.println(Arrays.toString(array));
        int[] array2 = array;
        array[1] = 99;
        System.out.println(Arrays.toString(array));
        System.out.println(Arrays.toString(array2));
    }
    public static void main5(String[] args) {
        int a = 10;
        int b = 20;
        int[] array = {1,2,3,4};
        System.out.println(array[0]);
    }
    public static void main4(String[] args) {
        int[] array = new int[100];
        for (int i = 0; i < array.length; i++) {
            array[i] = i + 1;
        }
        System.out.println(Arrays.toString(array));
    }
    public static void main3(String[] args) {
        int[] array = {1,2,3};
        for (int j : array) {
            System.out.println(j);
        }
        System.out.println();
        //数组当中数据的类型定义的变量 ：数组名  for each 增强for循环
        for (int x: array){
            System.out.println(x);
        }
        System.out.println();
        //Java当中有一个工具，专门用来操作数组 Arrays
        //把数组转换成字符串
        String ret = Arrays.toString(array);
        System.out.println(ret);
       /* System.out.println(array[1]);
        array[1] = 99;
        System.out.println(array[1]);*/
    }
    public static void main2(String[] args) {
        int[] array = {1,2,3};//直接赋值 静态初始化
        int[] array2 = new int[]{1,2,3,4};//动态初始化
        int[] array3 = new int[10];
        System.out.println("====");
        int[] array4;
        array4 = new int[10];
        boolean[] flg = new boolean[10];
        char[] chars = new char[5];
        System.out.println("====");
    }
    public static void main1(String[] args) {
        int a1 = 1;
        int a2 = 2;
        int a3 = 3;
        int[] array = {1,2,3};
        float[] array2 = {1.0f,2.5f};
        int ret = array[1];
        System.out.println(ret);
        int len = array.length;
        System.out.println(len);
    }
}
