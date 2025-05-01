package com.se.API.string;

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

    @Test
    public void test_03() {
        String str = "abdsx";
        String n = "abdsx";
        String m = "abcd";
        // 比较字符串是否相等
        System.out.println(n.equals(m));
        System.out.println(n.equals(str));

        // 连接字符串
        System.out.println(String.join(n, m));
        System.out.println(String.join(n, str));

        // 转换成字符串数组
        char s[] = n.toCharArray();
        char a[] = m.toCharArray();
        System.out.println(s);
        System.out.println(a.toString());
    }

    @Test
    public void test_04() {
        String a = "abcde";
        String b = "abcdefg";
        String c = "bcdefg";
        // 返回最后一次出现相同字符的索引位置
        System.out.println(a.compareTo(b));
        System.out.println(a.compareTo(c));

        // 判空
        String d = " ";
        System.out.println(a.isEmpty());
        System.out.println(d.isEmpty());
        String e = "";
        System.out.println(e.isEmpty());
    }

    @Test
    public void test_05() {
        String a = "abcdefg";
        String b = "abc";
        System.out.println(a.startsWith("abc"));
        System.out.println(a.endsWith("c"));
        System.out.println(b.endsWith("g"));

        System.out.println(a.contains("abc"));
        System.out.println(b.contains("abcd"));
    }

    @Test
    public void test_06() {
        String a = "陕西省-西安市-雁塔区";
        // 雁塔区
        System.out.println(a.substring(8));
        // 西安市
        System.out.println(a.substring(4,7));

        String[] b =  a.split("-");
        System.out.println(b.length);
        for (int i = 0; i < b.length; i++) {
            System.out.println(b[i]);
        }
    }
}





