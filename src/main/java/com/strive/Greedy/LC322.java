package com.strive.Greedy;

import java.util.LinkedList;
import java.util.concurrent.atomic.AtomicInteger;

public class LC322 {
    static int min = -1;

    public int coinChange(int[] coins, int amount) {
        rec(0,coins,amount,new AtomicInteger(-1),new LinkedList<Integer>(),true);
        return min;
    }

    public void rec(int index,int[] coins,int remainder,AtomicInteger count,LinkedList<Integer> stack,boolean first) {
        if(!first) {
            stack.push(coins[index]);
        }
        count.incrementAndGet();  //count++
        //todo 情况1.剩余金额 < 0 --- 无解
        if(remainder == 0) {
            System.out.println(stack);
            if(min == -1) {
                min = count.get();
            } else {
                min = Integer.min(min,count.get());
            }
        } else if (remainder > 0) {
            for (int i = index; i < coins.length ; i++) {
                rec(i,coins,remainder - coins[i],count,stack,false);
            }
        }
        count.decrementAndGet();  //count--
        if(!stack.isEmpty()) {
            stack.pop();
        }
    }

    public static void main(String[] args) {
        LC322 b = new LC322();
        int count = b.coinChange(new int[]{5,2,1},18);
        System.out.println(count);
    }
}
