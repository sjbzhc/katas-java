package leetcode;

import java.util.PriorityQueue;

/*
* Time: O(n log n)
* Space: O(n)
* */

public class LongestContinuousSubarray {
    /*
    * Store the value and index on the queues
    * if the difference between the max and min values is larger than the limit, there won't be a valid pair
    * on the window until fixing.
    *
    * The issue lies on the smallest of the indices present at the top of the queues. We set l to be that index + 1.
    * The fix is to remove all elements from both queues that have an index smaller than l.
    * */
    public int longestSubarray(int[] nums, int limit) {
        PriorityQueue<int[]> min = new PriorityQueue<>((a,b) -> a[0] - b[0]);
        PriorityQueue<int[]> max = new PriorityQueue<>((a,b)-> b[0] - a[0]);
        int l=0;
        int res = 0;

        for (int r=0; r<nums.length; r++) {

            max.add(new int[]{nums[r], r});
            min.add(new int[]{nums[r], r});

            while (max.peek()[0] - min.peek()[0] > limit) {

                l = Math.min(max.peek()[1], min.peek()[1]) + 1;

                while (min.peek()[1] < l) min.poll();
                while (max.peek()[1] < l) max.poll();

            }

            res = Math.max(r - l + 1, res);
        }
        return res;
    }
}
