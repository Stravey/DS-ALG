package com.se.regexp.pattern;

import org.junit.Test;

import java.util.regex.Pattern;

@SuppressWarnings("all")
public class Demo {
    @Test
    public void test() {
        // 第一个斜杠表示转义符
        // 第二个表示斜杠本身
        Pattern.compile("\\d+"); // 匹配一次或多次数字
    }
}
