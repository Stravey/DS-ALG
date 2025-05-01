package com.se.API.liu.Generic;

import com.liu.Generic.ArrayAlg;
import com.liu.Generic.Pair;

import java.time.LocalDate;

public class PairTest2 extends com.liu.Generic.ArrayAlg {
    public static void main(String[] args) {
        LocalDate[] birthdays = {
                LocalDate.of(1990, 1, 1),
                LocalDate.of(1991, 1, 1),
                LocalDate.of(1991, 1, 2),
                LocalDate.of(1991, 1, 3),
        };
        Pair<LocalDate> pair = com.liu.Generic.ArrayAlg.minmax(birthdays);
        System.out.println("min = " + pair.getFirst());
        System.out.println("max = " + pair.getSecond());
    }
}
