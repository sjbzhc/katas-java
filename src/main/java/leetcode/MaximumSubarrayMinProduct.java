package leetcode;

import java.util.Stack;

/*
* Time: O(n)
* Space: O(n)
*
* We want to find for each element in the nums array, the sub-array where nums[i] is the smallest element within the
* sub-array. This way, it's multiplying factor is minimized.
* To find the sum of the subarray, we use the prefixSum, which adds all elements up until i. To find the sum of a subarray
* we use prefix[end + 1] - prefix[start]
* */

public class MaximumSubarrayMinProduct {
    public int maxSumMinProduct(int[] nums) {
        int n = nums.length;
        long MOD = 1_000_000_007;
        long[] prefixSum = new long[n + 1];
        int[] prev = new int[n];
        int[] next = new int[n];
        Stack<Integer> stack = new Stack<>();

        for (int i=0; i<n; i++) {
            prefixSum[i+1] = prefixSum[i] + nums[i];
        }

        for (int i=0; i<n; i++) {
            while (!stack.isEmpty() && nums[i] <= nums[stack.peek()]) {
                stack.pop();
            }
            prev[i] = stack.isEmpty() ? -1 : stack.peek();
            stack.push(i);
        }

        stack.clear();

        for (int i=n-1; i>=0; i--) {
            while (!stack.isEmpty() && nums[i] < nums[stack.peek()]) {
                stack.pop();
            }
            next[i] = stack.isEmpty() ? n : stack.peek();
            stack.push(i);
        }

        long max = 0;

        for (int i=0; i<n; i++) {
            long subarraySum = prefixSum[next[i]] - prefixSum[prev[i] + 1];
            long prod = subarraySum * nums[i];
            max = Math.max(max, prod);
        }

        return (int) (max % MOD);
    }
}
