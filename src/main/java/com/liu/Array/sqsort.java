package com.liu.Array;

public class sqsort {
    public static int find(int[] array,int key){
        for (int i = 0; i < array.length; i++) {
            if(array[i] == key){
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] array = {1,3,5,6,91,11,22,44,88,18,29,17,14};
        System.out.println(find(array,88));
    }
}
