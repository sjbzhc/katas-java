package leetcode;

public class TrappingRainWater2 {
    public int trapDynamicProgramming(int[] heights) {
        int res = 0;
        int n = heights.length;
        int[] leftHeights = new int[n];
        int[] rightHeights = new int[n];

        leftHeights[0] = heights[0];
        rightHeights[n-1] = heights[n-1];

        for (int i = 1; i< n; i++) {
            if (heights[i] > leftHeights[i-1]) {
                leftHeights[i] = heights[i];
            } else {
                leftHeights[i] = leftHeights[i-1];
            }
        }

        for (int i = n - 2; i >= 0; i--) {
            if (heights[i] > rightHeights[i + 1]) {
                rightHeights[i] = heights[i];
            } else {
                rightHeights[i] = rightHeights[i + 1];
            }
        }

        for (int i=0;i<n;i++) {
            res += Math.min(leftHeights[i], rightHeights[i]) - heights[i];
        }

        return res;
    }
}
