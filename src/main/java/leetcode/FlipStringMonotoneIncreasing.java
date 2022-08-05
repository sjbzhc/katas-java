package leetcode;

/*
* Time: O(N)
* Space: O(N)
*
* We separate for each element the left and right side.
*
* In the left side, which is dp, we count the number of ones up to i, since we want to have only 0s on the left.
*
* In the right side (including the current element) we count the number of zeros we have.
* The calculation is (n-i) - (dp[n] - dp[i])
*   n-i: total possible number of zeros
*   dp[n] - dp[i] number of ones in the range
*
* */

public class FlipStringMonotoneIncreasing {
    public int minFlipsMonoIncr(String s) {
        int n = s.length();
        int[] dp = new int[n + 1];

        for (int i=1; i<=n;i++) {
            dp[i] = dp[i-1] + (s.charAt(i-1) == '1' ? 1 : 0);
        }

        int ans = Integer.MAX_VALUE;

        for (int i =0; i<=n;i++) {
            ans = Math.min(ans, dp[i] + (n - i) - (dp[n] - dp[i]));
        }
        return ans;
    }
}
