package leetcode;

/*
* Time: O(n)
* Space: O(1)
* */

public class NumberOf1Bits {
    public int hammingWeight(int n) {
        int res = 0;
        while (n != 0) {
            res += n % 2;
            n = n >> 1;
        }
        return res;
    }
}
