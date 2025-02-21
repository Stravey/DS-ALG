package com.strive.DP;

public class LC34DP {
    static int lcs(String a,String b){
        int[][] dp = new int[a.length()][b.length()];
        int max = 0;
        for (int i = 0; i < b.length(); i++) {
            for (int j = 0; j < a.length(); j++) {
                if(a.charAt(j) == b.charAt(i)) {
                    if(i == 0 || j == 0) {
                        dp[i][j] = 1;
                    }else {
                        dp[i][j] = dp[i - 1][j - 1] + 1;
                    }
                    max = Integer.max(max,dp[i][j]);
                }else {
                    dp[i][j] = 0;
                }
            }
        }
        return max;
    }

    /*

            i   t   h   e   i   m   a
        t   0   1   0   0   0   0   0
        h   0   0   2   0   0   0   0
        e   0   0   0   3   0   0   0
        m   0   0   0   0   0   1   0
        a   0   0   0   0   0   0   2


       if(相同字符){
           dp[i][j] = dp[i - 1][j - 1] + 1
       }else{
           dp[i][j] = 0
       }
     */

    public static void main(String[] args) {
        System.out.println(lcs("atheism","them"));
    }
}
