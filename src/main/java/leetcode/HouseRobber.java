package leetcode;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/*
* 0 1 2 3
* 1 2 3 1
* root
*   rob(0):1
*       rob(2):rob(0)+3=1+3=4 <- we want to memoize this call to rob(0)
*       rob(3):rob(0)+1=1+2=3
*   rob(1):2
*       rob(3):2+1=3
*
* This translates to:
* rob = max(rob(0) + rob(2:n), rob(1:n))
* We can do it recursively my returning that relationship directly
* Memo builds on top, with i >= n returning 0, as not valid
* Dp builds the solution progressively and we only need the last 2 entries in dp to construct the next one
* so dp[0] and dp[1] are trivial, dp[2] is max of (dp[0] + num[2] or dp[1]) -> up until dp[n-1]
* */

/*
* Time: O(n)
* Space: O(1)
* */

public class HouseRobber {

    public int robRecursive(int[] nums) {
        if (nums.length == 0) return 0;
        if (nums.length == 1) return nums[0];
        return Math.max(
                rob(Arrays.copyOfRange(nums, 0, 1)) + rob(Arrays.copyOfRange(nums, 2, nums.length)),
                rob(Arrays.copyOfRange(nums, 1, nums.length))
        );
    }

    int[] nums;
    Map<Integer, Integer> map = new HashMap<>();
    public int robMemo(int[] nums) {
        this.nums = nums;
        return helper(0);

    }

    public int helper(int i) {
        if (i >= nums.length) return 0;
        if (map.containsKey(i)) return map.get(i);
        int val = Math.max(
                nums[i] + helper(i + 2),
                helper(i + 1)
        );
        map.put(i, val);
        return map.get(i);
    }



    public int rob(int[] nums) {
        int one = 0;
        int two = 0;
        for (int i=0; i<nums.length; i++) {
            int temp = Math.max(one + nums[i], two);
            one = two;
            two = temp;
        }
        return two;
    }
}
