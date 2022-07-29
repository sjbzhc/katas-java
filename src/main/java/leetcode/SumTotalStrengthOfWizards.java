package leetcode;

import java.util.Stack;

/*
* Time: O(n)
* Space: O(n)
* */
public class SumTotalStrengthOfWizards {
    public int totalStrength(int[] strength) {
        int n = strength.length;

        int MOD = 1_000_000_007;

        // prefix sum array
        long[] preSum = new long[n + 1];

        // prefix sum of prefix sum
        long[] prePrefix = new long[n + 2];

        for (int i = 0; i < n; i++) {
            preSum[i + 1] = (preSum[i] + strength[i]) % MOD;
        }
        for (int i = 0; i <= n; i++) {
            prePrefix[i + 1] = (prePrefix[i] + preSum[i]) % MOD;
        }

        // identify range towards left in which i is acting as min element using monotonic decreasing stack
        int[] left = new int[n];
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < strength.length; i++) {
            while (!stack.isEmpty() && strength[i] <= strength[stack.peek()]) {
                stack.pop();
            }
            left[i] = stack.isEmpty() ? -1 : stack.peek();
            stack.push(i);
        }

        // identify range towards right in which i is acting as min element using monotonic decreasing stack
        int[] right = new int[n];
        stack = new Stack<>();
        for (int i = strength.length - 1; i >= 0 ; i--) {
            while (!stack.isEmpty() && strength[i] < strength[stack.peek()]) {
                stack.pop();
            }
            right[i] = stack.isEmpty() ? n : stack.peek();
            stack.push(i);
        }

        long ans = 0;
        for (int i = 0; i < n; i++) {

            ans += ((prePrefix[right[i] + 1] - prePrefix[i + 1]) * (i - left[i]) % MOD + MOD -
                    (prePrefix[i + 1] - prePrefix[left[i] + 1]) * (right[i] - i) % MOD) * strength[i];
            ans %= MOD;

        }
        return (int)ans;
    }
}
