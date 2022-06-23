package leetcode;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class MinStackTests {
    @Test
    public void min_stack() {
        MinStack ms = new MinStack();
        ms.push(-2);
        ms.push(0);
        ms.push(-3);
        Assertions.assertThat(ms.getMin()).isEqualTo(-3);
        ms.pop();
        Assertions.assertThat(ms.top()).isEqualTo(0);
        Assertions.assertThat(ms.getMin()).isEqualTo(-2);
    }
}
