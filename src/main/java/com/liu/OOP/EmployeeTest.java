package com.liu.OOP;

import java.util.ArrayList;

@SuppressWarnings("all")
public class EmployeeTest {

    public static void main(String[] args) {
/*        Employee[] staff = new Employee[3];

        staff[0] = new Employee("111",75000,1987,12,15);
        staff[1] = new Employee("222",50000,1989,11,1);
        staff[2] = new Employee("333",40000,1990,3,15);

        //var声明局部变量
        var bob = new Employee("444",50000,1989,11,1);

        for(Employee e : staff) {
            e.raiseSalary(5);
        }

        for(Employee e : staff) {
            System.out.println(e.getName() + " " + e.getSalary() + " " + e.getHireDay() );
        }*/

        //ArrayList类似于C++中的vector模板 都是泛型类型
        //C++中的vector是按值拷贝
        ArrayList<Employee> staff = new ArrayList<Employee>();
        //可以使用var关键字避免重复写类名
        //var staff = new ArrayList<Employee>();
        staff.add(0,new Employee("张三",20000));
        staff.add(1,new Employee("李四",30000));
        staff.add(2,new Employee("王五",24000));
        for(Employee e : staff) {
            System.out.println(e);
        }

    }

}
