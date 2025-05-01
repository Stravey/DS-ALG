package com.se.API.liu.Array;

public class arrayString {
    public static String mytoString(int[] tmp){
        String ret = "[";
        for (int i = 0; i < tmp.length; i++) {
            ret += tmp[i];
            if(i != tmp.length - 1){
                ret += ",";
            }
        }
        ret = ret + "]";
        return ret;
    }
    public static void main(String[] args) {
        int[] array = {1,2,3,4};
        //System.out.println(Arrays.toString(array));
        System.out.println(mytoString(array));
    }
}
