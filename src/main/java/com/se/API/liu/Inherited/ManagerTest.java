package com.se.API.liu.Inherited;

import com.liu.Inherited.Executive;
import com.liu.Inherited.Manager;
import com.liu.Inherited.Secretary;
import com.liu.OOP.Employee;

@SuppressWarnings("all")
public class ManagerTest {
    public static void main(String[] args) {
        var boss = new com.liu.Inherited.Manager("Carl",80000,1987,12,15);
        boss.setBonus(5000);

        var staff = new Employee[3];

        staff[0] = boss;
        staff[1] = new Employee("Harry",50000,1989,10,1);
        staff[2] = new Employee("Tommy",40000,1990,3,15);

        for(Employee e : staff) {
            System.out.println(e.toString());
        }

        //多态
        //Employee类型可以new Employee的所有子类
        Employee employee = new com.liu.Inherited.Manager("李四",2000);
        System.out.println(employee.toString());
        Employee a = new com.liu.Inherited.Secretary("王五",3000);
        System.out.println(a.toString());
        Employee Staff = new Secretary("李俞卓",5000,2003,7,16);
        System.out.println(Staff.toString());

        Employee b = new com.liu.Inherited.Executive("王强",10000);
        System.out.println(b.toString());
        Employee c = new Executive("刘刚",20000,2002,11,5);
        System.out.println(c.toString());

        //超类引用赋给子类变量时 需要强化类型转换
        //instanceof 关键字可以查看是否成功转换
        com.liu.Inherited.Manager newboss = (com.liu.Inherited.Manager) staff[1];
        if(staff[1] instanceof com.liu.Inherited.Manager) {
            newboss = (Manager) staff[1];
        }


    }
}
