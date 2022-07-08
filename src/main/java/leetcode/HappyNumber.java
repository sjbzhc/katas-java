package leetcode;

import java.util.HashSet;
import java.util.Set;

public class HappyNumber {
    public boolean isHappy(int n) {
        Set<Integer> set = new HashSet<>();

        while (!set.contains(n)) {
            set.add(n);
            n = squaresOfDigits(n);
            if (n == 1) return true;
        }
        return false;
    }

    private int squaresOfDigits(int n) {
        int res = 0;

        while (n != 0) {
            int digit = n % 10;
            digit *= digit;
            res += digit;
            n /= 10;
        }
        return res;
    }
}
