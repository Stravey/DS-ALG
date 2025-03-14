package com.liu.OOP;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Scanner;

public class ArrayListTest {

    //定义枚举类
    public enum Size{
        Small, Medium, Large;

        Size() {
        }

        private String abbreviation;
        Size(String abbreviation){
            this.abbreviation = abbreviation;
        }

        public String getAbbreviation() {
            return abbreviation;
        }
    }

    @Test
    public void testEnum() {
        var in = new Scanner(System.in);
        System.out.println("Please enter a size:(Small|Medium|Large)");
        String input = in.next().toUpperCase();
        Size size = Enum.valueOf(Size.class,input);
        System.out.println("size = " + size);
        System.out.println("abbreviation = " + size.getAbbreviation());
        if(size == Size.Large){
            System.out.println("size is large");
        }

    }

    public static void main(String[] args) {
        var staff = new ArrayList<Employee>();

        staff.add(new Employee("张三",20000,2002,11,5));
        staff.add(new Employee("李四",20000,2002,11,5));
        staff.add(new Employee("王五",20000,2002,11,5));

        for(Employee e : staff) {
            e.raiseSalary(5);
        }

        for(Employee e : staff) {
            System.out.println("name = " + e.getName() + ", salary = " + e.getSalary());
        }

    }
}
