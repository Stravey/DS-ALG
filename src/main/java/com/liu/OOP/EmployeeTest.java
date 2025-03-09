package com.liu.OOP;


@SuppressWarnings("all")
public class EmployeeTest {

    public static void main(String[] args) {
        Employee[] staff = new Employee[3];

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
        }
    }

}
