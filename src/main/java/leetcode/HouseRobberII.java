package leetcode;

/*
* Time: O(n)
* Space: O(1)
* */

import java.util.HashMap;
import java.util.Map;

public class HouseRobberII {

    Map<Integer, Integer> cache = new HashMap<>();
    int[] nums;
    public int robRecursive(int[] nums) {
        this.nums = nums;
        int left =  helper(0, nums.length - 1);
        int right = helper(1, nums.length);
        return Math.max(left, right);
    }

    public int helper(int l, int r) {
        int one = 0;
        int two = 0;

        for (int i=l; i<r; i++) {
            int tmp = Math.max(two, one + nums[i]);
            one = two;
            two = tmp;
        }
        return two;
    }

    /*
     * Time: O(n)
     * Space: O(1)
     * */

    public int rob(int[] nums) {
        if(nums.length == 0) return nums[0];
        int left =  robHouse(0, nums.length - 1, nums);
        int right = robHouse(1, nums.length, nums);

        return Math.max(left, right);
    }

    private int robHouse(int l, int r, int[] nums) {
        int one = 0;
        int two = 0;
        // {one, two, n, n +1, ...}
        for (int i=l; i<r;i++) {
            int temp = Math.max(nums[i] + one, two);
            one = two;
            two = temp;
        }
        return two;
    }
}
