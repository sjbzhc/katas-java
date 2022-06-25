package leetcode;

/*
* Time: O(n)
* Space: O(n)
* */

public class MinCostClimbingStairs {
    public int minCostClimbingStairs(int[] cost) {
        int[] costs = new int[cost.length + 1];
        for (int i=0; i< cost.length; i++) {
            costs[i] = cost[i];
        }

        costs[costs.length - 1] = 0;

        for (int i=costs.length - 3; i>=0; i--) {
            costs[i] += Math.min(costs[i + 1], costs[i + 2]);
        }

        return Math.min(costs[0], costs[1]);
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
