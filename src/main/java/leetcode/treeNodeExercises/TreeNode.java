package leetcode.treeNodeExercises;

import chapter04.TreeNode2;

public class TreeNode {
    public int val;
    public TreeNode left;
    public TreeNode right;
    TreeNode() {}
    public TreeNode(int val) { this.val = val; }
    public TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        visitChildren(this, sb);
        return sb.toString();
    }

    public void visitChildren(TreeNode node, StringBuilder stringBuilder) {
        if (node == null) {
            return;
        }

        stringBuilder.append(node.val);
        visitChildren(node.left, stringBuilder);
        visitChildren(node.right, stringBuilder);
    }
}