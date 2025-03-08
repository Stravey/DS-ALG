package com.liu.Array;

import java.util.Arrays;

public class reversal {

    public static void reverse(int[] array) {
        int left = 0;
        int right = array.length - 1;
        while (left < right) {
            int tmp = array[left];
            array[left] = array[right];
            array[right] = tmp;
            left++;
            right--;
        }
    }

    public static void main(String[] args) {
        int[] array = {1, 3, 5, 6, 91, 11, 22, 44, 88, 18, 29, 17, 14};
        reverse(array);
        System.out.println(Arrays.toString(array));
        int[] array2 = array;
        boolean flg = Arrays.equals(array,array2);
        System.out.println(flg);

        int[] array3 = new int[10];
        Arrays.fill(array3,-1);
        System.out.println(Arrays.toString(array3));
    }
}
