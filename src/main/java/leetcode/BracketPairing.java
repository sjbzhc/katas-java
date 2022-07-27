package leetcode;

/*
There are four types of brackets: round (), square [], curly {},
and angle <>. A bracket sequence is defined to be valid as follows:

• An empty sequence is valid.

• If X is a valid bracket sequence, then pXq is a valid bracket sequence, where p is an open bracket,
  q is a close bracket, and p, q are of the same type.

• If X and Y are valid bracket sequences, then the concatenation of X and Y , Z = XY, is a valid bracket sequence.

You have a bracket sequence in which some brackets are given, but the others are unknown and
represented by question marks (‘?’). You shall fill in each unknown bracket using the four types of
brackets described above and obtain a valid bracket sequence. How many different valid bracket
sequences can you obtain?

* */

import java.util.Map;

public class BracketPairing {
    public static long multiplier(char left, char right) {
        if (left == '?' && right == '?') {
            return 4;
        }

        Map<Character, Character> complements = Map.of(
                '(', ')',
                '<', '>',
                '[', ']',
                '{', '}'
        );

        if (complements.containsKey(left) && right == '?') {
            return 1;
        }
        if (complements.containsValue(right) && left == '?') {
            return 1;
        }

        return complements.containsKey(left) && complements.get(left) == right ? 1 : 0;
    }

    public long match(String line) {
        int n = line.length();
        long[][] dp = new long[n+1][n+1];
        for (int i = 0; i < dp.length; ++i) {
            for (int j = 0; j < dp[i].length; ++j) {
                // fill with ones below diagonal
                if (j < i) {
                    dp[i][j] = 1;
                }
            }
        }

        for (int len = 2; len <= n; len++) {
            for (int i = 0; i < n; i++) {
                int j = i + len - 1;
                if (j >= n) break;
                for (int k = i+1; k <= j; ++k) {
                    dp[i][j] += (multiplier(line.charAt(i), line.charAt(k)) * dp[i+1][k-1]) * dp[k+1][j];
                }
            }
        }
        return dp[0][n-1];
    }
}
