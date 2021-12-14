package chapter04;

import org.junit.Test;
import org.assertj.core.api.Assertions;

public class RandomNodeTests {

    @Test
    public void random_node() {
        TreeNode2 tn = new TreeNode2(3);
        tn.insertInOrder(1);
        tn.insertInOrder(5);
        Assertions.assertThat(tn.getSize()).isEqualTo(3);
        System.out.println(tn.getRandomNode());
    }
}
