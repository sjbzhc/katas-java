package leetcode;

import org.junit.jupiter.api.Test;
import org.assertj.core.api.Assertions;

public class TimeMapTests {
    @Test
    public void test() {
        TimeMap timeMap = new TimeMap();
        timeMap.set("foo", "bar", 1);  // store the key "foo" and value "bar" along with timestamp = 1.
        timeMap.set("foo", "bar2", 4); // store the key "foo" and value "bar2" along with timestamp = 4.
        timeMap.get("foo", 4);         // return "bar2"
        Assertions.assertThat(timeMap.get("foo", 4)).isEqualTo("bar2");
    }
}
