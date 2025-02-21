package com.strive.DP;

public class Fibonacci {
    public static void main(String[] args) {
        System.out.println(fibonacci2(13));
    }
    public static int fibonacci2(int n) {
        if(n == 0) {
            return 0;
        }
        if(n == 1) {
            return 1;
        }
        int a = 0;
        int b = 1;
        for (int i = 2; i <= n; i++) {
            int c = b + a;
            a = b;
            b = c;
        }
        return b;
    }
    public static int fibonacci(int n) {
        int[] dp = new int[n + 1];  //用来缓存结果
        if(n == 0) {
            dp[0] = 0;
            return 0;
        }
        if(n == 1) {
            dp[1] = 1;
            return 1;
        }
        for (int i = 2; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n];
    }
}
