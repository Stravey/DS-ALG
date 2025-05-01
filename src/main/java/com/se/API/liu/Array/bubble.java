package com.se.API.liu.Array;

import java.util.Arrays;

public class bubble {
    public static void bubbleSort(int[] array){
        //i 控制趟数
        for(int i = 0;i < array.length - 1; i++){
            //优化：检查某一趟之后 是否优化了
            boolean flg = false;
            //array.length - 1 - i  优化的是 每一趟比较的次数
            for(int j = 0;j < array.length - 1 - i; j++){
                if(array[j] > array[j + 1]){
                    int tmp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = tmp;
                    flg = true;
                }
            }
            if( !flg ){
                return;
            }
        }
    }
    public static void main(String[] args) {
        int[] array = {1, 3, 5, 6, 91, 11, 22, 44, 88, 18, 29, 17, 14};
        bubbleSort(array);
        System.out.println(Arrays.toString(array));
    }
}
