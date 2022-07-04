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

    /*
     * Time: O(n)
     * Space: O(1)
     * */
    public int maxSubArrayGreedy(int[] nums) {
        int currentSubarray = 0;
        int max = Integer.MIN_VALUE;

        for (int num : nums) {
            if (currentSubarray < 0) currentSubarray = 0;
            currentSubarray += num;
            max = Math.max(max, currentSubarray);
        }
        return max;
    }
}
