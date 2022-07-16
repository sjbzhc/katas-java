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
    * */

    public boolean canJumpDpBu(int[] nums) {
        boolean[] memo = new boolean[nums.length];
        memo[memo.length - 1] = true;

        for (int i = nums.length - 2; i >= 0; i--) {
            int furthestJump = Math.min(i + nums[i], nums.length - 1);
            for (int j = i + 1; j <= furthestJump; j++) {
                // if we get to j, it means we started from i
                if (memo[j]) {
                    // we are creating a chain of true, in the best case, from 0 to end
                    memo[i] = true;
                    break;
                }
            }
        }

        return memo[0] == true;
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
