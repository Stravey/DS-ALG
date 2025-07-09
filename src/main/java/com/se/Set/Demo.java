package com.se.Set;


import org.junit.Test;

import java.util.ArrayList;
import java.util.Collection;

public class Demo {

    @Test
    public void test() {
        Collection<String> coll = new ArrayList<>();
        coll.add("aaa");
        coll.add("bbb");
        coll.add("ccc");
        coll.add("ddd");
        System.out.println(coll);
        coll.remove("ccc");
        System.out.println(coll);
    }
}
