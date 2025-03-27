package com.liu.Generic;

import java.time.LocalDate;

public class PairTest2 extends ArrayAlg{
    public static void main(String[] args) {
        LocalDate[] birthdays = {
                LocalDate.of(1990, 1, 1),
                LocalDate.of(1991, 1, 1),
                LocalDate.of(1991, 1, 2),
                LocalDate.of(1991, 1, 3),
        };
        Pair<LocalDate> pair = ArrayAlg.minmax(birthdays);
        System.out.println("min = " + pair.getFirst());
        System.out.println("max = " + pair.getSecond());
    }
}
