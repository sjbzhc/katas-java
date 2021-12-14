package chapter04;

import java.util.ArrayList;
import java.util.Random;

public class TreeNode2 {
    public int data;
    public TreeNode2 left;
    public TreeNode2 right;
    private int size = 0;
    public TreeNode2 parent;

    public TreeNode2(int data) {
        this.data = data;
        size = 1;
    }

    /*
    * We cannot take the size of the root, as that number does not divide the tree. We need to take either left or right
    * */
    public TreeNode2 getRandomNode() {
        Random random = new Random();
        int leftSize = left == null ? 0 : left.getSize();
        int index = random.nextInt(size);
        if (index < leftSize) return left.getRandomNode();
        if (index == leftSize) return this;
        else return right.getRandomNode();
    }

    public void insertInOrder(int d) {
        if (d <= data) {
            if (left == null) {
                left = new TreeNode2(d);
            } else {
                left.insertInOrder(d);
            }
        } else {
            if (right == null) {
                right = new TreeNode2(d);
            } else {
                right.insertInOrder(d);
            }
        }
        size++;
    }

    public int getSize() {
        return size;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        visitChildren(this, sb);
        return sb.toString();
    }

    public void visitChildren(TreeNode2 node, StringBuilder stringBuilder) {
        if (node == null) {
            return;
        }

        stringBuilder.append(node.data);
        visitChildren(node.left, stringBuilder);
        visitChildren(node.right, stringBuilder);
    }
}
