package com.strive.Sort;

import java.util.Arrays;

@SuppressWarnings("all")
public class QuickSortHandleDuplicate {
    public static void sort(int[] a){
        quick(a,0,a.length - 1);
    }

    private static void quick(int[] a,int left,int right){
        if(left >= right){
            return;
        }
        int p = partition(a,left,right);
        quick(a,left,p - 1);
        quick(a,p + 1,right);
    }

    /*
       循环内
          i 从 left + 1 开始  从左向右找比基准点大的或相等的
          j 从 right 开始  从右向左找比基准点小的或相等的
          交换 i++ j--

       循环外
          交换 j 和 基准点
     */
    private static int partition(int[] a, int left, int right) {
        int p = a[left];
        int i = left + 1;
        int j = right;
        while(i <= j){
            while(i <= j && a[i] < p){
                i++;
            }
            while(i <= j && a[i] > p){
                j--;
            }
            if(i <= j){
                swap(a,i,j);
                i++;
                j--;
            }
        }
        swap(a,j,left);
        return j;
    }

    private static void swap(int[] a,int i,int j){
        int t = a[i];
        a[i] = a[j];
        a[j] = t;
    }

    public static void main(String[] args) {
        int[] a = {6,5,4,3,2,1};
        System.out.println(Arrays.toString(a));
        sort(a);
        System.out.println(Arrays.toString(a));
    }
}
