package com.liu.BasicStructure;

import java.math.BigInteger;

/**
 * This is the first sample for System.out.print().
 */
//在java中注释有三种方式
public class Sample {

    /**
     * Java中有一个可以表示任意精度的算术包，通常被称为大数（BigNumber），它是一个Java对象
     */
    public static void main(String[] args) {
        System.out.println("We will not use 'Hello World'");
        BigInteger i = new BigInteger("100000000000000000214124123123");
        System.out.println(i);
        func();
        function();
    }
    /**
     * Java当中有8种基本数据类型，4种整型、2种浮点类型，1种字符类型char和1种用于真值表示的boolean类型
     * Java没有任何的无符号数据类型
     * Java对跨平台开发又非常的优势 C和C++中不同平台的数据类型所占的大小不同
     */
    public static void func()
    {
        int a = 10; //4字节
        short b = 20; //2字节
        long c = 30; //8字节
        byte d = 40; //1字节
        System.out.println(a + b + c + d);
    }

    /**
     * Java当中的浮点类型
     */
    public static void function() {
        float f = 3.14f; //float数值有一个后缀F或f
        double d = 3.14; //double默认无f，也可在其后加入D或d
        System.out.println(f);
        System.out.println(d);
        //数值计算中若不允许有任何误差需使用BigDecimal类
    }

    /**
     * Java当中的char类型
     */
    public static void function2() {
        char c = 'a';
        System.out.println(c);
    }

}
