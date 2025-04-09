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
    @Test
    public void test_02() {
        String str = " ";
        // 记录开始时间
        long start = System.currentTimeMillis();
        for (int i = 0; i < 100000; i++) {
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
        for (int i = 0; i < 100000; i++) {
            sb.append("test");
        }
        // 记录完成时间
        long end = System.currentTimeMillis();
        long elapsed = end - start;
        System.out.println(elapsed);
    }
}
