package chapter03;

import org.junit.Test;
import org.assertj.core.api.Assertions;

public class StackofPlatesTests {

    @Test
    public void stack_of_plates() {
        StackOfPlates stackOfPlates = new StackOfPlates(5);
        stackOfPlates.push(1);
        stackOfPlates.push(1);
        stackOfPlates.push(1);
        stackOfPlates.push(1);
        stackOfPlates.push(1);
        stackOfPlates.push(1);
        stackOfPlates.push(1);
        stackOfPlates.push(1);

        Assertions.assertThat(stackOfPlates.getNumberOfStacks()).isEqualTo(2);
    }

    @Test
    public void stack_of_plates_double_delete() {
        StackOfPlates stackOfPlates = new StackOfPlates(5);
        stackOfPlates.push(1);
        stackOfPlates.push(1);
        stackOfPlates.push(1);
        stackOfPlates.push(1);
        stackOfPlates.push(1);
        stackOfPlates.push(1);
        stackOfPlates.push(1);
        stackOfPlates.push(1);

        Assertions.assertThat(stackOfPlates.getNumberOfStacks()).isEqualTo(2);

        stackOfPlates.pop();
        stackOfPlates.pop();
        stackOfPlates.pop();

        Assertions.assertThat(stackOfPlates.getNumberOfStacks()).isEqualTo(1);

    }
}
