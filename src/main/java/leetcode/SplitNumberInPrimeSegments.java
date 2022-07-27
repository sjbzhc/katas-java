package leetcode;

public class SplitNumberInPrimeSegments {

    int MOD =1000000007;
    public boolean isPrime(String number) {
        int n = Integer.valueOf(number);
        return !primes[n];
    }

    boolean[] primes;
    public int countPrimeStrings(String number, int i) {
        primes = getPrimes(number);

        if (i == 0) return 1;

        int cnt = 0;

        for(int j = 1; j <= 6; j++) {

            if (i - j >= 0 && number.charAt(i - j) != '0' && isPrime(number.substring(i - j, i))) {
                cnt += countPrimeStrings(number, i - j);
                cnt %= MOD;
            }
        }

        // Return the final result
        return cnt;
    }

    public boolean[] getPrimes(String number) {
        int n = Integer.valueOf(number);
        boolean[] primes = new boolean[n + 1];

        for (int i=2; i<= Math.sqrt(n); i++) {
            if (!primes[i]) {
                for (int j = i*i; j<=n; j += i) {
                    primes[j] = true;
                }
            }
        }

        primes[0] = true;
        primes[1] = true;

        return primes;

    }
}
