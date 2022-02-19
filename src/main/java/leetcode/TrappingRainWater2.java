package leetcode;

public class TrappingRainWater2 {

    public int bruteForce(int[] heights) {
        int n =heights.length;
        int res = 0;
        for (int i=0;i<n;i++) {
            int left = getMaxLeft(heights, i);
            int right = getMaxRight(heights, i);
            res += Math.min(left, right) - heights[i];
        }
        return res;
    }

    private int getMaxRight(int[] heights, int index) {
        int max = Integer.MIN_VALUE;
        for (int i=index;i<heights.length;i++) {
            max = Math.max(max, heights[i]);
        }
        return max;
    }

    private int getMaxLeft(int[] heights, int index) {
        int max = Integer.MIN_VALUE;
        for (int i=0;i<=index;i++) {
            max = Math.max(max, heights[i]);
        }
        return max;
    }

    public int trapDynamicProgramming(int[] heights) {
        int res = 0;
        int n = heights.length;
        int[] leftMax = new int[n];
        int[] rightMax = new int[n];
        leftMax[0] = heights[0];
        rightMax[n-1] = heights[n-1];

        for (int i=1; i<n;i++) {
            if(leftMax[i-1] > heights[i]) {
                leftMax[i] = leftMax[i-1];
            } else {
                leftMax[i] = heights[i];
            }
        }

        for (int i=n-2;i>-0;i--) {
            if(heights[i] < rightMax[i+1]) {
                rightMax[i] = rightMax[i+1];
            } else {
                rightMax[i] = heights[i];
            }
        }

        for (int i=0; i<n;i++) {
            res += Math.min(rightMax[i], leftMax[i]) - heights[i];
        }

        return res;
    }
}
