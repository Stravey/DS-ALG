package com.liu.BasicStructure;

import static java.lang.Character.*;

public class Sample02 {
    public static void main(String[] args) {
        func();
        //使用 isJavaIdentifierStart 和 isJavaIdentifierPart 方法
        System.out.println(isJavaIdentifierStart('a'));
        System.out.println(isJavaIdentifierPart('a'));
        Ha();
    }

    /**
     * 变量与常量
     * 如果想知道哪些Unicode字符属于Java中的“字母”,需使用Character类中的方法
     * 如：isJavaIdentifierStart和isJavaIdentifierPart方法
     **/
    public static void func() {
        double salary;
        int vacationDays;
        long earthPopulation;
        boolean done;

        //var类型可以局部推断出该变量类型 不需要再对变量进行类型声明
        var a = 10;
        var b = "Hello";
        System.out.println(a);
        System.out.println(b);
    }

    /**
     * Java中使用关键字final表示常量 C++使用const（Java的保留关键字，但未使用） final表示此变量只能被赋值一次 常量名全大写
     * Java中想要一个类中的多个方法可以使用 可以使用static final设置一个类常量
     */
    public static final double CIRCLE = 2.50;
    public static void Ha() {
        final double CM_PER_INCH = 2.54;
        double paperWidth = 8.5;
        double paperHeight = 11;
        System.out.println("Paper Size in centimeters: "
                + paperWidth * CM_PER_INCH + " by " + paperHeight * CM_PER_INCH);
    }
}
