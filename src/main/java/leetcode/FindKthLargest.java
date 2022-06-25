package leetcode;

import java.util.PriorityQueue;

/*
* Time: O((n-k) log k)
* Space: O(k)
* */
public class FindKthLargest {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> heap = new PriorityQueue<>((n1, n2) -> n1 - n2);

        for (int n: nums) {
            heap.add(n);
            if (heap.size() > k)
                heap.poll();
        }

        return heap.poll();
    }

    PriorityQueue<Integer> pq;
    int k;
    public void findKLargest(int k, int[] nums) {
        this.pq = new PriorityQueue<>(k, (n1, n2) -> n1 - n2);
        this.k = k;

        for (int num : nums) {
            pq.add(num);
        }

        while (pq.size() > k) {
            pq.poll();
        }
    }

    public int add(int val) {
        pq.add(val);
        if (pq.size() > k) {
            pq.poll();
        }

        return pq.peek();
    }
}
