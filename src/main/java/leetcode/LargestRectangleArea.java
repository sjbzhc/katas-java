package leetcode;

import java.util.Stack;

/*
* Time: O(n)
* Space: O(n)
* */

public class LargestRectangleArea {
    public int largestRectangleArea(int[] heights) {
        int maxArea = 0;
        Stack<int[]> stack = new Stack<>();

        for (int i=0; i<heights.length; i++) {
            int start = i;
            int h = heights[i];

            // we want to keep the heights of the elements in the stack increasing, as that way we can
            // guarantee that when we make a calculation for maxArea, we can use as a width the index where
            // the tuple was added and the current index (no fear of having a whole in our block)
            while (!stack.isEmpty() && stack.peek()[1] > h) {
                int[] current = stack.pop();
                int prevIndex = current[0];
                int prevHeight = current[1];
                maxArea = Math.max(maxArea, prevHeight * (i - prevIndex));
                // setting start to prevIndex makes sure that for th next item we add, we consider the relevant
                // width. Since all elements were increasing, we guarantee that the index of the last element we
                // pop is the start of the width, as all other elements were higher
                start = prevIndex;
            }

            stack.push(new int[]{start, h});
        }

        // If they are still here, they were able to stay from the beginning till their index
        while (!stack.isEmpty()) {
            int[] s = stack.pop();
            int i = s[0];
            int h = s[1];
            maxArea = Math.max(maxArea, h * (heights.length - i));
        }
        return maxArea;
    }
}
