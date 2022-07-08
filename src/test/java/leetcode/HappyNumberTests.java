package leetcode;

import org.junit.jupiter.api.Test;
import org.assertj.core.api.Assertions;

public class HappyNumberTests {
    @Test
    public void test() {
        HappyNumber hn = new HappyNumber();

        Assertions.assertThat(hn.isHappy(19)).isTrue();
    }
}
