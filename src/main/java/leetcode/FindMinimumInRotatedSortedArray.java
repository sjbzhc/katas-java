package leetcode;

/*
* Time: O(log n)
* Space: O(1)
* */

public class FindMinimumInRotatedSortedArray {
    public int findMin(int[] nums) {
        int res = Integer.MAX_VALUE;
        int l = 0;
        int r = nums.length - 1;

        // we constrained as much as necessary, so that we are in an increasing subarray
        while (l <= r) {
            if (nums[l] < nums[r]) {
                res = Math.min(res, nums[l]);
                break;
            }
            int m = (l + r) / 2;
            res = Math.min(res, nums[m]);
            // left side is not interrupted, so look on the right
            if (nums[m] >= nums[l]) {
                l = m + 1;
            // left side interrupted, look on the left
            } else {
                r = m - 1;
            }
        }
        return res;
    }
}
