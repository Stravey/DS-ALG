package com.se.time.instant;

import org.junit.Test;

import java.time.Instant;

@SuppressWarnings("all")
public class Demo {
    @Test
    public void test() {
        Instant instant = Instant.now();
        System.out.println("now: " + instant);

        Instant instant1 = Instant.ofEpochMilli(1000 * 60 * 60 * 24);
        System.out.println("now: " + instant1);

        Instant instant2 = Instant.ofEpochMilli(60 * 60 * 24);
        System.out.println("now: " + instant2);

        Instant is = Instant.parse(Instant.now().toString());
        System.out.println("now: " + is);
        System.out.println(is.getEpochSecond());
        System.out.println(is.getNano());

        System.out.println(Instant.from(instant));
    }
}
