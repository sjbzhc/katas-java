package leetcode;

import org.junit.jupiter.api.Test;
import org.assertj.core.api.Assertions;

public class SumTotalStrengthOfWizardsTests {
    @Test
    public void test() {
        SumTotalStrengthOfWizards st = new SumTotalStrengthOfWizards();

        int[] strength = {1,3,1,2};

        Assertions.assertThat(st.totalStrength(strength)).isEqualTo(44);
    }
}
