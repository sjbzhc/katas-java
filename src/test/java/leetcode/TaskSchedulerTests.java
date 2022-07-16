package leetcode;

import org.junit.jupiter.api.Test;
import org.assertj.core.api.Assertions;

public class TaskSchedulerTests {
    @Test
    public void test() {
        TaskScheduler ts = new TaskScheduler();

        char[] chars = {'A','A','A','B','B','B'};

        Assertions.assertThat(ts.leastInterval(chars, 2)).isEqualTo(8);

    }
}
