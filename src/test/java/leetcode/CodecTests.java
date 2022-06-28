package leetcode;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

public class CodecTests {
    @Test
    public void test() {
        Codec c = new Codec();
        List<String> list = List.of("Hello", "World");

        Assertions.assertThat(c.decode(c.encode(list))).isEqualTo(list);
    }
}
