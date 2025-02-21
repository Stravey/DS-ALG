package com.strive.String;

public class BF {
    public static int BF(String str,String sub){
        if(str == null || sub == null){
            return -1;
        }
        int lenStr = str.length();
        int lenSub = sub.length();
        if(lenStr == 0 || lenSub == 0){
            return -1;
        }
        int i = 0;  //遍历主串
        int j = 0;  //遍历子串
        while(i < lenStr && j < lenSub){
            if(str.charAt(i) == sub.charAt(j)){
                i++;
                j++;
            }else{
                i = i - j + 1;
                j = 0;
            }
        }
        if(j >= lenSub){
            return i - j;
        }
        return -1;
    }
    public static void main(String[] args) {
        System.out.println(BF("ababcabcdabcde","abcd"));
    }
}
