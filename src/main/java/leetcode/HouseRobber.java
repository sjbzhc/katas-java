package leetcode;

/*
* el_1: n-1 element
* el_2: n-2 element
*
* 1   2   3   1
* 1 trivial
* 1   2   max of 2 + el_2 (none in this case) and el_1
* 1   2   4 max of (3 + el_1 (1) or el_2(2))
* 1   2   4   4   max of (1 + el_1 (2) and el_1 (4))
* */

/*
* Time: O(n)
* Space: O(1)
* */

public class HouseRobber {
    public int rob(int[] nums) {
        int one = 0;
        int two = 0;
        // [one, two, i, i + 1, i + 2, ..., n]
        for (int i=0; i<nums.length; i++) {
            int temp = Math.max(one + nums[i], two);
            one = two;
            two = temp;
        }
        return two;
    }
}
