package leetcode;

import org.junit.jupiter.api.Test;
import org.assertj.core.api.Assertions;

import java.util.List;

public class SequentialDigitsTests {
    @Test
    public void test() {
        SequentialDigits sd = new SequentialDigits();

        List<Integer> res = List.of(123, 234);

        Assertions.assertThat(sd.sequentialDigits(100, 300)).isEqualTo(res);
    }
}
