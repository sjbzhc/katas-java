package leetcode;

/*
* We record in last[] the last instance +1 (due to 0-based index) thus far for each character.
* A later position means that that character will be present in i+1 substrings. For example:
* String abcd. We know that d will be present in 4 substrings:
* abcd
*  bcd
*   cd
*    d
*
* In the next loop, even if we don't have d anymore, it's ok to still add it, as it will stay with the
* older index. So if the next char is e, we will have 5 substrings with e and 4 of those will contain d:
* abcde
*  bcde
*   cde
*    de
*     e
*
*
* Time: O(26 n)
* Space: O(26)
* */

public class TotalAppealOfString {
    public long appealSum(String s) {
        int last[] = new int[26];
        long res = 0;
        for (int i = 0; i < s.length(); ++i) {
            last[s.charAt(i) - 'a'] = i + 1;
            for (int j: last) {
                res += j;
            }
        }
        return res;
    }
}
