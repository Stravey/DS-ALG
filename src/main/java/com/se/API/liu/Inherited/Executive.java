package com.se.API.liu.Inherited;

import com.liu.OOP.Employee;

public class Executive extends Employee {

    public Executive(String name, double salary) {
        super(name, salary);
    }

    public Executive(String name, double salary, int year, int month, int day) {
        super(name, salary, year, month, day);
    }
}
