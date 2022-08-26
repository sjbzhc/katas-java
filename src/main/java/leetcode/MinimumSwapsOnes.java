package leetcode;

/*
*
* We are checking a window of size ones
*
* Time: O(n)
* Space: O(1)
* */

public class MinimumSwapsOnes {
    public int minSwaps(int[] nums) {
        int len = nums.length;
        int ones = 0;
        int onesInWindow = 0;
        int min = Integer.MAX_VALUE;

        for (int n : nums) ones += n;

        if (len == ones || ones == 0) return 0;

        for (int k = 0; k < ones; k++) {
            if (nums[k] == 0) onesInWindow++;
        }

        for (int i=1; i<len; i++) {
            // circular check: j is the element at the end of the subarray
            int j = (i + ones - 1) % len;
            if (nums[j] == 0 && nums[i - 1] == 1) onesInWindow++;
            else if (nums[j] == 1 && nums[i - 1] == 0) onesInWindow--;
            min = Math.min(min, onesInWindow);
        }
        return min;
    }
}
