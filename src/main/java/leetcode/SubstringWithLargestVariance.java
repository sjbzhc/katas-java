package leetcode;

/*
* Time: O(n)
* Space: O(n)
* */

import java.util.HashSet;
import java.util.Set;

public class SubstringWithLargestVariance {
    public int largestVariance(String s) {
        int ans = 0;
        Set<Integer> set = new HashSet<>();
        for (char c : s.toCharArray()) {
            set.add(c - 'a');
        }

        for (int rev=1; rev<=2; rev++) {
            for (int a = 0; a < 26; a++) {
                for (int b = 0; b < 26; b++) {
                    if (a == b || !set.contains(a) || !set.contains(b)) continue;
                    int cntA = 0;
                    int cntB = 0;

                    for (char c : s.toCharArray()) {
                        int charNum = c - 'a';
                        if (a == charNum) cntA++;
                        if (b == charNum) cntB++;

                        // In the complementary loop where a anb b switch places, cntA will be larger, so we are
                        // not interested in this case for now
                        if (cntA < cntB) {
                            cntA = 0;
                            cntB = 0;
                        }
                        if (cntA > 0 && cntB > 0) {
                            ans = Math.max(ans, cntA - cntB);
                        }
                    }
                }
            }
            // handle abbbb
            s = reverse(s);
        }
    return ans;
    }

    private String reverse(String s) {
        StringBuilder sb = new StringBuilder(s);
        sb.reverse();
        return sb.toString();
    }
}
