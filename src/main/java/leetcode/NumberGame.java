package leetcode;

public class NumberGame {
    public int maxScore(int[] nums) {
        int n = 1 << nums.length;
        int[] dp = new int[n];
        for (int i = 0; i < n; i++) {
            for (int j = 0,bitmask = Integer.bitCount(i); j < nums.length && bitmask % 2 == 0; j++){ // find one mask that is not set
                for (int k = 0; k < nums.length && (i & (1<<j)) == 0; k++){ // find another one that is not set
                    if ((i & 1<<k) == 0) {
                        int mask = i | 1 << j | 1 << k;
                        dp[mask]= Math.max(
                                dp[mask],
                                dp[i] + (bitmask / 2 + 1) * gcd(nums[j], nums[k])); // update max
                    }
                }
            }
        }
        return dp[n-1];
    }

    private int gcd(int a, int b) {
        return a== 0 ? b : gcd(b % a, a);
    }
}
