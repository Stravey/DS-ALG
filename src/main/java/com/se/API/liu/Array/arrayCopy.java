package com.se.API.liu.Array;

import java.util.Arrays;

public class arrayCopy {
    public static void main(String[] args) {
        int[] array = {1,3,5,7,9,11,88,99};
        int[] array2 = array.clone();//产生一个副本
        System.out.println(Arrays.toString(array2));
        //Object
        array2[0] = 100;
        System.out.println(Arrays.toString(array));
        System.out.println(Arrays.toString(array2));
    }
    public static void main2(String[] args) {
        int[] array = {1,3,5,7,9,11,88,99};
        int[] copy = new int[array.length];
        System.arraycopy(array,0,copy,2,array.length - 2);//Java中的范围为左闭右开区间
        System.out.println(Arrays.toString(array));
        System.out.println(Arrays.toString(copy));
    }
    public static void main1(String[] args) {
        int[] array = {1,3,5,7,9,11,88,99};
        //int[] array2 = new int[array.length];
        //int[] array2 = Arrays.copyOf(array,array.length);
        int[] array2 = Arrays.copyOf(array,2 * array.length);//实际开发中用的最多
       /* for (int i = 0; i < array.length; i++) {
            array2[i] = array[i];
        }
        System.out.println(Arrays.toString(array));*/
        System.out.println(Arrays.toString(array2));
        System.out.println(Arrays.toString(array2));
    }
}
