package com.se.stringbuilder;

import org.junit.Test;

@SuppressWarnings("all")
public class Demo {
    @Test
    public void test_01() {
        StringBuilder sb = new StringBuilder("abc");
        sb.append('d');
        sb.append('e');
        System.out.println(sb);
    }

    // 性能分析
    // 性能分析String
    @Test
    public void test_02() {
        String str = " ";
        // 记录开始时间
        long start = System.currentTimeMillis();
        for (int i = 0; i < 300000; i++) {
            str += "test";
        }
        // 记录完成时间
        long end = System.currentTimeMillis();
        long elapsed = end - start;
        System.out.println(elapsed);
    }

    // 性能分析StringBuffer
    @Test
    public void test_03() {
        StringBuffer sb = new StringBuffer();
        // 记录开始时间
        long start = System.currentTimeMillis();
        for (int i = 0; i < 300000; i++) {
            sb.append("test");
        }
        // 记录完成时间
        long end = System.currentTimeMillis();
        long elapsed = end - start;
        System.out.println(elapsed);
    }

    // 性能分析StringBuffer
    @Test
    public void test_04() {
        StringBuilder sb = new StringBuilder();
        // 记录开始时间
        long start = System.currentTimeMillis();
        for (int i = 0; i < 300000; i++) {
            sb.append("test");
        }
        // 记录完成时间
        long end = System.currentTimeMillis();
        long elapsed = end - start;
        System.out.println(elapsed);
    }

    @Test
    public void test_05() {
        String str1 = "abc";
        String str2 = "abc";
        System.out.println(str1 == str2);
        System.out.println(str1.equals(str2));

        StringBuffer sb1 = new StringBuffer("abc");
        StringBuffer sb2 = new StringBuffer("abc");
        System.out.println(sb1.equals(sb2)); // false
        System.out.println(sb1 == sb2); // false

        StringBuilder s1 = new StringBuilder("abc");
        StringBuilder s2 = new StringBuilder("abc");
        System.out.println(s1.equals(s2)); // false
        System.out.println(s1 == s2); // false
    }

    @Test
    public void test_06() {
        String str1 = "abc";
        String str2 = "efg";
        String str3 = str1 + str2;

        System.out.println(str3);

        StringBuilder sb1 = new StringBuilder("abc");
        StringBuilder sb2 = new StringBuilder("abc");
        //StringBuilder sb3 = sb1 + sb2; // 报错

        StringBuffer sb4 = new StringBuffer("abc");
        StringBuffer sb5 = new StringBuffer("abc");
        //StringBuffer sb6 = sb4 + sb5; // 报错
        System.out.println(str1 + str2 + str3);
    }
}
