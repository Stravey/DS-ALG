package com.strive.DP;

//todo 钢条切割问题 就是完全背包问题
public class CutRodProblem {
    /*
    0   1   2   3   4   5   6   7   8   9   10
    0   1   5   8   9   10  17  17  20  24  30

    4
        0   1   2   3   4

    1       1   11  111 1111

    2       1   11  111 1111
                2   21  211
                        22

    3       1   11  111 1111
                2   21  211
                    3   22
                        31

    4       1   11  111 1111
                2   21  211
                    3   22
                        31
                        4

     */
    static int cut(int[] values,int n){
        int[][] dp = new int[values.length][n + 1];
        for (int i = 1; i < values.length ; i++) {
            for (int j = 1; j < n + 1; j++) {
                if(j >= i) { // 放得下
                    dp[i][j] = Integer.max(dp[i - 1][j],values[i] + dp[i][j - i]);
                }else { // 放得下
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }
        return dp[values.length - 1][n];
    }

    public static void main(String[] args) {
        System.out.println(cut(new int[]{0,1,5,8,9},4));
    }
}
