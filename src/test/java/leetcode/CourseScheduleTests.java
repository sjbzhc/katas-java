package leetcode;

import org.junit.jupiter.api.Test;
import org.assertj.core.api.Assertions;

public class CourseScheduleTests {

    @Test
    public void course_schedule() {
        CourseSchedule cs = new CourseSchedule();

        int[] pr1 = {1,0};
        int[] pr2 = {2,0};
        int[] pr3 = {3,1};
        int[] pr4 = {3,2};
        int[][] prerequisites = {pr1, pr2, pr3, pr4};

        int[] expected = {0,2,1,3};
        Assertions.assertThat(cs.findOrder(4, prerequisites)).isEqualTo(expected);
    }

    @Test
    public void course_schedule2() {
        CourseSchedule2 cs = new CourseSchedule2();

        int[] pr1 = {1,0};
        int[] pr2 = {2,0};
        int[] pr3 = {3,1};
        int[] pr4 = {3,2};
        int[][] prerequisites = {pr1, pr2, pr3, pr4};

        int[] expected = {0,1,2,3};
        Assertions.assertThat(cs.findOrder(4, prerequisites)).isEqualTo(expected);
    }
}
