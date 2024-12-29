package leetcode;

import java.util.HashMap;
import java.util.Map;

/*
* Time: O(n)
* Space: O(n)
* */

public class MinCostClimbingStairs {
    Map<Integer, Integer> cache = new HashMap<>();
    int[] cost;
    int n;
    public int minCostClimbingStairs(int[] cost) {
        this.cost = cost;
        n = cost.length;

        return Math.min(dfs(n-1), dfs(n-2));
    }

    public int dfs(int i) {

        if (i < 0) return 0;

        if (cache.containsKey(i)) return cache.get(i);

        if (i == 0 || i == 1) return cost[i];

        int v = cost[i] + Math.min(dfs(i-1), dfs(i-2));

        cache.put(i, v);
        return v;
    }

    public int minCostClimbingStairsBottomUp(int[] cost) {
        int[] minCost = new int[cost.length + 1];

        for (int i=2 ; i < minCost.length; i++) {
            int oneStep = minCost[i -1] + cost[i-1];
            int twoSteps = minCost[i-2] + cost[i-2];
            minCost[i] = Math.min(oneStep, twoSteps);
        }

        return minCost[minCost.length -1];
    }
}
