package com.se.API.liu.Exception;

import java.util.InputMismatchException;
import java.util.Scanner;

class Person implements Cloneable{
    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}

//todo:java中的异常 都有对应的类来进行描述
//todo:受查异常/编译时异常(主要发生在编译的时候 需要处理)   非受查异常/运行时异常(runtime exception) (主要发生在运行的时候 需要处理)
//todo:异常的处理  try catch语句
//todo:Java中不会同时抛出两个及以上异常
//todo:Java中用throw抛出异常
//todo:Java中的try-catch-finally语句
//todo:自定义异常类 在实际开发中根据业务需要所定义的异常类
public class Test {
    public static int getData1(){
        Scanner sc = null;
        try{
            sc = new Scanner(System.in);
            int data = sc.nextInt();
            return data;
        }catch(InputMismatchException e){
            e.printStackTrace();
        }finally {
            return 100;
        }
    }
    public static int getData(){
        Scanner sc = null;
        try{
            sc = new Scanner(System.in);
            int data = sc.nextInt();
            return data;
        }catch(InputMismatchException e){
            e.printStackTrace();
        }finally {
            System.out.println("finally中的代码");
        }
        System.out.println("try-catch-finally之后的代码");
        if(null != sc){
            sc.close();
        }
        return 0;
    }

    public static void main(String[] args) {
  /*      int data = getData();
        System.out.println(data);*/
        int data1 = getData1();
        System.out.println(data1);
    }
    public static void main6(String[] args) {
        try(Scanner scanner = new Scanner(System.in)){
            int n = scanner.nextInt();
            System.out.println(n);
        }catch (InputMismatchException e){
            e.printStackTrace();
            System.out.println("输入的数据不匹配！");
        }finally {
            System.out.println("执行了finally部分，一般用来关闭资源！");
        }
    }
    public static void test(int a){
        try{
            if(a == 10){
                throw new NullPointerException();
            }
        }catch (NullPointerException e){
            e.printStackTrace();
        }
        System.out.println("1");
    }
    public static void test1(int a) throws CloneNotSupportedException,ArithmeticException,NullPointerException{
        if(a == 10){
            throw new CloneNotSupportedException();
        }
        System.out.println("11111");
    }

    public static void main5(String[] args) {
        /*test(10);
        System.out.println("2");*/
        try{
            test1(10);
        }catch(CloneNotSupportedException e){
            e.printStackTrace();
        }
        System.out.println("2");
    }
    public static void main4(String[] args) {
        try{
            //System.out.println(10/0);
            int[] array = {1,2,3,4};
           // System.out.println("ahduwdh");//todo:此处不会执行 因为上句已经有异常了 会直接调转到catch捕获异常
            System.out.println(array[10]);
        }catch (ArithmeticException | NullPointerException | ArrayIndexOutOfBoundsException e){
            e.printStackTrace();//todo:快速定位异常出现的位置
            System.out.println("你这里出现算术异常了！");
        }
        //todo:当程序出现异常的时候 程序立即终止了
        System.out.println("执行后续代码！");
    }

    public static void main3(String[] args) {
        int[] array = {1,2,3,4};
        System.out.println(array[10]);
    }
    public static void func(){
        func();
    }
    public static void main2(String[] args) {
        func();
    }
    public static void main1(String[] args) throws CloneNotSupportedException{
        Person person  = new Person();
        Person person1 = (Person)person.clone();
    }
}
