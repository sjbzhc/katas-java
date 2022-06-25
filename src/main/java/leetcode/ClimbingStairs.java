package leetcode;

import java.util.HashMap;
import java.util.Map;


/*
* Time: O(n)
* Space: O(n)
* */
public class ClimbingStairs {
    Map<Integer, Integer> map = new HashMap<>();
    public int climbStairs(int n) {
        return helper(0, n);
    }

    public int helper(int current, int n) {
        if (current > n) return 0;

        if (current == n) return 1;

        if (map.get(current) != null) {
            return map.get(current);
        }

        map.put(current, helper(current + 1, n) + helper(current + 2, n));

        return map.get(current);
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
