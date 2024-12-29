package leetcode;

/*
* We try to maximize:
* values[i] + i + values[j] - j
*
* Time: O(n)
* Space: O(1)
* */

public class BestPairSightSeeing {
    public int maxScoreSightseeingPair(int[] values) {
        int[] dp = new int[values.length];
        dp[0] = values[0] + 0;
        int res = Integer.MIN_VALUE;

        // store in dp[i] the best possible value of (values[i] + i) from all indices up until i
        for (int i=1; i<dp.length; i++) {
            dp[i] = Math.max(dp[i-1], values[i] + i);
        }

        // complete the equation (values[j] - j)
        for (int i=1; i< dp.length; i++) {
            res = Math.max(res, dp[i-1] + (values[i] - i));
        }

        return res;
    }
}
