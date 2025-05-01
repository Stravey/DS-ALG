package com.se.API.stringbuffer;

import org.junit.Test;

// 关于字符串操作 都放在java.lang.*中 不需要导包

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

    // 字符串删除
    @Test
    public void test_02() {
        StringBuffer sb = new StringBuffer("abcdefg");
        // 指定范围删除
        sb.delete(1,5);
        System.out.println(sb);
        sb.delete(2,4);
        System.out.println(sb);
        // 指定位置的字符删除
        sb.deleteCharAt(1);
        System.out.println(sb);

        StringBuffer str = new StringBuffer("abcdefghijklmnopqrstuvwxyz");
        str.delete(1,25);
        System.out.println(str);
    }

    // 字符串修改
    @Test
    public void test_03() {
        StringBuffer sb = new StringBuffer("abce");
        // abce -> abcd
        sb.setCharAt(3,'d');
        System.out.println(sb);

        StringBuffer str = new StringBuffer("11111");
        // 11111 -> abcde
        str.replace(0,5,"abcde");
        System.out.println(str);

        // 字符串反转
        StringBuffer st = new StringBuffer("abcdefghijklmnopqrstuvwxyz");
        st.reverse();
        System.out.println(st);

        // toString方法 用于输出字符串的内容
        StringBuffer s = new StringBuffer("abcd");
        System.out.println(s);
        System.out.println(s.toString());
    }
}
