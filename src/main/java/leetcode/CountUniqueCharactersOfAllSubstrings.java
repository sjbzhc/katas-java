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

            // Sum the contributions of all unique characters for the current index
            for (int cont: contribution) res += cont;

            prevContribution[curr] = i + 1;
        }
        return res;
    }
}

/*
 * Example
 * ABA
 * i=0, substring=A
 * curr=0
 * contribution[0] = 1
 * res += (1) => 1
 * prevContribution[0] = 1;
 *
 * i=1, substring=AB
 * curr=1
 * contribution[1] = 1 + 1 - (prevContribution[1] = 0) = 2
 * res += (1 from A) + (2 from AB) += 3 => 4 (res was 1 before)
 * prevContribution[0] = 2;
 *
 * i=2, substring=ABA
 * curr=0
 * contribution[1] = 2 + 1 - (prevContribution[0] = 1) = 2
 * res += (2 from A) + (2 from AB) += 4 => 8 (res was 4 before)
 * prevContribution[0] = 3;
 *
 * */
