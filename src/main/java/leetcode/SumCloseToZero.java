package leetcode;

import java.util.Arrays;

/*
* Time: O(n log n)
* Space: O(1)
* */

public class SumCloseToZero {
    public int[] findSum(int[] arr) {
        int n = arr.length;
        int l = 0;
        int r = n - 1;
        int sum;
        int currentSum;

        if (n < 2) return new int[]{-1, -1};

        Arrays.sort(arr);

        sum = Math.abs(arr[l] + arr[r]);
        int[] res = new int[]{arr[l], arr[r]};

        while(l < r) {
            currentSum = arr[l] + arr[r];
            if (Math.abs(currentSum) < Math.abs(sum)) {
                sum = currentSum;
                res = new int[]{arr[l], arr[r]};
            }
            if(currentSum < 0) l++;
            else r--;
        }

        return res;
    }
}
