package leetcode;

import org.junit.jupiter.api.Test;
import org.assertj.core.api.Assertions;


public class AddBinaryTests {

    @Test
    public void add_binary() {
        AddBinary ab = new AddBinary();
        Assertions.assertThat(ab.addBinary("11", "1")).isEqualTo("100");
    }
}
