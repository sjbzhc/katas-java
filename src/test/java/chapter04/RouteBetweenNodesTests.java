package chapter04;

import org.junit.Test;
import org.assertj.core.api.Assertions;

public class RouteBetweenNodesTests {

    @Test
    public void routes() {
        RouteBetweenNodes routeBetweenNodes = new RouteBetweenNodes();
        Graph graph = new Graph();

        TreeNode treeNodeA = new TreeNode("A");
        TreeNode treeNodeB = new TreeNode("B");
        TreeNode treeNodeC = new TreeNode("C");
        TreeNode treeNodeD = new TreeNode("D");

        treeNodeB.children.add(treeNodeC);
        treeNodeA.children.add(treeNodeB);

        graph.nodes.add(treeNodeA);
        graph.nodes.add(treeNodeB);
        graph.nodes.add(treeNodeC);
        graph.nodes.add(treeNodeD);

        Assertions.assertThat(routeBetweenNodes.search(graph, treeNodeA, treeNodeC)).isTrue();
    }
}
