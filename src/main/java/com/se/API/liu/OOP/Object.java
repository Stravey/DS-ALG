package com.se.API.liu.OOP;

@SuppressWarnings("all")
public class Object {


    private int ax;
    private int ay;

    //类有多个构造方法  重载
    //java允许任何重载方法
    StringBuilder message = new StringBuilder();
    StringBuilder todoList = new StringBuilder("To do:\n");

    public Object() {
    }
    //this指示一个方法的隐式参数
    //java中 this引用等价于C++中的this指针
    public Object(int ax,int ay){
        this.ax = ax;
        this.ay = ay;
    }

    //从java7开始 程序会检查是否有main方法 java6之前没有main方法也可以打印hello world
    public static void main(String[] args) {
        Object object = new Object(1,2);

    }

}
