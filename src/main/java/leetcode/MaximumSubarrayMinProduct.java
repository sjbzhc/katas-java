package leetcode;

import java.util.Stack;

/*
* Time: O(n)
* Space: O(n)
* */

public class MaximumSubarrayMinProduct {
    private static final int MOD = 1000000007;
    public int maxSumMinProduct(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        final int n = nums.length;
        long[] sums = new long[n+1];
        for (int i = 1; i <= n; i++) {
            sums[i] = sums[i-1] + nums[i-1];
        }
        long res = Long.MIN_VALUE;
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i <= n; i++) {
            int cur = i == n ? 0 : nums[i];
            while (!stack.isEmpty() && nums[stack.peek()] >= cur) {
                int min = nums[stack.pop()];
                // + 1 since sums is offset by 1
                int j = stack.isEmpty() ? 0 : stack.peek() + 1;
                // since we have monotonic increasing stack, j, which was stored in stack, always comes before i
                long sum = sums[i] - sums[j];
                long prod = min * sum;
                res = Math.max(res, prod);
            }
            stack.push(i);
        }
        return (int) (res % MOD);
    }
}
