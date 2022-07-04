package leetcode;

/*
* Time: O(n)
* Space: O(1)
* */

public class MaxProduct {
    public int maxProduct(int[] nums) {
        int res = Integer.MIN_VALUE;
        for (int num : nums) res = Math.max(num, res);

        int currentMin = 1;
        int currentMax = 1;

        for (int num : nums) {
            if (num == 0) {
                currentMax = 1;
                currentMin = 1;
                continue;
            }
            int tmp = currentMax * num;
            currentMax = Math.max(Math.max(currentMax * num, currentMin * num), num);
            currentMin = Math.min(Math.min(tmp, currentMin * num), num);
            res = Math.max(res, currentMax);
        }

        return res;
    }
}
