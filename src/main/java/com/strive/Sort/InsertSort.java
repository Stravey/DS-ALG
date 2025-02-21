package com.strive.Sort;

import java.util.Arrays;

//todo 插入排序
@SuppressWarnings("all")
public class InsertSort {
    public static void sort(int[] a){
        for (int low = 1; low < a.length ; low++) {
            int t = a[low];
            int i = low - 1;
            // todo:自右向左找插入位置 已排序区域指针
            while(i >= 0 && a[i] > t){
                a[i + 1] =a[i];
                //todo:空出插入位置
                i--;
            }
            //todo:找到插入位置
            if(i != low - 1){
                a[i + 1] = t;
            }
        }
    }
    /*
    private static void insertion(int[]a,int low){
        if(low == a.length){
            return;
        }
        int t = a[low];
        int i = low - 1;
        // todo:自右向左找插入位置 已排序区域指针已排序区域指针
        while(i >= 0 && a[i] > t){
            a[i + 1] =a[i];
            //todo:空出插入位置
            i--;
        }
        //todo:找到插入位置
        if(i + 1 != low){
            a[i + 1] = t;
        }
        insertion(a,low + 1);
    }
    */

    public static void main(String[] args) {
        int[] a = {7,3,6,2,9,4,1,0};
        System.out.println(Arrays.toString(a));
        sort(a);
        System.out.println(Arrays.toString(a));
    }
}
