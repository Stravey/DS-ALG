package com.liu.BasicStructure;

/**
 * 字符串
 */

public class Sample04 implements demo{

    public static void main(String[] args) {
        Sample04 demo = new Sample04();
        demo.a();
    }

    @Override
    public void a() {
        String e = "123";
        String greeting = "Hello";
        System.out.println(e + " " + greeting);
    }

    @Override
    public void b() {
        char a = '1';
        char b = '9';
        System.out.println(a + b);
    }

    @Override
    public void c() {

    }

    @Override
    public void d() {

    }
}

