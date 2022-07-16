package leetcode;

import java.util.HashMap;
import java.util.Map;

/*
* Time: O(n^3)
* Space: O(n^2)
*
* We assume that we are popping the balloon at i last.
* So we for arrangement l i.............. r
* we multiply i with elements at l-1 and r+1 and to that result we add the subproblems delimited by the
* subarray from l to i-1 and from i+1 to r
*
* */

public class BurstBalloons {
    Map<String, Integer> cache = new HashMap<>();
    int[] nums;
    public int maxCoins(int[] nums) {
        int[] tmp = new int[nums.length + 2];
        tmp[0] = 1;
        tmp[tmp.length - 1] = 1;
        for (int i=1; i < tmp.length-1; i++) {
            tmp[i] = nums[i-1];
        }
        this.nums = tmp;
        return dfs(1, this.nums.length - 2);
    }

    private int dfs(int l, int r) {
        if (l > r) return 0;

        String key = l + "#" + r;

        if (cache.containsKey(key)) return cache.get(key);

        cache.put(key, 0);

        for (int i=l; i <= r; i++) {
            int coins = nums[l - 1] * nums[i] * nums[r + 1];
            coins += dfs(l, i-1) + dfs(i+1, r);
            cache.put(key, Math.max(cache.get(key), coins));
        }
        return cache.get(key);
    }
}
