package leetcode;

/*
* Time: O(n)
* Space: O(1)
* */

public class CountUniqueCharactersOfAllSubstrings {
    public int uniqueLetterString(String s) {
        int[] prevContribution = new int[26];
        int[] contribution = new int[26];
        int res = 0;
        for (int i = 0; i < s.length(); i++) {
            int curr = s.charAt(i) - 'A';

            // i + 1 refers to the number of substrings that the current char would contribute to.
            // if we are at i=5, it would be present in 6 substrings
            // we subtract prevContribution in case the char is repeated to avoid double count
            contribution[curr] = i + 1 - prevContribution[curr];

            for (int j = 0; j < 26; j++) {
                res += contribution[j];
            }

            prevContribution[curr] = i + 1;
        }
        return res;
    }
}
