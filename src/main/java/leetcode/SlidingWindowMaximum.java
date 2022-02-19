package leetcode;

import java.util.ArrayDeque;
import java.util.PriorityQueue;

/*
* Deque / DP:
* Time: O(n)
* Space: O(n)
*
* Priority Queue:
* Time: O(n log k)
* Space: O(n - k)
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

    public int[] maxSlidingWindowDp(int[] nums, int k) {
        int n = nums.length;
        if (n == 0 || k == 0) return new int[0];
        if (k == 1) return nums;

        int[] left = new int[n];
        int[] right = new int[n];
        int[] res = new int[n-k+1];
        left[0] = nums[0];
        right[n-1] = nums[n-1];

        for (int i=1; i<n; i++) {
            if (i%k == 0) {
                left[i] = nums[i];
            } else {
                left[i] = Math.max(left[i-1], nums[i]);
            }

            int j = n - i - 1;
            if ((j+1) % k == 0) {
                right[j] = nums[j];
            } else {
                right[j] = Math.max(right[j+1], nums[j]);
            }
            int a = 1;
        }

        for (int i=0;i<res.length;i++) {
            res[i] = Math.max(left[i + k -1], right[i]);
        }

        return res;
    }
}
