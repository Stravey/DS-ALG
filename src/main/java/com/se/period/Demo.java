package com.se.period;

import org.junit.Test;

import java.time.LocalDate;
import java.time.Period;

@SuppressWarnings("all")
public class Demo {
    @Test
    public void test() {
        // 生日
        LocalDate birthday = LocalDate.of(2003, 7, 19);
        // 现在的时间
        LocalDate now = LocalDate.now();
        // 计算差值
        Period period = Period.between(birthday, now);
        // 相差年份
        System.out.println(period.getYears());
        // 相差月份
        System.out.println(period.getMonths());
        // 相差天数
        System.out.println(period.getDays());
    }
}
