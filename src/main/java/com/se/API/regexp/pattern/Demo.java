package com.se.API.regexp.pattern;

import org.junit.Test;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

@SuppressWarnings("all")
public class Demo {
    @Test
    public void test_01() {
        // 第一个斜杠表示转义符
        // 第二个表示斜杠本身
        Pattern p = Pattern.compile("\\d+"); // 匹配一次或多次数字
        String s = "我的QQ:815449347我的电话:18158719160我的邮箱:daxnakwead@qq.com";
        String[] str = p.split(s);
        System.out.println("split方法后的长度: " + str.length);
        System.out.println("-----将指定内容的字符串分割后的内容： -----");
        for (int i = 0; i < str.length; i++) {
            System.out.println(str[i]);
        }
    }
    @Test
    public void test_02() {
        // 判断字符串是否匹配正则表达式
        System.out.println("-----matcher方法-----");
        System.out.println(Pattern.matches("\\d+","123"));
        System.out.println(Pattern.matches("\\d+","haud123da1d"));

        Pattern p = Pattern.compile("\\d+");
        Matcher matcher = p.matcher("22bb33");
        // 反推 已知结果反推正则表达式内容
        System.out.println(matcher.pattern());

    }
}
