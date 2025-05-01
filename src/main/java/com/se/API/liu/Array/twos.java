package com.se.API.liu.Array;

import java.util.Arrays;

//二维数组 其实是 特殊的一维数组
public class twos {
    public static void main(String[] args) {
        //不规则的二维数组
        int[][] array = new int[2][];
        array[0] = new int[3];
        array[1] = new int[4];

        for (int i = 0;i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                System.out.print(array[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }
    public static void main3(String[] args) {
        int[][] array = new int[2][3];
        System.out.println(Arrays.deepToString(array));
    }
    public static void main2(String[] args) {
        int[][] array = new int[2][3];
        for(int i = 0;i < 2;i++){
            for(int j = 0; j < 3;j++){
                System.out.print(array[i][j]+" ");
            }
            System.out.println();
        }
        System.out.println();
        System.out.println(Arrays.deepToString(array));
    }
    public static void main1(String[] args) {
        int[][] array = new int[2][3];

        int[][] array1 = new int[][]{{1,2,3},{4,5,6}};

        int[][] array2 = {{1,2,3},{4,5,6}};

    }
}
