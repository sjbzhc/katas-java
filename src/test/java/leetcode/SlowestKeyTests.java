package leetcode;

import org.junit.jupiter.api.Test;
import org.assertj.core.api.Assertions;

public class SlowestKeyTests {
    @Test
    public void test() {
        SlowestKey sk = new SlowestKey();

        int[] releaseTimes = {9,29,49,50};

        Assertions.assertThat(sk.slowestKey(releaseTimes, "cbcd")).isEqualTo('c');
    }
}
