package leetcode;

public class FlipStringMonotoneIncreasing2 {
    public int minFlipsMonoIncr(String str) {
        int n = str.length();
        int[] p = new int[n + 1];

        for (int i=0; i<n;i++) {
            p[i+1] = p[i] + (str.charAt(i) == '1' ? 1 : 0);
        }
        int ans = Integer.MAX_VALUE;

        for (int j=0;j<=n;j++) {
            ans = Math.min(ans, p[j] + (n - j) - (p[n] - p[j]));
        }

        return ans;
    }
}
