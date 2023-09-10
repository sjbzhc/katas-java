package leetcode;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class RankTeamsTest {
    @Test
    public void test() {
        RankTeams rt = new RankTeams();
        String[] votes = {"ABC","ACB","ABC","ACB","ACB"};
        Assertions.assertThat(rt.rankTeams(votes)).isEqualTo("ACB");
    }
}
