package com.liu.Inherited;

import com.liu.OOP.Employee;
import org.junit.Test;

@SuppressWarnings("all")
public class Manager extends Employee {

    //奖金
    private double bonus;

    //C++中使用::调用父类方法
    //Java中使用super关键字调用父类方法
    public Manager(String name, double salary) {
        super(name,salary);
    }

    public Manager(String name, double salary, int year, int month, int day) {
        super(name, salary, year, month, day);
        bonus = 0;
    }

    public void setBonus(double bonus) {
        this.bonus = bonus;
    }
    public double getBonus() {
        return bonus;
    }

    public double getSalary() {
        double salary = super.getSalary();
        return salary + bonus;
    }

    @Test
    public void test() {

    }

    public static void main(String[] args) {
        Manager manager = new Manager("张三",1000);
        manager.setBonus(1.5);
        System.out.println(manager.toString());

        //多态
        //Employee类型可以new Employee的所有子类
        Employee e = new Manager("李四",2000);
        System.out.println(e.toString());
        Employee a = new Secretary("王五",3000);
        System.out.println(a.toString());
        Employee staff = new Secretary("李俞卓",5000,2003,7,16);
        System.out.println(staff.toString());

    }
}
