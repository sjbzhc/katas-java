package chapter04;

import org.junit.Test;
import org.assertj.core.api.Assertions;

public class ContainsTreeTests {

    @Test
    public void contains_tree() {
        ContainsTree containsTree = new ContainsTree();
        TreeNode node9 = new TreeNode("9");
        TreeNode node18 = new TreeNode("18");
        TreeNode node5 = new TreeNode("5");
        node5.children.add(node9);
        node5.children.add(node18);

        TreeNode node3 = new TreeNode("3");
        TreeNode node7 = new TreeNode("7");
        TreeNode node20 = new TreeNode("20");
        node20.children.add(node3);
        node20.children.add(node7);

        TreeNode node10 = new TreeNode("10");
        node10.children.add(node5);
        node10.children.add(node20);

        TreeNode node5_2 = new TreeNode("5");
        TreeNode node9_2 = new TreeNode("9");
        TreeNode node18_2 = new TreeNode("18");
        node5_2.children.add(node9_2);
        node5_2.children.add(node18_2);

        Assertions.assertThat(containsTree.containsTree(node10, node5_2)).isTrue();
    }

    @Test
    public void substring_with_sb() {
        StringBuilder sb = new StringBuilder();
        String string = "string";
        sb.append("this is the string");
        Assertions.assertThat(sb.indexOf(string)).isEqualTo(12);
    }

    @Test
    public void substring_with_string() {
        String s1 = "this is the string";
        String string = "string";
        Assertions.assertThat(s1.indexOf(string)).isEqualTo(12);
    }
}
