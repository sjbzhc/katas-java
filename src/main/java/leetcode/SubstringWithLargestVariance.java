package leetcode;

/*
* Time: O(n)
* Space: O(n)
* */

public class SubstringWithLargestVariance {
    public int largestVariance(String s) {
        int ans = 0;
        int[] freq = new int[26];
        for(int i = 0 ; i < s.length() ; i++) {
            freq[s.charAt(i) - 'a']++;
        }

        for (int rev=1; rev<=2; rev++) {
            for (int a = 0; a < 26; a++) {
                for (int b = 0; b < 26; b++) {
                    if (a == b || freq[a] == 0 || freq[b] == 0) continue;
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
        int l=0;
        int r=s.length() - 1;
        char[] charArr = s.toCharArray();
        while (l<r) {
            char tmp = charArr[l];
            charArr[l] = charArr[r];
            charArr[r] = tmp;
            l++;
            r--;
        }
        return String.valueOf(charArr);
    }
}
