package leetcode;

/*
* Brute force:
* Time: O(n2)
* Space: O(1)
*
* Dynamic Programming:
* Time: O(n)
* Space: O(n)
* For each entry, we need to find the max to its left and right.
* In case of brute force, we search for both values every time we go to a new entry.
* Then we just take the min of both max values and subtract from it the height of the current value.
*
* Dynamic Programming just runs one time from left to right and one time from right to left to create 2 arrays holding
* the max values for each entry.
*
* The max arrays are created by the logic that a max value will remain the same for all cells previous to the next bigger
* value.
*
* vals = [1,2,0,2,0,3]
* indx = [0,1,2,3,4,5]
* maxl = [1,2,2,2,2,3]
* maxr = [3,3,3,3,3,3]
*
* Then we apply the same computation logic.
* */

public class TrappingRainWater {
    public int trapBrutForce(int[] height) {
        int n = height.length;
        int result = 0;
        for (int i=0;i<n;i++) {
            int leftMax = findLeftMax(height, i);
            int rightMax = findRightMax(height, i);
            result += Math.min(leftMax, rightMax) - height[i];
        }
        return result;
    }

    private int findRightMax(int[] height, int index) {
        int n = height.length;
        int max = Integer.MIN_VALUE;
        for (int i=index; i<n; i++) {
            if (height[i] > max) max = height[i];
        }
        return max;
    }

    private int findLeftMax(int[] height, int index) {
        int max = Integer.MIN_VALUE;
        for (int i=index;i>=0;i--) {
            if (height[i] > max) max = height[i];
        }
        return max;
    }

    /*
    * Time: O(n)
    * Space: O(n)
    * */

    public int trapDynamicProgramming(int[] heights) {
        int result = 0;
        int n = heights.length;
        int[] leftMax = new int[n];
        int[] rightMax = new int[n];
        leftMax[0] = heights[0];
        rightMax[n-1] = heights[n-1];

        for (int i=1;i<n;i++) {
            leftMax[i] = Math.max(leftMax[i - 1], heights[i]);
        }

        for (int i=n-2;i>=0;i--) {
            rightMax[i] = Math.max(rightMax[i + 1], heights[i]);
        }

        for (int i=1;i<n-1;i++) {
            result += Math.min(leftMax[i], rightMax[i]) -heights[i];
        }
        return result;
    }

    /*
     * Time: O(n)
     * Space: O(1)
     * */

    public int trapWaterDpConstantMemory(int[] heights) {
        int res = 0;
        int l=0;
        int r=heights.length - 1;
        int maxLeft = heights[l];
        int maxRight = heights[r];

        while (l < r) {
            if (maxLeft < maxRight) {
                // we arrived here because l < r. That means that r is for sure smaller, so we don't need
                // to compare with r anymore (Math.min(leftMax, rightMax) - h[i])
                // We start with l++ since we are offset by the fact that the outermost heights cannot trap any water
                l++;
                maxLeft = Math.max(maxLeft, heights[l]);
                res += maxLeft - heights[l];
            } else {
                r--;
                maxRight = Math.max(maxRight, heights[r]);
                res += maxRight - heights[r];
            }
        }
        return res;
    }
}
