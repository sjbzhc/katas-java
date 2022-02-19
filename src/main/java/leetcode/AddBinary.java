package leetcode;

import java.util.ArrayList;
import java.util.List;

public class AddBinary {
    public String addBinary(String a, String b) {
        int carry = 0;
        int indexA = a.length() - 1;
        int indexB = b.length() - 1;
        List<Integer> list = new ArrayList<>();

        while (indexA >= 0 && indexB >= 0) {
            int sum = a.charAt(indexA) - '0' + b.charAt(indexB) - '0' + carry;
            int digit = sum % 2 != 0 ? 1 : 0;
            carry = sum > 1 ? 1 : 0;

            list.add(digit);

            indexA--;
            indexB--;
        }

        if (indexA >= 0) {
            while (indexA > -1) {
                int sum = a.charAt(indexA) - '0' + carry;
                int digit = sum % 2 != 0 ? 1 : 0;
                carry = sum > 1 ? 1 : 0;
                list.add(digit);
                indexA--;
            }
        }

        if (indexB >= 0) {
            while (indexB > -1) {
                int sum = b.charAt(indexB) - '0' + carry;
                int digit = sum % 2 != 0 ? 1 : 0;
                carry = sum > 1 ? 1 : 0;
                list.add(digit);
                indexB--;
            }
        }

        if (carry == 1) {
            list.add(carry);
        }

        StringBuilder sb = new StringBuilder();

        for (int i=list.size() - 1; i>=0; i--) {
            sb.append(list.get(i));
        }

        return  sb.toString();
    }
}
