package com.se.API.packet;

import org.junit.Test;

@SuppressWarnings("all")
public class Demo {
    @Test
    public void test_01() {
        int a = 10;
        // 装箱操作
        Integer b = a;
        System.out.println(b);
        System.out.println(a + b);

        // 拆箱操作:包装类型转换成基本类型
        int c = b;
        System.out.println(c);

        double dou = 10.10;
        Double d = dou;
        System.out.println(dou);
        System.out.println(d);
        double e = d;
        System.out.println(e);
    }

    @Test
    public void test_02() {
        int a = 10;
        Integer b = a;
        System.out.println("Object类中常见方法的访问：");
        // 将对应基本数据类型的值作为字符串的字面量进行toString转换
        System.out.println(b.toString());
        // 将当前的基本数据类型返回
        System.out.println(b.hashCode());
        // 比较两个对象是否相同 ==
        System.out.println(b.equals(10));
    }

    /**
     * Integer中的方法
     */
    @Test
    public void test_03() {
        // jdk9之后不建议使用
        Integer in = new Integer(10);
        Integer b = in.intValue() + 10;
        System.out.println(b);

        System.out.println(Integer.valueOf(15));

        int par = Integer.parseInt("-123") + 23;
        System.out.println(par);
    }
}
