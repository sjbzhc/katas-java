package leetcode;

import java.util.Stack;

/*
* Time: O(n)
* Space: O(n)
* */

public class BuildingsWithAnOceanView {
    public int[] findBuildings(int[] heights) {
        Stack<Integer> stack = new Stack<>();
        int max = 0;


        for (int i=heights.length-1; i>=0; i--) {
            if (i == heights.length - 1 || heights[i] > max) {
                max = heights[i];
                stack.push(i);
            }
        }

        int[] res = new int[stack.size()];

        for (int i=0; i<res.length; i++) {
            res[i] = stack.pop();
        }

        return res;
    }
}
