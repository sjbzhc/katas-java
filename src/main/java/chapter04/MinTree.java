package chapter04;

public class MinTree {

    public TreeNode2 fromArray(int[] arr) {
        return create(arr, 0, arr.length - 1);
    }

    private TreeNode2 create(int[] arr, int left, int right) {
        if (left > right) return null;
        int mid = (right + left) / 2;
        TreeNode2 node = new TreeNode2(arr[mid]);
        node.left = create(arr, left, mid - 1);
        node.right = create(arr, mid + 1, right);

        return node;
    }
}
