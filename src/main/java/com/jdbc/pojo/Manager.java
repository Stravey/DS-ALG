package com.jdbc.pojo;

public class Manager {
    String name;
    int age;
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
        return "Manager{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
