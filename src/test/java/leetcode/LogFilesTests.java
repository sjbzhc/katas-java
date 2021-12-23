package leetcode;

import org.junit.Test;
import org.assertj.core.api.Assertions;

import java.util.Arrays;

public class LogFilesTests {

    @Test
    public void log_files() {
        String[] arr = new String[2];
        arr[0] = "a1 9 2 3 1";
        arr[1] =  "g1 act car";

        String[] expected = new String[2];
        expected[0] = "g1 act car";
        expected[1] =  "a1 9 2 3 1";
        LogFiles.arrange(arr);
        Assertions.assertThat(arr).isEqualTo(expected);
    }

    @Test
    public void log_files2() {
        String[] arr = new String[2];
        arr[0] = "a1 9 2 3 1";
        arr[1] =  "g1 act car";

        String[] expected = new String[2];
        expected[0] = "g1 act car";
        expected[1] =  "a1 9 2 3 1";
        LogFiles2.arrange(arr);
        Arrays.stream(arr).forEach(System.out::println);
        Assertions.assertThat(arr).isEqualTo(expected);
    }
}
