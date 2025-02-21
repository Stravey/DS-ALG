package com.strive.Greedy;

import java.util.LinkedList;

public class LC518 {
    public int change(int amount, int[] coins) {
        return rec(0,coins,amount,new LinkedList<Integer>(),true);
    }

    public int rec(int index,int[] coins,int remainder,LinkedList<Integer> stack,boolean first) {
        if(!first) {
            stack.push(coins[index]);
        }
        int count = 0;
        //todo 情况1.剩余金额 < 0 --- 无解
        if (remainder < 0) {
            print("无解：",stack);
        }
        //todo 情况2.剩余金额 > 0 --- 继续递归
        else if (remainder == 0) {
            print("有解：",stack);
            count = 1;
        }
        //todo 情况3.剩余金额 == 0 --- 有解
        else {
            //todo 循环内进行递归 多路递归
            for (int i = index; i < coins.length; i++) {
                count += rec(i, coins, remainder - coins[i], stack, false);
            }
        }
        if(!stack.isEmpty()){
            stack.pop();
        }
        return count;
    }


    public static void main(String[] args) {
        LC518 a = new LC518();
        int count = a.change(5,new int[]{1,2,5});
        System.out.println(count);
    }

    private static void print(String str,LinkedList<Integer> stack) {
        System.out.println(str + stack);
    }

}
