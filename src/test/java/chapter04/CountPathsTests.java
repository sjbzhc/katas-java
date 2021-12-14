package chapter04;

import org.junit.Test;
import org.assertj.core.api.Assertions;

import java.util.List;

public class CountPathsTests {

    @Test
    public void tree_from_pre_order_list_longer() {
        List<Integer> list = List.of(1,2,3,4,5,6,7);
        TreeNodeGeneric<Integer> treeNodeGeneric = new TreeNodeGeneric<>();
        Assertions.assertThat(treeNodeGeneric.fromPreOrderList(list).toString()).isEqualTo("1245367");
    }

    @Test
    public void tree_from_pre_order_list() {
        List<Integer> list = List.of(1,2,3,4,5);
        TreeNodeGeneric<Integer> treeNodeGeneric = new TreeNodeGeneric<>();
        Assertions.assertThat(treeNodeGeneric.fromPreOrderList(list).toString()).isEqualTo("12453");
    }

    @Test
    public void count_paths() {
        List<Integer> list = List.of(10,5,-3,3,2,11,3,-2,1);
        TreeNodeGeneric<Integer> treeNodeGeneric = new TreeNodeGeneric<>();
        Assertions.assertThat(treeNodeGeneric.fromPreOrderList(list).toString()).isEqualTo("1053-212-3113");

        TreeNodeGeneric tn = treeNodeGeneric.fromPreOrderList(list);

        CountPaths countPaths = new CountPaths();
        Assertions.assertThat(countPaths.countPaths(tn, 3)).isEqualTo(2);
    }
}
