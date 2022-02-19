package leetcode;

import org.junit.jupiter.api.Test;
import org.assertj.core.api.Assertions;

public class GraphValidTreeTests {
    @Test
    public void graph_valid() {
        GraphValidTree gv = new GraphValidTree();
        int[][] edges = {{0,1},{0,2},{0,3},{1,4}};
        Assertions.assertThat(gv.validTree(5, edges)).isTrue();
    }

    @Test
    public void graph_not_valid() {
        GraphValidTree gv = new GraphValidTree();
        int[][] edges = {{0,1},{1,2},{2,3},{1,3},{1,4}};
        Assertions.assertThat(gv.validTree(5, edges)).isFalse();
    }
}
