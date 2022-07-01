package leetcode;

/*
* Time: O(n)
* Space: O(1)
* */

public class FindDuplicate {
    public int findDuplicate(int[] nums) {
        int slow = nums[0];
        int fast = nums[0];

        while (true) {
            slow = nums[slow];
            fast = nums[nums[fast]];

            if (slow == fast) break;
        }

        int slow2 = nums[0];

        while (true) {
            slow = nums[slow];
            slow2 = nums[slow2];
            if (slow == slow2) break;

        }
        return slow;
    }
}
