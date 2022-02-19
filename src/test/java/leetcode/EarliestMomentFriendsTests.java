package leetcode;

import org.junit.jupiter.api.Test;
import org.assertj.core.api.Assertions;

public class EarliestMomentFriendsTests {
    @Test
    public void earliest_moment_friends() {
        EarliestMomentFriends em = new EarliestMomentFriends();
        int[][] logs = {{0,2,0},{1,0,1},{3,0,3},{4,1,2},{7,3,1}};
        Assertions.assertThat(em.earliestAcq(logs, 4)).isEqualTo(3);
    }
}
