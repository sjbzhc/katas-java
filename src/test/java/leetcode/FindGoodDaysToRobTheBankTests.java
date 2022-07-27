package leetcode;

import org.junit.jupiter.api.Test;
import org.assertj.core.api.Assertions;

import java.util.List;

public class FindGoodDaysToRobTheBankTests {
    @Test
    public void test() {
        FindGoodDaysToRobTheBank fg = new FindGoodDaysToRobTheBank();

        int[] security = {5,3,3,3,5,6,2};

        Assertions.assertThat(fg.goodDaysToRobBank(security, 2)).isEqualTo(List.of(2,3));
    }
}
