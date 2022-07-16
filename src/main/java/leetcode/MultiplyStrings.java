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

        List<Integer> res = new ArrayList<>();
        for (int i=0; i<n;i++) {
            res.add(0);
        }

        for (int i=0; i<sb1.length(); i++) {
            for (int j=0; j<sb2.length(); j++) {
                int currentIndex = i + j;
                int digit1 = sb1.charAt(i) - '0';
                int digit2 = sb2.charAt(j) - '0';

                int carry = res.get(currentIndex);
                int multiplication = digit1 * digit2 + carry;

                res.set(currentIndex, multiplication % 10);

                int newCarry = res.get(currentIndex + 1) + multiplication / 10;;
                res.set(currentIndex + 1, newCarry);
            }
        }

        if (res.get(res.size() - 1) == 0) {
            res.remove(res.size() - 1);
        }

        StringBuilder sb = new StringBuilder();
        for (int i=res.size() - 1; i>=0; i--) {
            sb.append(res.get(i));
        }
        return sb.toString();
    }
}
