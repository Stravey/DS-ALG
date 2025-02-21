package com.strive.DP;


import java.util.Arrays;

public class LC300 {

    /*

       1     3     6     4      9
       1     13    16    14     19
                   136   134    139
                                169
                                1369
                                149
                                1349

       1     2     3     3      2
                                3
                                4

     */

    public int lengthOfLIS(int[] nums) {
        int[] dp = new int[nums.length];
        Arrays.fill(dp,1);
        for (int i = 1; i < nums.length; i++) {
            for (int j = 0; j < i; j++) {
                if(nums[i] > nums[j]) {
                    //满足升序条件
                    dp[i] = Integer.max(dp[i],dp[j] + 1);
                }
            }
        }
        return Arrays.stream(dp).max().getAsInt();
    }

    public static void main(String[] args) {
        LC300 code = new LC300();
        System.out.println(code.lengthOfLIS(new int[]{1,3,6,4,9}));
    }
}
