package leetcode;

import java.util.Arrays;

/*
* https://leetcode.com/problems/rank-teams-by-votes/
* Time: O(n): with n number of rows (votes) and c number of columns (single vote values);
*   O(n) = O(26 + n*c + 26*log(26c) + c)
* */
public class RankTeams {
    public String rankTeams(String[] votes) {
        int len = votes[0].length();

        int[][] ranks = new int[26][len + 1];

        for (int i=0; i<26; i++) {
            ranks[i][len] = i;
        }

        for (String vote : votes) {
            for (int i=0; i<len;i++) {
                char c = vote.charAt(i);
                ranks[c - 'A'][i]++;
            }
        }

        Arrays.sort(ranks, (a, b) -> {
           for (int i=0; i<len; i++) {
               if (a[i] > b[i]) return -1;
               if (a[i] < b[i]) return 1;
           }
           return 0;
        });

        StringBuilder sb = new StringBuilder();

        for (int i=0; i<len; i++) {
            sb.append((char) ('A' + ranks[i][len]));
        }

        return sb.toString();
    }
}
