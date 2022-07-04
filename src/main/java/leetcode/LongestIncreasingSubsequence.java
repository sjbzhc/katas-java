package leetcode;

import java.util.Arrays;

/*
* Time: O(n2)
* Space: O(n)
*
* dp represents the length of the longest consecutive arr for index i
* we calculate from right to left, so we want the max of the solution at i (new) or at j adding 1 (older + this cell)
* */

public class LongestIncreasingSubsequence {
    public int lengthOfLIS(int[] nums) {
        int[] dp = new int[nums.length];
        Arrays.fill(dp, 1);

        for (int i=nums.length - 1; i>=0; i--) {
            for (int j=i+1; j<nums.length; j++) {
                if (nums[i] < nums[j]) {
                    dp[i] = Math.max(dp[i], 1 + dp[j]);
                }
            }
        }

        int max = Integer.MIN_VALUE;
        for (int n : dp) {
            max = Math.max(max, n);
        }
        return max;
    }
}
