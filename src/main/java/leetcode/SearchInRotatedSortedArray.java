package leetcode;


/*
* Time: O(log n)
* Space: O(1)
* */
public class SearchInRotatedSortedArray {
    int target;
    public int search(int[] nums, int target) {
        int l = 0;
        int r = nums.length - 1;

        while (l <= r) {
            int m = (l + r) / 2;
            if (nums[m] == target) return m;

            // left half is not interrupted
            if (nums[l] <= nums[m]) {
                // conditions to look on the right
                if (target > nums[m] || target < nums[l]) {
                    l = m + 1;
                // we stay on the left
                } else {
                    r = m - 1;
                }
            // left half is interrupted <-> right half is not interrupted
            } else {
                // conditions to look on the left
                if (target > nums[r] || target < nums[m]) {
                    r = m - 1;
                // we stay on the right
                } else {
                    l = m + 1;
                }
            }
        }
        return -1;
    }
}