package leetcode;

/*
* Time: O(n)
* Space: O(1)
* */

public class Atoi {
    public int myAtoi(String s) {
        int sign = 1;
        int res = 0;
        int i = 0;
        int n = s.length();

        while (i < n && s.charAt(i) == ' ') i++;

        // sign = +1, if it's positive number, otherwise sign = -1 if - present.
        // If none present, remain at + by default
        if (i<n && s.charAt(i) == '+') {
            sign = 1;
            i++;
        } else if (i<n && s.charAt(i) == '-') {
            sign = -1;
            i++;
        }

        while (i <n && Character.isDigit(s.charAt(i))) {
            int digit = s.charAt(i) - '0';

            // Check overflow and underflow conditions.
            if (
                    res > Integer.MAX_VALUE / 10 ||
                    res == Integer.MAX_VALUE / 10 && digit > Integer.MAX_VALUE % 10
            ) {
                return sign == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
            }

            res = res * 10 + digit;
            i++;
        }

        return sign * res;
    }
}
