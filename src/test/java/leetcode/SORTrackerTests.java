package leetcode;

import org.junit.jupiter.api.Test;
import org.assertj.core.api.Assertions;

public class SORTrackerTests {
    @Test
    public void test() {

        SORTracker tracker = new SORTracker();
        tracker.add("bradford", 2);
        tracker.add("branford", 3);

        Assertions.assertThat(tracker.get()).isEqualTo("branford");
        tracker.add("alps", 2);
        Assertions.assertThat(tracker.get()).isEqualTo("alps");
        tracker.add("orland", 2);
        Assertions.assertThat(tracker.get()).isEqualTo("bradford");
        tracker.add("orlando", 3);
        Assertions.assertThat(tracker.get()).isEqualTo("bradford");
        tracker.add("alpine", 2);
        Assertions.assertThat(tracker.get()).isEqualTo("bradford");
        Assertions.assertThat(tracker.get()).isEqualTo("orland");
    }
}
