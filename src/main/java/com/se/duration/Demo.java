package com.se.duration;

import org.junit.Test;

import java.time.Duration;
import java.time.LocalTime;
import java.time.temporal.Temporal;

@SuppressWarnings("all")
public class Demo {
    @Test
    public void test_01() {
        LocalTime now = LocalTime.now();
        LocalTime of = LocalTime.of(22,15,17);
        Duration duration = Duration.between(now,of); // 求两个时间之间的相差值
        // 纳秒
        System.out.println(duration.toNanos());
        // 毫秒
        System.out.println(duration.toMillis());
        // 小时
        System.out.println(duration.toHours());
    }
}
