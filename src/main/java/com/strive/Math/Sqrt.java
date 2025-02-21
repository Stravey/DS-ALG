package com.strive.Math;


//todo 计算x的算术平方根 结果只保留整数部分 小数部分舍去

public class Sqrt {

    public static int mySqrt(int x){
        if(x == 0){
            return 0;
        }
        int a = (int) Math.exp(0.5 * Math.log(x));
        return (long) (a + 1) * (a + 1) <= x ? a + 1 : a;
    }

    public static void main(String[] args) {
        System.out.println(mySqrt(2));
    }

}
