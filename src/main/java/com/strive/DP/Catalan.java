package com.strive.DP;

//卡特兰数 leetcode 96(不同二叉搜索树)  出栈序列问题  leetcode22(括号生成)
public class Catalan {
    static int catalan(int n){
        int[] dp = new int[n + 1];
        dp[0] = 1;
        dp[1] = 1;
        for (int j = 2; j < n + 1; j++) {
            for (int i = 0; i < j; i++) {  //第j个卡特兰数的拆分
                //System.out.printf("(%d,%d)\t",i,j - 1 - i);
                dp[j] += dp[i] * dp[j - 1 - i];
            }
            //System.out.println();
            //System.out.println(Arrays.toString(dp));
        }
        return dp[n];
    }

    public static void main(String[] args) {
        System.out.println(catalan(5));
        System.out.println(catalan(19));
    }
}
