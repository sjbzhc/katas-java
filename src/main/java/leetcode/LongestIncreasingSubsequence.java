package leetcode;

import java.util.Arrays;

/*
* Time: O(n2)
* Space: O(n)
*
* dp represents the length of the longest consecutive arr for index i
* we calculate from right to left, so we want the max of the solution at i (new) or at j adding 1 (older + this cell)
*
* In the tree, a leaf represents the number length of the sequence for a particular index. So for example we have a leaf
* for index 2 and we know that the last element we can add is x, we don't need to recalculate later when we encounter
* index 2 again, as we know it's value already
*
* We notice that we need to reach leafs until we start saving in our cache, that indicates this can be done with
* bottoms up DP
* 0 1 2 3
* 1 2 4 3
* start
*   rc(0):1
*       rc(1):1 2
*           rc(2):1 2 4 -> we only increase by 1 when we reach index 2
*           rc(3):1 2 5 -> we only increase by 1 when we reach index 3
*       rc(2):5
*       rc(3):4
*   rc(1):2
* Brute force: at each step in the decision tree, we have 2 choices, so 2^n total leafs
* Add memo
*
* */

public class LongestIncreasingSubsequence {
    public int lengthOfLISDp(int[] nums) {
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

    int n;
    int[] nums;
    int[] memo;
    public int lengthOfLIS(int[] nums) {
        n = nums.length;
        this.nums = nums;
        memo = new int[n];
        int res = 0;

        for (int i=0; i<n; i++) memo[i] = -1;

        for (int i=0; i<n; i++) {
            res = Math.max(res, helper(i));
        }

        return res;
    }

    private int helper(int i) {
        if (memo[i] != -1) return memo[i];

        int res = 1;

        for (int j=i+1; j<n; j++) {
            if (nums[i] < nums[j]) {
                res = Math.max(res, 1 + helper(j));
            }
        }

        return res;
    }
}
