package com.strive.Sort;

import java.util.Arrays;

//todo 计数排序 改进版
public class CountingSortPositive {
    private static void sort(int[] a){
        int max = a[0];
        int min = a[0];
        for (int i = 1; i < a.length ; i++) {
            if(a[i] > max){
                max = a[i];
            }
        }
        int[] count = new int[max - min + 1];
        for (int v : a){
            count[v - min]++;
        }
        //System.out.println(Arrays.toString(count));
        int k = 0;
        for (int i = 0; i < count.length; i++) {
            // i 代表原始数组元素 count[i] 元素出现次数
            while(count[i] > 0){
                a[k++] = i + min;
                count[i]--;
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
