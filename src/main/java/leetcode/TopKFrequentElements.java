package leetcode;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

/*
* Time: O(n log k)
* Space: O(n + k)
* */

public class TopKFrequentElements {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();

        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> map.get(a) - map.get(b));

        for (int n : map.keySet()) {
            pq.add(n);
            if (pq.size() > k) {
                pq.poll();
            }
        }

        int[] res = new int[k];
        for (int i=0; i<k;i++) {
            res[i] = pq.poll();
        }
        return res;
    }
}
