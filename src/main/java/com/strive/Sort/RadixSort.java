package com.strive.Sort;

import java.util.ArrayList;
import java.util.Arrays;

//todo 基数排序
@SuppressWarnings("all")
public class RadixSort {

    private static void radixSort(String[] a,int length){
        ArrayList<String>[] buckets = new ArrayList[10];
        for (int i = 0; i < buckets.length; i++) {
            buckets[i] = new ArrayList<>();
        }
        for(int i = length - 1;i >= 0;i--) {
            for (String s : a) {
                buckets[s.charAt(i) - '0'].add(s);
            }
            int k = 0;
            for (ArrayList<String> bucket : buckets) {
                for (String s : a) {
                    a[k++] = s;
                }
                bucket.clear();
            }
            System.out.println(Arrays.toString(a));
        }
    }

    public static void main(String[] args) {
        String[] phoneNumbers = new String[10];
        phoneNumbers[0] = "123";
        phoneNumbers[1] = "138";
        phoneNumbers[2] = "149";
        phoneNumbers[3] = "102";
        phoneNumbers[4] = "173";
        phoneNumbers[5] = "182";


        RadixSort.radixSort(phoneNumbers,3);
        for (String phoneNumber : phoneNumbers) {
            System.out.println(phoneNumber);
        }
    }
}
