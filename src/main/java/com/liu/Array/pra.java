package com.liu.Array;

import java.util.Arrays;

public class pra {
    public static int[] transform(int[] array){
        //数组变为原来的2倍
        int tmpArr[] = new int[array.length];

        for (int i = 0; i < array.length; i++) {
            tmpArr[i] = array[i] * 2;
        }

        return tmpArr;
    }
    public static void func1(int[] array){
        //奇数在偶数之前排列
        int i = 0;
        int j =array.length - 1;
        while(i< j ){
           while(i < j && array[i] % 2 != 0){
               i++;
           }
           while(i < j && array[j] % 2 == 0){
                j--;
           }
           int tmp = array[i];
           array[i] = array[j];
           array[j] = tmp;
        }
    }
    public static int[] func2(int[] array,int target){
        //返回两数之和
        int[] ret = new int[2];
        for (int i = 0; i < array.length; i++) {
            for (int j = i + 1; j <array.length ; j++) {
                if(array[i] + array[j] == target){
                    ret[0] = i;
                    ret[1] = j;
                    return ret;
                }
            }
        }
        return ret;
    }
    public static int func3(int[] array){
        int ret = array[0];
        for (int i = 0; i < array.length; i++) {
            ret = ret ^ array[i];
        }
        return ret;
    }
    public int majorityElement(int[] array) {
        //Leetcode 169题 多数元素
        int ret = array[0];
        int count = 0;
        for (int i = 0; i < array.length; i++) {
            if (array[i] == ret) {
                count++;
            } else {
                count--;
            }
            if (count == 0) {
                ret = array[i + 1];
            }
        }
        return ret;
    }
    public static boolean func4(int[] array){
        int count = 0;
        for (int i = 0; i < array.length; i++) {
            if(array[i] % 2 != 0){
                count++;
                if(count == 3){
                    return true;
                }
            }else{
                count = 0;
            }
        }
        return false;
    }
    public static void main(String[] args) {
        int[] array = {1,2,3,4,5,6};
        int[] ret = transform(array);
        System.out.println(Arrays.toString(array));
        System.out.println(Arrays.toString(ret));
        func1(array);
        System.out.println(Arrays.toString(array));
        func3(array);
        System.out.println(Arrays.toString(array));
    }
}
