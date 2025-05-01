package com.se.regexp.matcher;

import org.junit.Test;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * String类结合正则表达式使用
 */
@SuppressWarnings("all")
public class Demo {
    @Test
    public void test_01() {
        Pattern p = Pattern.compile("\\d+");

        Matcher m = p.matcher("22bb33");
        System.out.println("是否匹配上：" + m.matches());
        System.out.println("前面字符串：" + m.lookingAt());
        System.out.println("任意字符串：" + m.find());
        System.out.println("=====================");

        Matcher matcher = p.matcher("2233");
        System.out.println("字符串任意匹配：" +matcher.matches());
        System.out.println("=====================");

        Matcher a = p.matcher("aa223bb");
        System.out.println("字符串匹配：" + a.matches());
        if(a.find()) {
            System.out.println("上一个匹配的起始索引：" + a.start());
        } else {
            System.out.println("没有匹配到内容，无法获取起始索引。");
        }
    }

    /**
     * String类对正则表达式的支持
     */
    @Test
    public void test_02() {
        // replaceAll()方法
        String s1 = "12948y91880hiud1dh19hs9120";
        String now = s1.replaceAll("\\d+","_");
        System.out.println(now);
        // matches()方法
        String s2 = "124124231321131";
        boolean b = s2.matches("\\d+");
        System.out.println(b);
        // split()方法
        String s3 = "hadh123uh2vv2iyg1ho23huh382h32h3s";
        String[] str = s3.split("\\d3+");
        for (int i = 0; i < str.length; i++) {
            System.out.println(str[i]);
        }
    }
}
