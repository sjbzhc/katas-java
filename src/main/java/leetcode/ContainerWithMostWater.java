package leetcode;

/*
* Time: O(n)
* Space: O(1)
* */

public class ContainerWithMostWater {
    public int maxArea(int[] height) {
        int max = Integer.MIN_VALUE;
        int l = 0;
        int r = height.length - 1;

        while (l < r) {
            int leftValue = height[l];
            int rightValue = height[r];
            int width = r - l;
            int current = Math.min(leftValue, rightValue) * width;
            max = Math.max(max, current);

            if (leftValue <= rightValue) {
                l++;
            } else {
                r--;
            }
        }

        return max;
    }
}
