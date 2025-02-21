package com.strive.Sort;

import java.util.Arrays;
import java.util.concurrent.ThreadLocalRandom;

//todo 双边快速排序
@SuppressWarnings("all")
public class QuickSortHoare {
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

    private static int partition(int[] a, int left, int right) {
        int index = ThreadLocalRandom.current().nextInt(right - left + 1) + left;
        swap(a,index,left);
        int pv = a[left]; //基准点元素的值
        int i = left;
        int j = right;
        while (i < j) {
            //1.i从左向右 找比基准点大的
            while (i < j && a[j] > pv) {
                j--;
            }
            //2.j从右向左 找比基准点小的
            while (i < j && a[i] <= pv) {
                i++;
            }
            //3.交换位置
            swap(a,i,j);
        }
        swap(a,left,i);
        return i;
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
