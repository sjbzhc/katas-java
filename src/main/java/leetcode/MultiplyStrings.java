package leetcode;

import java.util.ArrayList;
import java.util.List;

/*
* Time: O(mn)
* Space: O(m+n)
*
* */

public class MultiplyStrings {
    public String multiply(String num1, String num2) {
        if (num1.equals("0") || num2.equals("0")) return "0";


        StringBuilder sb1 = new StringBuilder(num1);
        StringBuilder sb2 = new StringBuilder(num2);
        sb1.reverse();
        sb2.reverse();

        int n = sb1.length() + sb2.length();

        StringBuilder res = new StringBuilder();

        for (int i=0; i< n; i++) {
            res.append(0);
        }

        for (int i=0; i<sb1.length(); i++) {
            for (int j=0; j<sb2.length(); j++) {
                int currentIndex = i + j;
                int digit1 = sb1.charAt(i) - '0';
                int digit2 = sb2.charAt(j) - '0';

                int carry = res.charAt(currentIndex) - '0';
                int multiplication = digit1 * digit2 + carry;

                char digitChar = (char) (multiplication % 10 + '0');
                res.setCharAt(currentIndex, digitChar);

                int newCarry = (res.charAt(currentIndex + 1) - '0') + multiplication / 10;
                char digitCarry = (char) (newCarry + '0');
                res.setCharAt(currentIndex + 1, digitCarry);
            }
        }

        if (res.charAt(res.length() - 1) == '0') {
            res.deleteCharAt(res.length() - 1);
        }

        res.reverse();
        return res.toString();
    }
}
