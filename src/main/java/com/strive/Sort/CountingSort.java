package com.strive.Sort;

import java.util.Arrays;

//todo 计数排序
public class CountingSort {

    private static void sort(int[] a){
        int max = a[0];
        int min = a[0];
        for (int i = 1; i < a.length ; i++) {
            if(a[i] > max){
                max = a[i];
            }
        }
        int[] count = new int[max + 1];

        for (int v : a){
            count[v]++;
        }
        //System.out.println(Arrays.toString(count));
        int k = 0;
        for (int i = 0; i < count.length; i++) {
            while(count[i] > 0){
                a[k++] = i;
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
