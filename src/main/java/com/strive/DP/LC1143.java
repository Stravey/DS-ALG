package com.strive.DP;

public class LC1143 {

    /*

             a   b   c   x   y   z
         0   0   0   0   0   0   0
     a   0   1   1   1   1   1   1
     b   0   1   2   2   2   2   2
     x   0   1   2   2   3   3   3
     y   0   1   2   2   3   4   4
     z   0   1   2   2   3   4   5

     */
    public int longestCommonSubsequence(String text1, String text2) {
        int[][] dp = new int[text1.length() + 1][text2.length() + 1];
        for (int i = 1; i < text1.length() + 1; i++) {
            for (int j = 1; j < text2.length() + 1; j++) {
                if(text1.charAt(i - 1) == text2.charAt(j - 1)){
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                }else {
                    dp[i][j] = Integer.max(dp[i - 1][j],dp[i][j -1]);
                }
            }
        }
        return dp[text1.length()][text2.length()];
    }

    public static void main(String[] args) {
        LC1143 a = new LC1143();
        System.out.println(a.longestCommonSubsequence("abxyz","abcxyz"));
        System.out.println(a.longestCommonSubsequence("ba","yby"));
    }
}
