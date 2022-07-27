package leetcode;

/*
* Time: O(n)
* Space: O(1)
* */

public class SingleNumber {
    public int singleNumber(int[] nums) {
        int res = 0;
        for (int num : nums) {
            res = res ^ num;
        }
        return res;
    }
}
