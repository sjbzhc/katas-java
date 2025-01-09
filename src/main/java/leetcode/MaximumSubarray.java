package leetcode;


/*
* Time: O(n)
* Space: O(1)
*
* Kadane's algorithm
* Works by storing information of sub-problem
*
* In array:
*  0  1  2  3  4           S     0  1  2  3  4  5        S
* -2  1 -3  4 -1  2  1 -5  4    -2  1 -3  4 -1  2  1 -5  4
*                                               2        2
*             -1          -1                -1  2        1
*           4 -1           3              4 -1  2        5
*       -3  4 -1           0          -3  4 -1  2        2
*     1 -3  4 -1           1        1 -3  4 -1  2        3
* -2  1 -3  4 -1          -1    -2  1 -3  4 -1  2        1
*
* When looking at the sub-problem with at index 4, we see that the max sum (last col on left side) is 3.
* We carry this info for the next step (index 5), so we only need to consider what happens if:
*   We add one more value to that result (max of sub-array [4, -1] = 3 plus 2 of arr at index 5)
*   We ignore that result and use only the value at index 5 (2)
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
