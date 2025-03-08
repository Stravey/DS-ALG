package com.liu.BasicStructure;

import org.junit.Test;

import java.io.IOException;
import java.math.BigInteger;
import java.nio.charset.StandardCharsets;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Sample04 implements demo{

    public static void main(String[] args) throws IOException {
        Sample04 demo = new Sample04();
        //demo.a();
        demo.b();
        //demo.c();
    }
    /**
     * 字符串
     * Java当中可以使用 + 拼接字符串
     * substring方法
     * 原始字符串在堆中分配 java有垃圾回收机制 对字符串重新赋值不会产生内存泄漏
     * equals方法
     */
    @Override
    @Test
    public void a() {
        //
        String e = "123";
        String greeting = "Hello";
        System.out.println(e + " " + greeting);

        //substring方法可以从一个较大的字符串提取出一个子串
        //substring方法的第一个参数是起始位置，第二个参数是不想复制的第一个位置
        String s = greeting.substring(0, 2);
        System.out.println(s);

        //equals方法可以检测两个字符串是否相等
        System.out.println("Hello".equals(greeting));
        System.out.println("Hello".equals(e));
        //要想检测两个字符串相等，而不区分大小写可以使用equalsIgnoreCase方法
        System.out.println("Hello".equalsIgnoreCase("hello"));
        //java当中的compareTo和C中的strcmp函数是完全类似的
        System.out.println("Hello".compareTo("Hello"));

        //java字符串由char值序列组成
        //char数据类型是一个采用UTF-16编码表示Unicode码点的代码单元
        //length方法将返回采用UTF-16编码表示给定字符串所需要的代码单元数量
        int n = greeting.length();
        System.out.println(n);
        //charAt方法可以返回位置n的代码单元
        System.out.println(greeting.charAt(2));
        //java9中 只包含单字节代码单元的字符串使用byte数组实现
        //toLowerCase方法 将大写改写为小写
        System.out.println(greeting.toLowerCase());
        //toUpperCase方法 将小写改写为大写
        System.out.println(greeting.toUpperCase());
        //replace方法 将新字符串代替旧字符串
        //CharSequence形参，直接可传入String的实参，因为所有的字符串都实现这个接口CharSequence
        String newString = "World";
        System.out.println(greeting.replace(greeting,newString));
        System.out.println(newString.repeat(3));

    }

    /**
     * Java中没有提供运算符重载的功能
     */
    @Override
    @Test
    public void b() throws IOException {
        /*BigInteger a = BigInteger.valueOf(100);
        System.out.println(a);
        Scanner in = new Scanner(System.in);
        System.out.print("你想写多少数字呢？");
        int k = in.nextInt();
        System.out.print("你写的最大的数字是多少？");
        int n = in.nextInt();
        BigInteger lotteryOdds = BigInteger.valueOf(1);
        for(int i = 1;i <= k;i++) {
            lotteryOdds = lotteryOdds.multiply(BigInteger.valueOf(n - i + 1)).divide(BigInteger.valueOf(i));
        }
        System.out.println(lotteryOdds);*/

        //add、subtract、multiply、divide 加减乘除方法
        BigInteger x = BigInteger.valueOf(1412448146);
        BigInteger y = BigInteger.valueOf(214113);
        //加法
        System.out.println(x.add(y));
        //减法
        System.out.println(x.subtract(y));
        //乘法
        System.out.println(x.multiply(y));
        //除法
        System.out.println(x.divide(y));



    }

    /**
     * 数组
     */
    @Override
    @Test
    public void c() {
        var a = new int[100];
        for(int i = 0; i < a.length; i++){
            a[i] = i;
        }
        //普通for循环
        /*for (int i = 0; i < a.length; i++) {
            a[i] = i;
            System.out.println(a[i]);
        }*/
        //增强for循环 可以不用管下标
        for (int i : a) {
            a[i] = i;
            //System.out.println(a[i]);
        }
        //还可以使用Arrays.toString方法 输出为字符串
        System.out.println(Arrays.toString(a));

        //java中允许将一个数组变量拷贝到另一个数组变量 Arrays.copyOf方法
        int[] b = {2,4,6,8,10};
        int[] copy = Arrays.copyOf(b,b.length);
        System.out.println(Arrays.toString(copy));

        int[] c = {12,42,64,10,90,26,33,85};
        //改进后的快速排序算法 详见源码DualPivotQuicksort.java
        Arrays.sort(c);
        for(int i = 0;i < c.length;i++){
            System.out.print(c[i] + " ");
        }

    }

    @Override
    @Test
    public void d() {

    }
}

