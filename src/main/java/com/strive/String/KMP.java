package com.strive.String;

// todo 前缀表 最大相等前后缀的下一个位置的索引即为下一次开始匹配的位置

public class KMP {
    public static void getNext(String sub,int[] next){
        next[0] = -1;
        next[1] = 0;
        int i = 2;
        int k = 0; // 前一项的k
        for (; i < sub.length(); i++) {
            if(k == -1 || sub.charAt(i - 1) == sub.charAt(k)){
                next[i] = k + 1;
                k++;
                i++;
            }else {
                k = next[k];
            }
        }
    }

    //todo next数组的优化NextValue

    //todo str 主串 sub 子串 pos 从子串的pos位置开始匹配
    public static int KMP(String str, String sub,int pos) {
        if(str == null || sub == null) return -1;
        int lenStr = str.length();
        int lenSub = sub.length();
        if(lenStr == 0 || lenSub == 0) return -1;
        if(pos < 0 || pos >= lenSub) return -1;

        int[] next = new int[lenSub];
        //todo 最重要的部分
        getNext(sub,next);

        int i = pos; // 遍历主串
        int j = 0;  // 遍历子串

        while(i < lenStr && j < lenSub){
            if(j == -1 || str.charAt(i) == sub.charAt(j)){
                i++;
                j++;
            }else {
                j = next[j];
            }
        }
        if(j >= lenSub){
            return i - j;
        }
        return -1;
    }

    public static void main(String[] args) {
        System.out.println(KMP("ababcabcdabcdeabcdef","abcde",0));
        System.out.println(KMP("ababcabcdabcdeabcdef","abcd",0));
        System.out.println(KMP("ababcabcdabcdeabcdef","abc",0));

    }

}
