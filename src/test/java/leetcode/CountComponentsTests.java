package leetcode;

import org.junit.jupiter.api.Test;
import org.assertj.core.api.Assertions;

public class CountComponentsTests {
    @Test
    public void count_components() {
        CountComponents cc = new CountComponents();

        int[] e1 = {1,2};
        int[] e2 = {3,4};
        int[] e3 = {5,3};
        int[] e4 = {4,5};

        int[][] edges = {e1,e2,e3,e4};

        Assertions.assertThat(cc.countComponents(6, edges)).isEqualTo(3);
    }

    @Test
    public void count_components_2() {
        CountComponents2 cc = new CountComponents2();

        int[] e1 = {1,2};
        int[] e2 = {3,4};
        int[] e3 = {5,3};
        int[] e4 = {4,5};

        int[][] edges = {e1,e2,e3,e4};

        Assertions.assertThat(cc.countComponents(6, edges)).isEqualTo(3);
    }
}
