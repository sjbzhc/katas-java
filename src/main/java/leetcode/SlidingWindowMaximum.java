package leetcode;

import java.util.ArrayDeque;
import java.util.PriorityQueue;

/*
* Deque:
* first -> nodes -> last
* insert first/remove first -> 3 -> 2 -> 1 <- add last/remove last
*
* We keep the indexes of the nums array in the deque.
*
* Clean deque keeps only the indexes of the current window and removes the indexes of the elements smaller than the
* currently checked element, as they won't be the maximum.
*
* In cleanDeque, the if ensures that the queue only hold indexes encompassed by the current window. Since we are always
* adding from the right, this can only happen after k inserts the earliest.
*
* The while loop makes sure to delete every element from the queue that is smaller than the current element being indexed
* by i.
* */

public class SlidingWindowMaximum {
    ArrayDeque<Integer> dq = new ArrayDeque<>();
    int[] nums;

    public void cleanDeque(int i, int k) {
        if (!dq.isEmpty() && dq.getFirst() == (i - k)) {
            dq.removeFirst();
        }

        while(!dq.isEmpty() && nums[i] > nums[dq.getLast()]) {
            dq.removeLast();
        }
    }



    public int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length;

        if (n*k == 0) return new int[0];
        if (k == 1) return nums;

        this.nums = nums;
        int maxId = 0;

        for (int i=0; i<k;i++) {
            cleanDeque(i, k);
            dq.addLast(i);

            if (nums[i] > nums[maxId]) {
                maxId = i;
            }
        }

        int[] output = new int[n-k+1];
        output[0] = nums[maxId];

        for (int i=k; i<n;i++) {
            cleanDeque(i, k);
            dq.addLast(i);
            output[i-k+1] = nums[dq.getFirst()];
        }
        return output;
    }

    public int[] maxSlidingWindowPQ(int[] nums, int k) {
        int n = nums.length;
        int[] result = new int[n-k+1];
        int index = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>(3, (a,b) -> b - a);

        for (int i=0;i<k;i++) {
            pq.add(nums[i]);
        }


        for (int i=k;i<n;i++) {
            result[index] = pq.peek();
            pq.add(nums[i]);
            index++;
        }

        result[index] = pq.peek();

        return result;
    }
}
