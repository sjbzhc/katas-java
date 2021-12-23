package leetcode;

import org.junit.jupiter.api.Test;
import org.assertj.core.api.Assertions;

public class AwsRobotTests {
    @Test
    public void aws_robot() {
        AwsRobot aw = new AwsRobot();
        int[][] timeSeries = {{1,0,0,1}, {0,1,1,0}};
        Assertions.assertThat(aw.isValid(timeSeries, 2)).isTrue();
    }
}
