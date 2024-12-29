package leetcode;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

public class RankTeamsTest {
    @Test
    public void test() {
        RankTeams rt = new RankTeams();
        String[] votes = {"ABC","ACB","ABC","ACB","ACB"};
        Assertions.assertThat(rt.rankTeams(votes)).isEqualTo("ACB");
    }

    @Test
    void test2() {
        int[][] array = {{3,2,1}, {1,2,3}, {3,3,1}};
        int[][] expected = {{3,3,1}, {3,2,1}, {1,2,3}};

        Arrays.sort(array, (a, b) -> {
            for (int i=0; i<3; i++) {
                if (a[i] > b[i]) return -1;
                if (a[i] < b[i]) return 1;
            }
            return 0;
        });

        Assertions.assertThat(array).isEqualTo(expected);
    }
}
