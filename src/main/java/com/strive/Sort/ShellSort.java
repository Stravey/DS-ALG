package com.strive.Sort;

import java.util.Arrays;

//todo 希尔排序
public class ShellSort {
    public static void sort(int[] a){
        //a.length / 2    / 2
        for (int gap = a.length >> 1; gap >= 1 ; gap = gap >> 1) {
            //gap = 4
            for (int low = gap; low < a.length ; low++) {
                int t = a[low];
                int i = low - gap;
                // todo:自右向左找插入位置 已排序区域指针
                while(i >= 0 && a[i] > t){
                    a[i + gap] =a[i];
                    //todo:空出插入位置
                    i -= gap;
                }
                //todo:找到插入位置
                if(i + gap != low){
                    a[i + gap] = t;
                }
            }
        }
    }

    public static void main(String[] args) {
        int[] a = {7,3,6,2,9,4,1,0};
        System.out.println(Arrays.toString(a));
        sort(a);
        System.out.println(Arrays.toString(a));
    }
}
