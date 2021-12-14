package leetcode;

import org.junit.jupiter.api.Test;
import org.assertj.core.api.Assertions;

public class RobotBoundedTests {
    @Test
    public void is_robot_bounded() {
        RobotBounded irb = new RobotBounded();

        Assertions.assertThat(irb.isRobotBounded("GGLLGG")).isTrue();
    }
}
