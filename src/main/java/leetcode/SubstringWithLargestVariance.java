package leetcode;

/*
* Time: O(n3)
* Space: O(n)
* */

public class SubstringWithLargestVariance {
    public int largestVariance(String s) {
        int [] freq = new int[26];

        for(int i = 0 ; i < s.length() ; i++) {
            freq[s.charAt(i) - 'a']++;
        }

        int maxVariance = 0;
        for (int a = 0; a < 26; a++) {
            for (int b = 0; b < 26; b++) {
                int remainingA = freq[a];
                int remainingB = freq[b];
                if(a == b || remainingA == 0 || remainingB == 0) continue;

                // run Kadane's on each possible character pairs (A & B)
                int currAFreq = 0;
                int currBFreq = 0;

                for (int i = 0 ; i < s.length(); i++) {
                    int c =  s.charAt(i) - 'a';

                    if (c == a) {
                        currAFreq++;
                        remainingA--;
                    }
                    if (c == b) currBFreq++;

                    if (currAFreq > 0) maxVariance = Math.max(maxVariance, currBFreq - currAFreq);

                    // Since we calculate max as freqB - freqA, no need to continue if already negative, so we reset
                    if (currAFreq > currBFreq &&  remainingA >= 1) {
                        currAFreq = 0;
                        currBFreq = 0;
                    }
                }
            }
        }

        return maxVariance;
    }
}
