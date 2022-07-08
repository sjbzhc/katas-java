package leetcode;

/*
* Time: O(lg n)
* Space: O(lg n)
* */

public class Pow {
    public double myPow(double x, int n) {
        double res = helper(x, Math.abs(n));
        if (n < 0) return 1/res;
        return res;
    }

    private double helper(double x, int n) {
        double res;

        if (x == 0) return 0;
        if (n == 0) return 1;

        res = helper(x, n/2);
        res *= res;
        if (n % 2 == 0) {
            return res;
        } else {
            return x * res;
        }
    }
}
