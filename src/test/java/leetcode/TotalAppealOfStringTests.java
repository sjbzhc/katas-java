package leetcode;

import org.junit.jupiter.api.Test;
import org.assertj.core.api.Assertions;

public class TotalAppealOfStringTests {
    @Test
    public void test() {
        TotalAppealOfString ta = new TotalAppealOfString();

        Assertions.assertThat(ta.appealSum("abbca")).isEqualTo(28);
    }
}
