package com.se.localdate;

import org.junit.Test;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@SuppressWarnings("all")
public class Demo {
    @Test
    public void test_01() {
        LocalDate date = LocalDate.of(2019, 1, 1);
        LocalDate now = LocalDate.now();
        // 现在
        System.out.println("now: " + now);
        // 给定的日期时间
        System.out.println("date: " + date);
    }

    @Test
    public void test_02() {
        LocalDate now = LocalDate.now();
        System.out.println("year: " + now.getYear());
        System.out.println("month: " + now.getMonthValue());
        System.out.println("day: " + now.getDayOfMonth());
        String nowDate = now.format(DateTimeFormatter.ofPattern("yyyy年MM月dd日"));
        System.out.println("nowDate: " + nowDate);
    }

    @Test
    public void test_03() {
        LocalDate now = LocalDate.now();
        LocalDate of = LocalDate.of(2019, 1, 1);

        System.out.println(of.isBefore(now));
        System.out.println(of.isAfter(now));
        System.out.println(of.isEqual(now));

        System.out.println(of.isLeapYear());
        System.out.println(now.isLeapYear());

        String date = "2025-01-01";
        System.out.println(LocalDate.parse(date));

        System.out.println(now.plusYears(1));

        System.out.println(now.minusDays(10));

        System.out.println(now.withYear(2026));
    }
}


















