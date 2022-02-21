package leetcode;

import org.junit.jupiter.api.Test;
import org.assertj.core.api.Assertions;

public class JumpGameTests {
    @Test
    public void jump_game() {
        JumpGame jg = new JumpGame();
        int[] nums = {2,3,1,1,4};

        Assertions.assertThat(jg.canJumpBacktrack(nums)).isTrue();
    }

    @Test
    public void jump_game_dp() {
        JumpGame jg = new JumpGame();
        int[] nums = {2,3,1,1,4};

        Assertions.assertThat(jg.canJumpDp(nums)).isTrue();
    }

    @Test
    public void jump_game_dp_bottom_up() {
        JumpGame jg = new JumpGame();
        int[] nums = {2,3,1,1,4};

        Assertions.assertThat(jg.canJumpDpBu(nums)).isTrue();
    }

    @Test
    public void jump_game_dp_greedy() {
        JumpGame jg = new JumpGame();
        int[] nums = {2,3,1,1,4};

        Assertions.assertThat(jg.canJumpGreedy(nums)).isTrue();
    }
}
