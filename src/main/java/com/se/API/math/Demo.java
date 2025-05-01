package com.se.API.math;

import org.junit.Test;

@SuppressWarnings("all")
public class Demo {
    @Test
    public void test() {
        System.out.println(Math.abs(-4));
        System.out.println(Math.abs(-0.35));

        System.out.println(Math.ceil(5.3));
        System.out.println(Math.ceil(-5.3));
        System.out.println(Math.ceil(5.9));

        System.out.println(Math.floor(5.9));
        System.out.println(Math.floor(-3.2));

        System.out.println(Math.round(5.9));
        System.out.println(Math.round(1.03));

        System.out.println(Math.max(10,15));
        System.out.println(Math.max(-2,-5));

        System.out.println(Math.min(-1,-10));
        System.out.println(Math.min(8,10));

        System.out.println(Math.sqrt(16));
        System.out.println(Math.sqrt(13));

        System.out.println(Math.pow(2,5));

        System.out.println(Math.sin(Math.PI/2));
        System.out.println(Math.sin(-Math.PI/2));
        System.out.println(Math.sin(Math.PI));

        System.out.println(Math.cos(Math.PI));
        System.out.println(Math.tan(Math.PI/2));
        System.out.println(Math.tan(-Math.PI/2));

        System.out.println(Math.tan(Math.PI));
        System.out.println(Math.tan(-Math.PI));

    }
}
