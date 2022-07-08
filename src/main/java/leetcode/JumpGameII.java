package leetcode;

/*
 farthest will be the farthest we can get from l and r
 l is itself the previously farthest position, so we are maxing it out in each turn
 the result does not have to be a sequence farthest - farthest - farthest, so we check
 all possible options between l and r.
*  */

/*
* Time: O(n2)
* Space: O(1)
* */

public class JumpGameII {
    public int jump(int[] nums) {
        int res = 0;
        int l = 0;
        int r = 0;

        while (r < nums.length - 1) {

            int farthest = 0;
            for (int i=l; i<=r; i++) {
                farthest = Math.max(farthest, i + nums[i]);
            }
            l = r;
            r = farthest;
            res++;
        }
        return res;
    }
}
