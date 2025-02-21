package com.strive.Sort;

import com.strive.Array.DynamicArray;

import java.util.Arrays;

//todo 桶排序
@SuppressWarnings("all")
public class BucketSort {

    /*
       0
       1     18
       2     20 25 28
       3     31
       4
       5
       6     66 67
       7
       8
       9
     */

    private static void sort(int[] ages){
        //1.准备桶
        DynamicArray[] buckets = new DynamicArray[10];
        for (int i = 0; i < buckets.length; i++) {
            buckets[i] = new DynamicArray();
        }
        //2.放入年龄数据
        for(int age : ages){
            buckets[age / 10].addLast(age);
        }
        for (DynamicArray bucket : buckets) {
            int k = 0;
            //3.排序桶内元素
            int[] array = bucket.array();
            InsertSort.sort(array);
            System.out.println(Arrays.toString(array));
            for(int v : ages){
                ages[k++] = v;
            }
        }
    }

    public static void main(String[] args) {
        int[] a = {20,18,28,66,25,31,67,30};  //todo 假设人的年龄 1~99
        System.out.println(Arrays.toString(a));
        sort(a);
        System.out.println(Arrays.toString(a));
    }

}
