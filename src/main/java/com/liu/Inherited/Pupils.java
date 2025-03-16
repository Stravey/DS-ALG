package com.liu.Inherited;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public class Pupils {
    static class information {
        String name;
        int age;

        public information() {}

        public information(String name, int age) {
            this.name = name;
            this.age = age;
        }
        public String getName() {
            return name;
        }
        public void setName(String name) {
            this.name = name;
        }
        public int getAge() {
            return age;
        }
        public void setAge(int age) {
            this.age = age;
        }
        @Override
        public String toString() {
            return "information{" + "name='" + name + '\'' + ", age=" + age + '}';
        }
    }

    public static void main(String[] args) {
        ArrayList<information> arraylist = new ArrayList<information>();
        arraylist.add(new information("John", 18));
        arraylist.add(new information("Jane", 22));
        arraylist.add(new information("Jack", 23));
        arraylist.add(new information("Jill", 24));
        arraylist.add(new information("Bob", 25));
        arraylist.add(new information("Juice", 26));
        System.out.println(arraylist);


        String sql = "insert into pupils (name, age) values (?, ?)";

    }
}
