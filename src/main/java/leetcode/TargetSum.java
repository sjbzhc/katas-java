package leetcode;

import java.util.HashMap;
import java.util.Map;

/*
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
        return backtrack(0, 0);
    }

    private int backtrack(int i, int sum) {
        if (i == nums.length) {
            if (sum == target) return 1;
            return 0;
        }

        Pair key = new Pair(i, sum);
        if (dp.containsKey(key)) return dp.get(key);

        dp.put(key, backtrack(i + 1, key.total + nums[i]) + backtrack(i + 1, key.total -  nums[i]));

        return dp.get(key);
    }
}
