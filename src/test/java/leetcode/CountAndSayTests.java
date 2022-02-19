package leetcode;

import org.junit.jupiter.api.Test;
import org.assertj.core.api.Assertions;

public class CountAndSayTests {
    @Test
    public void count_and_say() {
        CountAndSay cs = new CountAndSay();
        Assertions.assertThat(cs.countAndSay(4)).isEqualTo("1211");
    }
}
