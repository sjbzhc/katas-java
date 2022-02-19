package leetcode;

public class SearchInRotatedSortedArray {
    int target;
    public int search(int[] nums, int target) {
        this.target = target;
        return bs(nums, 0, nums.length - 1);
    }

    private int bs(int[] nums, int low, int high) {
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (nums[mid] == target) return mid;
            // the first half is not rotated
            if (nums[mid] >= nums[low]) {
                // target is within the not rotated half, constrain from low to mid - 1
                if (target >= nums[low] && target < nums[mid]) {
                    high = mid - 1;
                // target is on the rotated half, constrain from mid + 1 to high
                } else {
                    low = mid + 1;
                }
            // the second half is not rotated
            } else {
                // target is in the not rotated half, constrain from mid + 1 to high
                if (target <= nums[high] && target > nums[mid]) {
                    low = mid + 1;
                // target is in the rotate half, constrain from low to mid - 1
                } else {
                    high = mid - 1;
                }
            }
        }
        return -1;
    }
}
