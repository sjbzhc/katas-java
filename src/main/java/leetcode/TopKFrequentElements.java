package leetcode;

import java.util.*;

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

    /*
    * Time: Avg O(n), Worst case O(n2)
    * Space: O(n)
    * */

    int[] unique;
    Map<Integer, Integer> count;
    public int[] topKFrequentLinear(int[] nums, int k) {
        count = new HashMap<>();
        for (int num : nums) {
            count.put(num, count.getOrDefault(num, 0) + 1);
        }
        int n = count.size();
        unique = new int[n];

        int i = 0;

        for (int num : count.keySet()) {
            unique[i] = num;
            i++;
        }

        quickFind(0, n - 1, n - k);

        return Arrays.copyOfRange(unique, n - k, n);
    }

    private void quickFind(int left, int right, int kIndex) {
        if (left == right) return;

        Random rd = new Random();
        int pivotIndex = left + rd.nextInt(right - left);

        pivotIndex = partition(left, right, pivotIndex);
        if(pivotIndex == kIndex) return;
        else if (kIndex < pivotIndex) quickFind(left, pivotIndex - 1, kIndex);
        else quickFind(pivotIndex + 1, right, kIndex);
    }

    private int partition(int left, int right, int pivotIndex) {
        int pivotFreq = count.get(unique[pivotIndex]);

        swap(pivotIndex, right);

        int index = left;
        for (int i=left; i<= right; i++) {
            if (count.get(unique[i]) < pivotFreq) {
                swap(i, index);
                index++;
            }
        }
        swap(index, right);
        return index;
    }


    private void swap(int left, int right) {
        int temp = unique[left];
        unique[left] = unique[right];
        unique[right] = temp;
    }
}
