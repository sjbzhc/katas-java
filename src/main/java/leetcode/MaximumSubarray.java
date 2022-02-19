package leetcode;

public class MaximumSubarray {
    public int maxSubArray(int[] nums) {
        int currentSubarray = nums[0];
        int max = nums[0];

        for (int i=1;i<nums.length;i++) {
            int num = nums[i];
            currentSubarray = Math.max(num, currentSubarray + num);
            max = Math.max(currentSubarray, max);
        }

        return max;
    }
}
