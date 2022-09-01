package leetcode;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class MyCalendarTests {
    @Test
    public void test() {
        MyCalendar mc = new MyCalendar();

        Assertions.assertThat(mc.book(10, 20)).isTrue();
        Assertions.assertThat(mc.book(15, 25)).isFalse();
        Assertions.assertThat(mc.book(20, 30)).isTrue();
    }
}
