package com.se.API.system_runtime;

import org.junit.Test;

import java.util.Enumeration;
import java.util.Properties;


@SuppressWarnings("all")
public class System_Demo {
    @Test
    public void test_01() {
        int[] arr = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16};
        int[] dearr = {17, 18, 19, 20, 21, 22, 23, 24, 25, 26};

        System.arraycopy(arr,2,dearr,3,4);
        for (int i = 0; i < dearr.length; i++) {
            System.out.println(dearr[i]);
        }
    }

    // 获取本地配置
    @Test
    public void test_02() {
        // properties存储的是键值对的数据：key-value
        // 存储当前操作系统所有属性信息
        Properties properties = System.getProperties();
        // 获取所有的key值
        Enumeration enumeration = properties.propertyNames();
        // 判断是否有元素
        while (enumeration.hasMoreElements()) {
            // 获取当前的元素
            String key = (String) enumeration.nextElement();
            // 依据key来获取属性对应的值
            String value = System.getProperty(key);
            System.out.println(key + "=" + value);
        }
    }


    // 默认继承Object类
    static class Person {
        @Override
        protected void finalize() throws Throwable {
            System.out.println("对象被回收...");
        }
    }

    @Test
    public void test_03() throws Throwable {
        Person person = new Person();

        person = null;
        System.gc();
        for(int i = 0;i < 1000000;i++) {
            // for耗时操作

        }
    }
}
