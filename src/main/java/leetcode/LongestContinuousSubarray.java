package leetcode;

import java.util.PriorityQueue;

/*
* Time: O(n log n)
* Space: O(n)
* */

public class LongestContinuousSubarray {
    public int longestSubarray(int[] nums, int limit) {
        PriorityQueue<Integer> min = new PriorityQueue<>();
        PriorityQueue<Integer> max = new PriorityQueue<>((a,b)->Integer.compare(b,a));
        int l=0;
        int r=0;
        int res = 0;
        while (r < nums.length) {
            min.add(nums[r]);
            max.add(nums[r]);
            while(Math.abs(max.peek() - min.peek()) > limit){
                min.remove(nums[l]);
                max.remove(nums[l]);
                l++;
            }
            res = Math.max(r - l + 1,res);
            r++;
        }
        return res;
    }
}
