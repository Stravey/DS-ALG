package com.liu.Inherited;

import java.lang.reflect.Constructor;

/**
 * 反射机制
 * （1）运行时分析类的能力
 * （2）在运行时检查对象，如编写一个适用于所有类的toString方法
 * （3）实现泛型数组操作代码
 * （4）利用Method对象，等价于C++中的函数指针
 */

public class Reflective {


    public static void printConstuctor(Class<?> clazz) {
        Constructor[] constructors = clazz.getDeclaredConstructors();
        for (Constructor constructor : constructors) {
            String name = constructor.getName();
            System.out.println(" ");
            String
        }
    }
}
