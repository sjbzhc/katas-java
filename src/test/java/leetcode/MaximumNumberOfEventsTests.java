package leetcode;

import org.junit.jupiter.api.Test;
import org.assertj.core.api.Assertions;

public class MaximumNumberOfEventsTests {
    @Test
    public void max_number_of_events() {
        MaximumNumberOfEvents mn = new MaximumNumberOfEvents();
        int[][] events = {{1,2},{2,3},{3,4}};
        Assertions.assertThat(mn.maxEvents(events)).isEqualTo(3);
    }

    @Test
    public void max_number_of_events_2() {
        MaximumNumberOfEvents mn = new MaximumNumberOfEvents();
        int[][] events = {{1,4},{4,4},{2,2},{3,4},{1,1}};
        Assertions.assertThat(mn.maxEvents(events)).isEqualTo(4);
    }

    @Test
    public void max_number_of_events_2_1() {
        MaximumNumberOfEvents2 mn = new MaximumNumberOfEvents2();
        int[][] events = {{1,2},{2,3},{3,4}};
        Assertions.assertThat(mn.maxEvents(events)).isEqualTo(3);
    }
}
