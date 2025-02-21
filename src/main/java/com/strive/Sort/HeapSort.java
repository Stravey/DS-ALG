package com.strive.Sort;

import java.util.Arrays;

//todo 堆排序 二叉树大顶堆
public class HeapSort {
    public static void sort(int[] a){
        heapify(a,a.length);
        for (int right = a.length - 1; right > 0 ; right--) {
            swap(a,0,right);
            down(a,0,right);
        }
    }
    //todo 建堆
    private static void heapify(int[] a,int size){
        for (int i = size / 2 - 1; i >= 0 ; i--) {
            down(a,i,size);
        }
    }
    //todo 下潜 非递归实现
    private static void down(int[] a,int parent,int size){
        while (true) {
            int left = parent * 2 + 1;
            int right = parent * 2 + 2;
            int max = parent;
            if (left < size && a[left] > a[max]) {
                max = left;
            }
            if (right < size && a[right] > a[max]) {
                max = right;
            }
            if (max == parent){
                break;
            }
            //todo:找到了更大的孩子
            swap(a,max,parent);
            parent = max;
        }
    }
    //todo 交换
    private static void swap(int[] a,int i,int j){
        int t = a[i];
        a[i] = a[j];
        a[j] = t;
    }

    public static void main(String[] args) {
        int[] a = {7,3,6,2,9,4,1,0};
        System.out.println(Arrays.toString(a));
        sort(a);
        System.out.println(Arrays.toString(a));
    }
}
