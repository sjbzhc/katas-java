package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class LeastNumberUniqueIntegers {
    public int findLeastNumOfUniqueInts(int[] arr, int k) {
        List<int[]> frequencyList = createFrequencyList(arr);
        int count = frequencyList.size();
        int i=0;
        int n = arr.length;

        while (i<n && k >= 0) {
            if (k < frequencyList.get(i)[1]) {
                return count;
            } else {
                k -= frequencyList.get(i)[1];
                count--;
            }
            i++;
        }
        return count;
    }

    private List<int[]> createFrequencyList(int[] arr) {
        List<int[]> result = new ArrayList<>();
        Arrays.sort(arr);
        int value = 0;
        int count = 0;
        for (int i =0; i< arr.length; i++) {
            if (i == 0) {
                value = arr[i];
                count++;
            }
            
            if (i > 0) {
                if (arr[i] == arr[i-1]) {
                    count++;
                } else {
                    result.add(new int[]{value, count});
                    value = arr[i];
                    count = 1;
                }
            }
        }
        result.add(new int[]{value, count});
        return result.stream().sorted((a, b) -> a[1] - b[1]).collect(Collectors.toList());
    }
}
