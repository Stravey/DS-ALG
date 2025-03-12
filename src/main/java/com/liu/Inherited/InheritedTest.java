package com.liu.Inherited;

import com.liu.OOP.Employee;

public class InheritedTest {

    public static void main(String[] args) {
        //强制类型转换
        double x = 2.1411;
        int y = (int)x;
        System.out.println(y);

        Person p1 = new Person("张三",18) {
            @Override
            public String getDescription() {
                return "Gao";
            }
            @Override
            public String getPersonality() {
                return "Stern";
            }
        };
        System.out.println(p1.getDescription());
        System.out.println(p1.getPersonality());
        System.out.println(p1.toString());

        Person P2 = new Person("李四",19,"女",1.65,45.8) {
            @Override
            public String getDescription() {
                return "The description is thin";
            }
            @Override
            public String getPersonality() {
                return "Blending";
            }
        };
        System.out.println(P2.getDescription());
        System.out.println(
                P2.getPersonality()
        );
        System.out.println(P2.toString());
    }

}
