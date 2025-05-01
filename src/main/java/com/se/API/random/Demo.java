package com.se.API.random;

import org.junit.Test;

import java.util.Random;

@SuppressWarnings("all")
public class Demo {
    @Test
    public void test_01() {
        Random random = new Random();
        for(int i = 0; i < 10; i++) {
            System.out.println(random.nextInt(100));
        }
    }

    @Test
    public void test_02() {
        Random random = new Random(13);
        for(int i = 0; i < 10; i++) {
            System.out.println(random.nextInt(100));
        }
    }

    @Test
    public void test_03() {
        Random random = new Random();
        for(int i = 0; i < 5; i++) {
            System.out.println(random.nextInt(100));
        }
        for (int i = 0; i < 5; i++) {
            System.out.println(random.nextFloat(100));
        }
        for (int i = 0; i < 5; i++) {
            System.out.println(random.nextDouble(100));
        }
    }
}
