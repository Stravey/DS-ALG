package com.strive.Greedy;

public class LC322Greedy {
    public int coinChange(int[] coins, int amount) {
        //todo 每次循环找到当前最优解
        int remainder = amount;
        int count = 0;
        for(int coin : coins) {
            while(remainder > coin) {
                remainder -= coin;
                count++;
            }
            if(remainder == coin) {
                remainder = 0;
                count++;
                break;
            }
        }
        if(remainder > 0) {
            return -1;
        } else {
            return count;
        }
    }

    public static void main(String[] args) {
        LC322Greedy a = new LC322Greedy();
        int count = a.coinChange(new int[]{15,10},20);
        System.out.println(count);
    }
}
