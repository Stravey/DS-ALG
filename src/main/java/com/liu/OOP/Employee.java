package com.liu.OOP;

import java.time.LocalDate;

class Employee {
    //instance fields
    private String name;
    private double salary;
    private LocalDate hireDay;

    //constructor
    public Employee(String name, double salary, int year,int month,int day) {
        this.name = name;
        this.salary = salary;
        hireDay = LocalDate.of(year,month,day);
    }

    public String getName() {
        return name;
    }

    public double getSalary() {
        return salary;
    }

    public LocalDate getHireDay() {
        return hireDay;
    }

    public void raiseSalary(double a) {
        double raise = salary * a / 100;
        salary += raise;
    }
}
