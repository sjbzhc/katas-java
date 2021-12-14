package chapter03;

import org.junit.Test;
import org.assertj.core.api.Assertions;

public class StackMinTests {
    @Test
    public void stack_min() {
        StackMin stackMin = new StackMin();
        stackMin.push(10);
        stackMin.push(1);

        Assertions.assertThat(stackMin.min()).isEqualTo(1);
    }

    @Test
    public void stack_min_consecutive() {
        StackMin stackMin = new StackMin();
        stackMin.push(4);
        stackMin.push(3);
        stackMin.push(2);
        stackMin.push(1);

        Assertions.assertThat(stackMin.min()).isEqualTo(1);
        stackMin.pop();
        Assertions.assertThat(stackMin.min()).isEqualTo(2);
    }
}
