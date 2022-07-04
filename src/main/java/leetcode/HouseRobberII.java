package leetcode;

/*
* Time: O(n)
* Space: O(1)
* */

public class HouseRobberII {
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
