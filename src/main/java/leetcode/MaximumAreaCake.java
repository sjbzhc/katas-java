package leetcode;

import java.util.Arrays;

/*
* Time: O(n log n)
* Space: O(1)
* */
public class MaximumAreaCake {
    public int maxArea(int h, int w, int[] horizontalCuts, int[] verticalCuts) {
        Arrays.sort(horizontalCuts);
        Arrays.sort(verticalCuts);
        int m = horizontalCuts.length;
        int n = verticalCuts.length;

        // first take a look at the outer areas, constrained by border and first/last horizontal cuts
        long maxHeight = Math.max(horizontalCuts[0], h - horizontalCuts[m - 1]);
        for (int i = 1; i < m; i++) {
            maxHeight = Math.max(maxHeight, horizontalCuts[i] - horizontalCuts[i - 1]);
        }

        long maxWidth = Math.max(verticalCuts[0], w - verticalCuts[n - 1]);
        for (int i = 1; i < n; i++){
            maxWidth = Math.max(maxWidth, verticalCuts[i] - verticalCuts[i - 1]);
        }

        return (int) ((maxWidth * maxHeight) % (1000000007));
    }
}
