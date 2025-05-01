package com.se.API.liu.BasicStructure;

public class Sample03 {

    public static void main(String[] args) {
        apple();
        pear();
    }

    /**
     * 算术运算符 *= /= ^ -=
     */
    public static void apple() {
        int a = 10;
        a *= 10;
        System.out.println(a);
    }

    /**
     * 数学函数与常量
     */
    public static void pear() {
        double x = 4;
        //平方根运算
        double y = Math.sqrt(x);
        System.out.println(y);
        //正弦函数
        double z = Math.sin(Math.toRadians(x));
        System.out.println(z);
        //余弦函数
        double m = Math.cos(Math.toRadians(x));
        System.out.println(m);
        double n = Math.tan(Math.toRadians(x));
        System.out.println(n);
        //幂运算
        double b = Math.pow(x, 2);
        System.out.println(b);
    }

}
