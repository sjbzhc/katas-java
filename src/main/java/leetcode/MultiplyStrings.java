package leetcode;

import java.util.ArrayList;
import java.util.List;

/*
* Time: O(m2 + mn) n and m number of digits
* Space: O(m2 + mn)
*
* 123 * 12
*
*     123
*      12
*    ----
*     246
*    1230
*    ----
*    1476
* Use the reversed numbers.
* The multiplication is at most as long as m + n
* For each of the digits of the second number:
*   multiply with the fist number
*       add trailing zeroes, corresponding to the second number's digit's position currently being multiplied
*       in example above, the position of 1 (from 12) is 1, therefore, one 0 is added at it's end
*       then simply multiply
*   add to result
*       simply add, taking into consideration carry and with ternary value of 0 when a string's length is shorter
*
* remove trailing zeroes if present
* reverse
* */

public class MultiplyStrings {
    public String multiply(String num1, String num2) {
        if (num1.equals("0") || num2.equals("0")) {
            return "0";
        }

        StringBuilder firstNumber = new StringBuilder(num1);
        StringBuilder secondNumber = new StringBuilder(num2);

        firstNumber.reverse();
        secondNumber.reverse();

        int n = firstNumber.length() + secondNumber.length();

        List<Integer> ans = new ArrayList<>();

        for (int i=0; i<n; i++) {
            ans.add(0);
        }

        for (int i=0; i< secondNumber.length();i++) {
            ans = addStrings(multiplyOneDigit(firstNumber, secondNumber.charAt(i), i), ans);
        }

        if (ans.get(ans.size() - 1) == 0) {
            ans.remove(ans.size() - 1);
        }

        StringBuilder answer = new StringBuilder();

        for (int i=ans.size() -1; i>=0; i--) {
            answer.append(ans.get(i));
        }

        return answer.toString();

    }

    private List<Integer> addStrings(List<Integer> num1, List<Integer> num2) {
        ArrayList<Integer> ans = new ArrayList<>();
        int carry = 0;

        for (int i=0; i < num1.size() || i < num2.size(); i++) {
            int digit1 = i < num1.size() ? num1.get(i) : 0;
            int digit2 = i < num2.size() ? num2.get(i) : 0;

            int sum = digit1 + digit2 + carry;
            carry = sum / 10;
            ans.add(sum%10);
        }

        if (carry != 0) {
            ans.add(carry);
        }

        return ans;
    }

    private List<Integer> multiplyOneDigit(StringBuilder firstNumber, char secondNumberDigit, int zeros) {
        List<Integer> currentResult = new ArrayList<>();

        for (int i=0; i<zeros;i++) {
            currentResult.add(0);
        }

        int carry = 0;

        for (int i=0; i < firstNumber.length(); i++) {
            char firstNumberDigit = firstNumber.charAt(i);
            int multiplication = (secondNumberDigit - '0') * (firstNumberDigit - '0') + carry;

            carry = multiplication / 10;
            currentResult.add(multiplication % 10);
        }

        if (carry != 0) {
            currentResult.add(carry);
        }

        return currentResult;
    }
}
