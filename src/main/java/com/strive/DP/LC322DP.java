package com.strive.DP;


public class LC322DP {
    public int coinChange(int[] coins, int amount) {
        int[][] dp = new int[coins.length][amount + 1];
        for (int j = 1; j < amount + 1; j++) {
            if(j >= coins[0]) {  //装下
                dp[0][j] = dp[0][j - coins[0]] + 1;
            }else {
                dp[0][j] = amount + 1;  //最大值
            }
        }
        for (int i = 1; i < coins.length; i++) {
            for (int j = 1; j < amount + 1; j++) {
                if(j >= coins[0]) {
                    dp[i][j] = Integer.min(dp[i - 1][j],dp[i][j - coins[i]] + 1);
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }
        return dp[coins.length - 1][amount] < amount + 1 ? dp[coins.length - 1][amount + 1] : -1;
    }

    public static void main(String[] args) {
        LC322DP a = new LC322DP();
        int count = a.coinChange(new int[]{1,2,5},3);
        System.out.println(count);
    }

}
