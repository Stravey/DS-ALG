package com.se.string;

import org.junit.Test;

@SuppressWarnings("all")
public class Demo {
    public static void main(String[] args) {
        // 第一种初始化方法
        String name = "张三";
        name = "李四";
        System.out.println(name);

        String str1 = new String();
        System.out.println("a" + str1 + "b");

        String str2 = new String("abc");
        System.out.println(str2);

        char[] chs = new char[] { 'a', 'b', 'c', 'd', 'e', 'f' };
        String str3 = new String(chs);
        System.out.println(str3);

        byte[] b = new byte[] {65,66,67};
        String str4 = new String(b);
        System.out.println(str4);

    }

}
