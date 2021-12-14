package leetcode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class SumSubarrayMinimums {
    List<Integer> subarrays = new ArrayList<>();


    public int sumSubarrayMins(int[] arr) {
        generateSubarrays(arr, 0, 0);
        return subarrays.stream().reduce(Integer::sum).orElse(0);
    }

    private void generateSubarrays(int[] arr, int start, int end) {
        for (int i =0; i<arr.length;i++) {
            for (int j=i;j<arr.length;j++) {
                int currentMin = Integer.MAX_VALUE;
                for (int k=i;k<=j;k++) {
                    if (arr[k] < currentMin) {
                        currentMin = arr[k];
                    }
                }
                if (currentMin != Integer.MAX_VALUE) {
                    subarrays.add(currentMin);
                }
            }
        }
    }
}
