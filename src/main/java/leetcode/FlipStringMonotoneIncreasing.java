package leetcode;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/*
* Time: O(N)
* Space: O(N)
*
* Each node's state is defined by 2 vars (current char and if all chars of far are 0).
* Every time we flip, we add a 1.
* This leads to 4 options:
*   - All zeroes and current char 0 -> min of flipping or not flipping, flip to transform 0 to 1
*   - All zeroes and current char 1 -> min of flipping or not flipping, flip to transform 1 to 0
*   - Not all zeroes and current char 0 -> flip to transform to 1
*   - Not all zeroes and current chat 1 -> no flip necessary
*
* */

public class FlipStringMonotoneIncreasing {

    Map<Pair, Integer> cache = new HashMap<>();
    String s;

    public int minFlipsMonoIncr(String s) {
        this.s = s;
        return dfs(0, true);
    }

    public int dfs(int i, boolean zeroesSoFar) {
        if (i >= s.length()) return 0;

        Pair k = new Pair(i, zeroesSoFar);

        if (cache.containsKey(k)) return cache.get(k);

        // All zeroes and current char == 0
        if (zeroesSoFar && s.charAt(i) == '0') {
            cache.put(k, Math.min(1 + dfs(i + 1, false), dfs(i + 1, zeroesSoFar)));
            // All zeroes and current char == 1
        } else if (zeroesSoFar && s.charAt(i) == '1') {
            // 1 + dfs comes from swap
            cache.put(k, Math.min(1 + dfs(i + 1, zeroesSoFar), dfs(i + 1, false)));
            // Not all zeroes and current char == 1
        } else if (!zeroesSoFar && s.charAt(i) == '1') {
            cache.put(k, dfs(i + 1, zeroesSoFar));
            // Not all zeroes and current char == 0, so we need swap (1 + dfs)
        } else {
            cache.put(k, 1 + dfs(i + 1, zeroesSoFar));
        }

        return cache.get(k);
    }

    class Pair {
        int i;
        boolean mono;

        public Pair(int i, boolean mono) {
            this.i = i;
            this.mono = mono;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Pair pair = (Pair) o;
            return i == pair.i && mono == pair.mono;
        }

        @Override
        public int hashCode() {
            return Objects.hash(i, mono);
        }
    }
}

/*
 * Time: O(N)
 * Space: O(N)
 *
 * We separate for each element the left and right side.
 *
 * In the left side, which is dp, we count the number of ones up to i, since we want to have only 0s on the left.
 *
 * In the right side (including the current element) we count the number of zeros we have.
 * The calculation is (n-i) - (dp[n] - dp[i])
 *   n-i: total possible number of zeros
 *   dp[n] - dp[i] number of ones in the range
 *
 * */

//    public int minFlipsMonoIncr(String s) {
//        int n = s.length();
//        int[] dp = new int[n + 1];
//
//        for (int i=1; i<=n;i++) {
//            dp[i] = dp[i-1] + (s.charAt(i-1) == '1' ? 1 : 0);
//        }
//
//        int ans = Integer.MAX_VALUE;
//
//        for (int i =0; i<=n;i++) {
//            ans = Math.min(ans, dp[i] + (n - i) - (dp[n] - dp[i]));
//        }
//        return ans;
//    }
