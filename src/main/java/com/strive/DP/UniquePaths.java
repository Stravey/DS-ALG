package com.strive.DP;

//todo 不同路径
public class UniquePaths {
    //todo 将题目信息写出来 进行分析
    public int uniquePaths(int m, int n) {
        int[][] dp = new int[m][n];
        for (int i = 0; i < m; i++) {
            dp[i][0] = 1;
        }
        for (int j = 0; j < n; j++) {
            dp[0][j] = 1;
        }
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
            }
        }
        return dp[m - 1][n - 1];
    }

    public static void main(String[] args) {
        int count = new UniquePaths().uniquePaths(3,7);
        System.out.println(count);
        count = new UniquePaths().uniquePaths(2,3);
        System.out.println(count);
    }
}
