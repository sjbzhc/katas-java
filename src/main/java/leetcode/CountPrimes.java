package leetcode;

/*
* Time: O(sqrt(n) log n)
* Space: O(n)
* */

public class CountPrimes {
    public int countPrimes(int n) {
        int res = 0;
        boolean[] notPrime = new boolean[n];

        for (int i=2; i<Math.sqrt(n); i++) {
            if (!notPrime[i]) {
                for (int j = i*i; j<n; j += i) {
                    notPrime[j] = true;
                }
            }
        }


        for (int i=2; i<n;i++) {
            if (!notPrime[i]) res++;
        }
        return res;
    }
}
