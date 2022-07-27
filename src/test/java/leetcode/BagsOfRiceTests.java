package leetcode;

import org.junit.jupiter.api.Test;
import org.assertj.core.api.Assertions;

public class BagsOfRiceTests {

    @Test
    public void test() {
        BagsOfRice br = new BagsOfRice();

        int[] bags = {4,2,16};

        Assertions.assertThat(br.bagsOfRice(bags)).isEqualTo(3);
    }

    @Test
    public void test_2() {
        BagsOfRice br = new BagsOfRice();

        int[] bags = {625, 4, 2, 5, 25};

        Assertions.assertThat(br.bagsOfRice(bags)).isEqualTo(3);
    }

    @Test
    public void test_3() {
        BagsOfRice br = new BagsOfRice();

        int[] bags = {3,9,2,4,16};

        Assertions.assertThat(br.bagsOfRice(bags)).isEqualTo(3);
    }
}
