package leetcode;

/*
* helper function:
* return of first if is only used within helper function. Second if actually returns to main function
* */

enum Index {
    GOOD, BAD, UNKNOWN
}

public class JumpGame {
    Index[] memo;

    public boolean canJumpBacktrack(int[] nums) {
        return canJumpFromPosition(0, nums);
    }

    private boolean canJumpFromPosition(int position, int[] nums) {
        if (position == nums.length - 1) return true;

        int furthestJump = Math.min(nums.length - 1, position + nums[position]);

        for (int nextPosition = position + 1; nextPosition <= furthestJump; nextPosition++) {
            if (canJumpFromPosition(nextPosition, nums)) return true;
        }

        return false;
    }

    public boolean canJumpDp(int[] nums) {
        memo = new Index[nums.length];
        for (int i=0; i< memo.length; i++) {
            memo[i] = Index.UNKNOWN;
        }
        memo[memo.length - 1] = Index.GOOD;
        return canJumpFromPositionDp(0, nums);
    }

    private boolean canJumpFromPositionDp(int position, int[] nums) {
        if (memo[position] != Index.UNKNOWN) return memo[position] == Index.GOOD;

        int furthestJump = Math.min(nums.length - 1, position + nums[position]);

        for (int nextPosition = position + 1; nextPosition <= furthestJump; nextPosition++) {
            if (canJumpFromPositionDp(nextPosition, nums)) {
                memo[position] = Index.GOOD;
                return true;
            }
        }

        memo[position] = Index.BAD;
        return false;
    }

    /*
    * Time: O(n2)
    * Space: O(n)
    *
    * memo[i] means that the last index can be reached starting from i
    * We go backwards and for each index i, we try all indices from j to furtherstJump. If any of them is true
    * we can break, since with the value of memo[j] being true, it means the end can be reached
    * */

    public boolean canJumpDpBu(int[] nums) {
        boolean[] memo = new boolean[nums.length];
        memo[memo.length - 1] = true;

        for (int i = nums.length - 2; i >= 0; i--) {
            // nums.length - 1 to avoid indices outside of nums
            int furthestJump = Math.min(i + nums[i], nums.length - 1);
            for (int j = i + 1; j <= furthestJump; j++) {
                // if we get to j, it means we started from i
                if (memo[j]) {
                    // if memo[j] is true for any j between i and furthestJump
                    // we already know that we can reach the last index from i, so no need
                    // to check other positions
                    memo[i] = true;
                    break;
                }
            }
        }

        return memo[0];
    }

    /*
    * Similar implementation to JumpGame II
    * Time: O(n)
    * Space: O(1)
    * */
    public boolean canJump(int[] nums) {
        int n = nums.length;

        // The farthest index we can reach at any point
        int farthest = 0;

        // Iterate through the array
        for (int i = 0; i < n; i++) {
            // If the current position is beyond the farthest reachable position, return false
            if (i > farthest) return false;

            // Update the farthest reachable index from this position
            farthest = Math.max(farthest, i + nums[i]);

            // If we can reach or surpass the last index, return true
            if (farthest >= n - 1) return true;
        }

        // If the loop finishes and we couldn't reach the last index, return false
        return false;
    }

    /*
    * Time: O(n)
    * Space: O(n)
    *
    * */

    public boolean canJumpGreedy(int[] nums) {
        int goal = nums.length - 1;

        for (int i = nums.length - 1; i >= 0; i--) {
            // i + jump length
            if (i + nums[i] >= goal) goal = i;
        }

        return goal == 0;
    }
}
