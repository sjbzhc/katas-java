package leetcode;

import java.util.ArrayList;
import java.util.List;

/*
* Time: O(1)
* Space: O(1)
* */
public class SequentialDigits {
    public List<Integer> sequentialDigits(int low, int high) {
        String sample = "123456789";
        int n = 10;
        List<Integer> nums = new ArrayList<>();

        int lowLen = String.valueOf(low).length();
        int highLen = String.valueOf(high).length();

        for (int len=lowLen; len < highLen + 1; len++) {
            // n - len, since we need a valid substring starting from start, with length len, so the last possible string
            // is at n - len, as if we add len to start = n - len, we end the substring ending at n.
            for (int start=0; start < n - len; start++) {
                int num = Integer.parseInt(sample.substring(start, start + len));
                if (num >= low && num <= high) nums.add(num);
            }
        }

        return nums;
    }
}
