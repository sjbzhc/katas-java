package leetcode;

import java.util.HashMap;
import java.util.Map;

/*
* We build a decision tree, with decision to add or subtract in each node: 2^n
* We need to cache by (index, sum), as for each index we could have several different sum values
* For example, with 111, at index 1 we could have 2 or 0. If we only cache by index, we will overwrite
* results and ignoring the previously cached result. It I'm on the branch 1 + 1 and I want to check
* the next value, I want the cache to have the value 2 for index 1, not 0 (as would be the overwritten value with 1-1)
*
* Time: O(mn)
* Space: O(mn)
* */

public class TargetSum {
    class Pair {
        int index;
        int total;

        public Pair(int index, int total) {
            this.index = index;
            this.total = total;
        }
    }

    Map<Pair, Integer> dp = new HashMap<>();
    int[] nums;
    int target;
    public int findTargetSumWays(int[] nums, int target) {
        this.nums = nums;
        this.target = target;
        return helper(0, 0);
    }

    private int helper(int i, int sum) {
        if (i == nums.length) {
            if (sum == target) return 1;
            return 0;
        }

        Pair key = new Pair(i, sum);
        if (dp.containsKey(key)) return dp.get(key);

        // mapping a (index, currentTotal) key to the number of possible ways to solve the subproblem i +1 (includes +/-)
        // tree is built bottoms up, so once the calls with i == nums.length return 1 or 0, they are popped from the
        // call stack and added to the caller's result.
        // At the end we are returning for the total sum the cache at key (0, 0)
        dp.put(key, helper(i + 1, sum + nums[i]) + helper(i + 1, sum -  nums[i]));

        return dp.get(key);
    }
}
