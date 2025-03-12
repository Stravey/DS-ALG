package com.liu.Inherited;

@SuppressWarnings("all")
public abstract class Person {

    private String name;
    private int age;
    private String sex;
    private double height;
    private double weight;

    //抽象方法
    public abstract String getDescription();

    public Person() {
    }
    public Person(String name) {
        this.name = name;
    }
    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }
    public Person(String name,int age,String sex,double height,double weight) {
        this.name = name;
        this.age = age;
        this.sex = sex;
        this.height = height;
        this.weight = weight;
    }


    public String setName(String name) {
        return this.name = name;
    }
    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", sex='" + sex + '\'' +
                ", height=" + height +
                ", weight=" + weight +
                '}';
    }
}
