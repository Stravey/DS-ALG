package com.strive.Sort;

import com.liu.www.DynamicArray;

import java.util.Arrays;

//todo 桶排序 改进版
@SuppressWarnings("all")
public class BucketSortGeneric {
    private static void sort(int[] a,int range){
        int max = a[0];
        int min = a[0];
        for (int i = 1; i < a.length ; i++) {
            if(a[i] > max){
                max = a[i];
            }
            if(a[i] < min){
                min = a[i];
            }
        }
        //1.准备桶
        DynamicArray[] buckets = new DynamicArray[(max - min) / range + 1];
        for (int i = 0; i < buckets.length; i++) {
            buckets[i] = new DynamicArray();
        }
        //2.放入年龄数据
        for(int age : a){
            buckets[(age - min) / range].addLast(age);

        }
        for (DynamicArray bucket : buckets) {
            int k = 0;
            //3.排序桶内元素
            int[] array = bucket.array();
            InsertSort.sort(array);
            System.out.println(Arrays.toString(array));
            for(int v : a){
                a[k++] = v;
            }
        }
    }

    public static void main(String[] args) {
        int[] a = {0,2,4,3,5,6,1,7,8,9};  //todo 假设人的年龄 1~99
        System.out.println(Arrays.toString(a));
        sort(a,4);
        System.out.println(Arrays.toString(a));
    }
}
