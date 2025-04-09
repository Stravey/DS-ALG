package com.se.stringbuffer;

import org.junit.Test;

@SuppressWarnings("all")
public class Demo {

    // 字符串添加
    @Test
    public void test_01() {
        StringBuilder sb = new StringBuilder("abc");
        sb.append("d");
        System.out.println(sb);

        // 在某一位置加内容
        sb.insert(1,"123");
        System.out.println(sb);
    }

    @Test
    public void test_02() {
        StringBuilder sb = new StringBuilder("abc");

    }
}
