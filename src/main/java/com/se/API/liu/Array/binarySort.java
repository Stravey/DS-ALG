package com.se.API.liu.Array;

import java.util.Arrays;

public class binarySort {
    public static int binarySearch(int[] array,int key){
        int left = 0;
        int right = array.length - 1;
        while(left <= right){
            int mid = (left + right) >>> 1;
            if(array[mid] < key){
                left = mid + 1;
            }else if(array[mid] > key){
                right = mid - 1;
            }else{
                return mid;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] array = {1,3,5,6,91,11,22,44,88,18,29,17,14};
        Arrays.sort(array);//不是冒泡排序 底层快排
        //降序需要给比较器 目前知识储备不够
        System.out.println(Arrays.toString(array));
        System.out.println(binarySearch(array,18));
        int index = Arrays.binarySearch(array,18);
        System.out.println(index);
    }
}
