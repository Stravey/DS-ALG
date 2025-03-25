package com.liu.Inherited;

import java.util.Scanner;

class Animal{
    public String name = "123";
    public int age;
    /*public Animal(){

    }*/
    static{
        System.out.println("Animal::static{}");
    }

    {
        System.out.println("Animal::{}");
    }

    public Animal(String name,int age){
        this.name = name;
        this.age = age;
        System.out.println("Animal(String,int)");
    }
    protected void eat(){
        System.out.println(name + "正在吃饭！");
    }
}
//子类 Dog extends继承 父类 Animal
final class Dog extends Animal{
    public boolean silly;
    static{
        System.out.println("Dog::static{}");
    }

    {
        System.out.println("Dog::{}");
    }

    //public String name = "hello";
    public Dog(String name,int age,boolean silly){
        super(name,age);
        this.silly = silly;
        System.out.println("Dog(String,int,boolean)");
    }
    //当子类完成初始化之前，先帮助父类部分初始化
    public void barks(){
        System.out.println(super.name + "汪汪叫！");
    }
   /* @Override
    public void eat() {
        super.eat();
    }*/
    @Override
    protected void eat(){
        System.out.println(name + "正在吃屎！");
    }
}
final class Cat extends Animal{
    static{
        System.out.println("Cat::static{}");
    }

    {
        System.out.println("Cat::{}");
    }
    public void catchMouse(){
        System.out.println(name + "正在抓老鼠！");
    }

    public Cat(String name,int age){
        super(name,age);
        System.out.println("Dog(String,int)");
    }
    @Override
    public void eat() {
        super.eat();
    }
}

public class Test {

    public static void function(Animal animal){
        animal.eat();
    }
  /*  public static void function2(Animal animal){
        return new Cat();
    }*/

    public static void main(String[] args) {
       /* Dog dog = new Dog();
        dog.name = "旺财";
        dog.age = 10;
        dog.barks();
        dog.eat();
        Cat cat = new Cat();
        cat.name = "小白";
        cat.age = 10;
        cat.eat();
        cat.catchMouse();*/
        Dog dog = new Dog("张三",19,false);
        function(dog);
        Cat cat = new Cat("咪咪",20);
        function(cat);
        Animal animal = new Cat("hh",20);
        Cat cat1 = (Cat) animal;
        cat1.catchMouse();
        //多态的思想

       /* dog.eat();
        Animal animal = dog;
        animal.eat();
        Cat cat = new Cat("咪咪",20);
        Animal animal2 = new Dog("hello",10,false);
        */
    }
}

class odd{
    public static void main1(String[] args) {
        System.out.println("撸起袖子加油干，The nation remains mobilized  for brand new endeavors");
    }

    public static void main(String[] args) {
        Scanner scanner  = new Scanner(System.in);
        int number;
        int sum = 1;
        System.out.println("请输入整数(以0结束)：");
        while(true){
            if(scanner.hasNextInt()){
                number = scanner.nextInt();
                if(number == 0){
                    break;
                }
                sum *= number;
            }else{
                System.out.println("输入的不是整数！");
                scanner.next();
            }
        }
        scanner.close();
        if (sum == 1) {
            return;
        } else {
            System.out.println("输入的整数乘积为：" + sum);
        }
    }
}

class A{
    @Override
    public String toString() {
        return "111";
    }
}
class Dim{
    public static void main(String[] args) {
        A a = new A();
        System.out.println(a);
    }
}


//组合
class Student{

}
class Teacher{

}
class School{
    public Student[] students;
    public Teacher[] teachers;
}
