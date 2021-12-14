package chapter04;

import org.junit.Test;
import org.assertj.core.api.Assertions;

import java.util.LinkedList;
import java.util.List;

public class CreateLevelLinkedListsTests {
    @Test public void create_Level() {
        CreateLevelLinkedLists cl = new CreateLevelLinkedLists();
        LinkedList<Integer> l0 = new LinkedList<>();
        l0.add(0);
        LinkedList<Integer> l1 = new LinkedList<>();
        l1.add(1);
        l1.add(4);
        LinkedList<Integer> l2 = new LinkedList<>();
        l2.add(2);
        l2.add(3);

        List<LinkedList<Integer>> list = List.of(l0, l1, l2);

        TreeNode2 node0 = new TreeNode2(0);
        TreeNode2 node1 = new TreeNode2(1);
        TreeNode2 node2 = new TreeNode2(2);
        TreeNode2 node3 = new TreeNode2(3);
        TreeNode2 node4 = new TreeNode2(4);

        node1.left = node2;
        node1.right = node3;
        node0.left = node1;
        node0.right = node4;

        Assertions.assertThat(cl.create(node0)).isEqualTo(list);


    }

    @Test public void create_Level_bfs() {
        CreateLevelLinkedLists cl = new CreateLevelLinkedLists();
        LinkedList<Integer> l0 = new LinkedList<>();
        l0.add(0);
        LinkedList<Integer> l1 = new LinkedList<>();
        l1.add(1);
        l1.add(4);
        LinkedList<Integer> l2 = new LinkedList<>();
        l2.add(2);
        l2.add(3);

        List<LinkedList<Integer>> list = List.of(l0, l1, l2);

        TreeNode2 node0 = new TreeNode2(0);
        TreeNode2 node1 = new TreeNode2(1);
        TreeNode2 node2 = new TreeNode2(2);
        TreeNode2 node3 = new TreeNode2(3);
        TreeNode2 node4 = new TreeNode2(4);

        node1.left = node2;
        node1.right = node3;
        node0.left = node1;
        node0.right = node4;

        Assertions.assertThat(cl.createListsBFS(node0)).isEqualTo(list);


    }
}
