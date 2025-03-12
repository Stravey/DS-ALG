package com.liu.OOP;

import com.liu.Inherited.Person;

import java.time.LocalDate;

@SuppressWarnings("all")
public class Employee extends Person {
    //instance fields
    private final String name;
    private double salary;
    private LocalDate hireDay;

    public Employee(String name, double salary) {
        this.name = name;
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "salary=" + salary +
                ", name='" + name + '\'' +
                '}';
    }

    //constructor
    public Employee(String name, double salary, int year,int month,int day) {
        this.name = name;
        this.salary = salary;
        hireDay = LocalDate.of(year,month,day);
    }


    @Override
    public String getDescription() {
        return "";
    }
    @Override
    public String getPersonality() {
        return "";
    }

    //封装的优点
    //
    public String getName() {
        return name;
    }
    public double getSalary() {
        return salary;
    }
    public LocalDate getHireDay() {
        return hireDay;
    }
    //隐式参数和显示参数
    //java中所有的方法都必须在类的内部定义，但并不表示他们是内联方法
    //是否设置为内联方法是Java虚拟机的任务
    public void raiseSalary(double a) {
        double raise = salary * a / 100;
        salary += raise;
    }

    public boolean equals(Employee e) {
        return name.equals(e.name);
    }

    public static void swap(Employee x, Employee y) {
        Employee temp = x;
        x = y;
        y = temp;
    }

    //java中对象引用是按值传递的，不是按引用调用
    //Java中方法参数：
    //1.方法不能修改基本数据类型的参数
    //2.方法可以改变对象参数的状态
    //3.方法不能让一个对象参数引用一个新的对象

}
