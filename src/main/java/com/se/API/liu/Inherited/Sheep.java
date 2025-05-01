package com.se.API.liu.Inherited;

import com.liu.Inherited.Animal;

//final关键字修饰的类不能继承
public final class Sheep extends com.liu.Inherited.Animal {

    public Sheep(String name, int age) {
        super(name, age);
    }


}
