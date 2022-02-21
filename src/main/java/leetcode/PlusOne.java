package leetcode;

public class PlusOne {
    public int[] plusOne(int[] digits) {
        if (digits[digits.length - 1] < 9) {
            digits[digits.length - 1]++;
            return digits;
        }

        digits[digits.length - 1] = 0;
        int carry = 1;

        for (int i = digits.length - 2; i >= 0; i--) {
            int sum = digits[i] + carry;
            digits[i] = sum % 10;
            carry = sum / 10;
        }


        int[] res = new int[digits.length + 1];

        if (carry != 0) {
            res[0] = carry;
            for (int i=1;i<res.length; i++) {
                res[i] = digits[i-1];
            }

            return res;
        } else {
            return digits;
        }
    }
}
