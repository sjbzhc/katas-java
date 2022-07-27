package leetcode;

import org.junit.jupiter.api.Test;
import org.assertj.core.api.Assertions;

public class SplitNumberInPrimeSegmentsTests {

    @Test
    public void test_primes2() {

        SplitNumberInPrimeSegments sn = new SplitNumberInPrimeSegments();
        boolean[] primes = sn.getPrimes("10");
        int sum = 0;
        for (int i=2; i<primes.length; i++) {
            if (!primes[i]) sum++;
        }
        Assertions.assertThat(sum).isEqualTo(4);
    }

    @Test
    public void test_primes_11() {

        SplitNumberInPrimeSegments sn = new SplitNumberInPrimeSegments();
        boolean[] primes = sn.getPrimes("11");
        int sum = 0;
        for (int i=2; i<primes.length; i++) {
            if (!primes[i]) sum++;
        }
        Assertions.assertThat(sum).isEqualTo(5);
    }

    @Test
    public void test_primes_17() {

        SplitNumberInPrimeSegments sn = new SplitNumberInPrimeSegments();
        boolean[] primes = sn.getPrimes("17");
        int sum = 0;
        for (int i=2; i<primes.length; i++) {
            if (!primes[i]) sum++;
        }
        Assertions.assertThat(sum).isEqualTo(7);
    }

    @Test
    public void test_primes() {

        boolean[] primes = {false, false, false, false, true, false, true, false, true, true, true, false, true};

        SplitNumberInPrimeSegments sn = new SplitNumberInPrimeSegments();
        Assertions.assertThat(sn.getPrimes("12")).isEqualTo(primes);
    }

    @Test
    public void test() {
        SplitNumberInPrimeSegments sn = new SplitNumberInPrimeSegments();
        Assertions.assertThat(sn.countPrimeStrings("3175", 4)).isEqualTo(3);
    }
}
