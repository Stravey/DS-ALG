package com.liu.Array;

public class average {
    public static double avg(int[] array){
        int sum = 0;
        for(int x:
                array){
            sum += x;
        }
        return sum * 1.0 / array.length;
    }

    public static void main(String[] args) {
        int[] array = {1,3,5,6,91,11,22,44,88,18,29,17,14};
        System.out.println(avg(array));
    }
}
