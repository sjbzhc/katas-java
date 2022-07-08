package leetcode;

import org.junit.jupiter.api.Test;
import org.assertj.core.api.Assertions;

public class CountSubmatricesWithAllOnesTests {
    @Test
    public void test() {
        CountSubmatricesWithAllOnes cs = new CountSubmatricesWithAllOnes();

        int[][] matrix = {{1,0,1},{1,1,0},{1,1,0}};

        Assertions.assertThat(cs.numSubmat(matrix)).isEqualTo(13);
    }
}
