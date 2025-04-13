package com.se.localtime;

import org.junit.Test;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

@SuppressWarnings("all")
public class Demo {
    @Test
    public void test() {
        LocalTime now = LocalTime.now();
        System.out.println(now);

        LocalTime of = LocalTime.of(23, 59, 59);
        System.out.println(of);

        String nowDate = now.format(DateTimeFormatter.ofPattern("HH时mm分ss秒"));
        System.out.println(nowDate);

    }
}
