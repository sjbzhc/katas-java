package leetcode;

/*
* We take a look at the string from the right
* We try to find the rightmost character in the string. If it's not repeated, then we need i/2 moves
* to move it to the middle
*
* If it's repeated, we need i (i = s.indexOf(c)) moves to bring it in place, since we need to bring the second
* char from i to 0
*
* We then remove the char (or chars if repeated) from the string
* */

public class MinimumNumberOfMovesToMakePalindrome {
    public int minMovesToMakePalindrome(String s) {
        int res = 0;
        while (s.length() > 0) {
            int i = s.indexOf(s.charAt(s.length() - 1));
            // character is not repeated, so move to the middle
            if (i == s.length() - 1) res += i / 2;
            else {
                res += i;
                // remove second instance of char
                s = s.substring(0, i) + s.substring(i + 1);
            }
            // remove first instance of char
            s = s.substring(0, s.length() - 1);
        }
        return res;
    }
}
