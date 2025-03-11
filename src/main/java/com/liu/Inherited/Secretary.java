package com.liu.Inherited;

import com.liu.OOP.Employee;

public class Secretary extends Employee {

    private double bonus;

    private double salary;

    public Secretary(String name, double salary) {
        super(name, salary);
    }

    public Secretary(String name, double salary, int year, int month, int day) {
        super(name, salary, year, month, day);
    }

    @Override
    public double getSalary() {
        return salary;
    }

}
