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

        // corresponds to updating with values[i] + i
        for (int i=1; i<dp.length; i++) {
            dp[i] = Math.max(dp[i-1], values[i] + i);
        }

        // corresponds to updating with values[j] - j
        // since we add it to dp[i-1], we make sure that (values[i] - i) represents the element after i-1
        for (int i=1; i< dp.length; i++) {
            res = Math.max(res, dp[i-1] + (values[i] - i));
        }

        return res;
    }
}
