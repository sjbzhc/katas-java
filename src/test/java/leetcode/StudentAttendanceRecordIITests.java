package leetcode;

import org.junit.jupiter.api.Test;
import org.assertj.core.api.Assertions;

public class StudentAttendanceRecordIITests {
    @Test
    public void test() {
        StudentAttendanceRecordII sa = new StudentAttendanceRecordII();

        Assertions.assertThat(sa.checkRecord(2)).isEqualTo(8);
    }
}
