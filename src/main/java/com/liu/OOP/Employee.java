package com.liu.OOP;

import java.time.LocalDate;

class Employee {
    //instance fields
    private final String name;
    private double salary;
    private final LocalDate hireDay;

    //constructor
    public Employee(String name, double salary, int year,int month,int day) {
        this.name = name;
        this.salary = salary;
        hireDay = LocalDate.of(year,month,day);
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
}
