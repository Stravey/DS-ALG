package com.se.API.system_runtime;

import org.junit.Test;

import java.io.IOException;

@SuppressWarnings("all")
public class Runtime_Demo {
    @Test
    public void test_01() {
        // 饿汉式
        // Runtime对象
        Runtime runtime = Runtime.getRuntime();
        System.out.println(runtime.availableProcessors());
        System.out.println("Total memory: " + runtime.totalMemory()/1024/1024);
        System.out.println("Max memory: " + runtime.maxMemory()/1024/1024);
        System.out.println("Free memory: " + runtime.freeMemory()/1024/1024);
    }

    @Test
    public void test_02() throws IOException, InterruptedException {
        Runtime runtime = Runtime.getRuntime();
        // 需要进行异常处理
        // 打开notepad
        Process process = runtime.exec("notepad.exe");
        for (int i = 0; i < 100000; i++) {

        }
        // 主线程进入休眠状态
        Thread.sleep(5000);
        // 结束进程
        process.destroy();
    }

}
