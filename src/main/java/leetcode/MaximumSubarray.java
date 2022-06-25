package leetcode;


/*
* Time: O(n)
* Space: O(1)
* */
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

    public int maxSubArrayGreedy(int[] nums) {
        int currentSubarray = 0;
        int max = Integer.MIN_VALUE;

        for (int i=0;i<nums.length;i++) {
            if (currentSubarray < 0) currentSubarray = 0;
            currentSubarray += nums[i];
            max = Math.max(max, currentSubarray);
        }
        return max;
    }
}
