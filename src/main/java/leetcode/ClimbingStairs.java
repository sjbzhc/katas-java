package leetcode;

import java.util.HashMap;
import java.util.Map;


/*
* Time: O(n)
* Space: O(n)
* */
public class ClimbingStairs {
    int n;
    Map<Integer, Integer> memo = new HashMap<>();
    public int climbStairs(int n) {
        this.n = n;
        return helper(0);
    }

    private int helper(int i) {
        if (i > n) return 0;
        if (i == n) return 1;

        if (memo.containsKey(i)) return memo.get(i);

        int v = helper(i+1) + helper(i+2);

        memo.put(i, v);
        return v;
    }

    public int climbStairsDP(int n) {
        int one = 1;
        int two = 1;

        for (int i = n-1; i > 0; i--) {
            int temp = one;
            one = one + two;
            two = temp;
        }

        return one;
    }
}
