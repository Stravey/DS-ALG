package com.se.API.liu.Inherited;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.Scanner;

/**
 * 反射机制
 * （1）运行时分析类的能力
 * （2）在运行时检查对象，如编写一个适用于所有类的toString方法
 * （3）实现泛型数组操作代码
 * （4）利用Method对象，等价于C++中的函数指针
 */

//此程序可以查看java编译器自动生成的内部类
@SuppressWarnings("all")
public class Reflective {

    public static void printConstuctor(Class cl) {
        Constructor[] constructors = cl.getDeclaredConstructors();
        for (Constructor c : constructors) {
            String name = c.getName();
            System.out.println(" ");
            String modifiers = Modifier.toString(c.getModifiers());
            if(modifiers.length() > 0) {
                System.out.println(modifiers + " ");
            }
            System.out.println(name + "(" );

            Class[] parameterTypes = c.getParameterTypes();
            for (int i = 0; i < parameterTypes.length; i++) {
                if(i > 0) {
                    System.out.print(", ");
                }
                System.out.println(parameterTypes[i].getName());
            }
            System.out.println(")");
        }
    }

    public static void printMethods(Class cl) {
        Method[] methods = cl.getDeclaredMethods();
        for (Method m : methods) {
            Class retType = m.getReturnType();
            String name = m.getName();
            System.out.println(" ");

            String modifiers = Modifier.toString(m.getModifiers());
            if(modifiers.length() > 0) {
                System.out.println(modifiers + " ");
            }
            System.out.println(retType.getName() + " " + name + "(");

            Class[] parameterTypes = m.getParameterTypes();
            for (int i = 0; i < parameterTypes.length; i++) {
                if(i > 0) {
                    System.out.print(", ");
                    System.out.println(parameterTypes[i].getName());
                }
            }
            System.out.println(")");
        }
    }

    public static void printFields(Class cl) {
        Field[] fields = cl.getDeclaredFields();
        for (Field f : fields) {
            Class type = f.getType();
            String name = f.getName();
            System.out.println(" ");
            String modifiers = Modifier.toString(f.getModifiers());
            if(modifiers.length() > 0) {
                System.out.println(modifiers + " ");
            }
            System.out.println(type.getName() + " " + name + ";");
        }
    }

    public static void main(String[] args) throws ReflectiveOperationException{
        String name;
        if(args.length > 0){
            name = args[0];
        }else {
            var in = new Scanner(System.in);
            System.out.println("Enter class name (e.g. java.util.Date):");
            name = in.next();
        }

        Class cl = Class.forName(name);
        Class supercl = cl.getSuperclass();
        String modifiers = Modifier.toString(cl.getModifiers());
        if(modifiers.length() > 0) {
            System.out.println(modifiers + " ");
        }
        System.out.println("class" + name);
        if(supercl != null && supercl != Object.class) {
            System.out.println("extends" + supercl.getName());
        }
        System.out.println("\n{\n");
        printConstuctor(cl);
        System.out.println();
        printMethods(cl);
        System.out.println();
        printFields(cl);
        System.out.println("}");
    }
}
