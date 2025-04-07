package com.se.string;

import org.junit.Test;

@SuppressWarnings("all")
public class Practice {
    @Test
    public void test() {
        String s = "ababacdefba";
        System.out.println("字符串的长度:" + s.length());
        System.out.println("第一个字符:" + s.charAt(0));
        System.out.println("c第一次出现的位置:" + s.indexOf('c'));
        System.out.println("c最后一次出现的位置:" + s.lastIndexOf('c'));
        System.out.println("子字符串ab的第一次出现位置:" + s.indexOf("ab"));
        System.out.println("子字符串ab的最后一次出现位置:" + s.lastIndexOf('b'));
    }

    @Test
    public void test_01() {
        String str = "abcd";
        System.out.println("将字符串转为字符数组：");
        char[] chars = str.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            System.out.println(chars[i]);
        }

        String str2 = "adasdadanddmamx";
        // 全大写
        System.out.println(str2.toUpperCase());
        // 全小写
        System.out.println(str2.toLowerCase());

        String.valueOf(20); // int数字转化为String
        System.out.println("将数字转化为字符串：");
    }

    @Test
    public void test_02() {
        String s1 = "com.baidu";
        System.out.println("baidu替换itliu:" + s1.replace("com.baidu", "itliu"));

        String s2 = "  *  liu    y i  r ui *  ";
        // trim方法将字符串首尾的空格移除
        System.out.println(s2.trim());

        System.out.println(s2.replace(" ",""));
    }

}
