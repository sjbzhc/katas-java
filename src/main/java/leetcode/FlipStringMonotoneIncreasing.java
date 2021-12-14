package leetcode;

/*
* We separate for each element the left and right side.
*
* In the left side, we count the number of ones, since we want to have only 0s.
*
* In the right side (including the current element) we count the 1s.
* The calculation is (n-j) - (P[n] - P[j]) since we are interested in 0s, not 1s, and P counts 1s.
*
* We first take the range and subtract the delta of 1s between the last and current elements (which is the number
* of 1s in the range).
*
* If the range is 3, and we had 3 ones at the start and end of the range, it means we don't have any new 1s, so we have
* 3 zeros.
* */

public class FlipStringMonotoneIncreasing {
    public int minFlipsMonoIncr(String s) {
        int n = s.length();
        int[] p = new int[n + 1];

        for (int i=0; i<n;i++) {
            p[i + 1] = p[i] + (s.charAt(i) == '1' ? 1 : 0);
        }

        int ans = Integer.MAX_VALUE;

        for (int j =0; j<=n;j++) {
            ans = Math.min(ans, p[j] + (n - j) - (p[n] - p[j]));
        }
        return ans;
    }
}
