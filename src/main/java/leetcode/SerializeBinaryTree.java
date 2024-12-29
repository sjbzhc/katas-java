package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
* Time: O(n)
* Space: O(n)
* */
public class SerializeBinaryTree {
    public String serialize(TreeNode root) {
        return doSerialize(root, "");
    }

    private String doSerialize(TreeNode root, String str) {
        if (root == null) {
            str += "null,";
        } else {
            str += root.val + ",";
            // From here on we set s to the result of doSerialize (we don't add to it). We do this since we
            // are appending to the same str, otherwise we would repeat everything from the previous step on str
            str = doSerialize(root.left, str);
            str = doSerialize(root.right, str);
        }
        return str;
    }

    public TreeNode deserialize(String data) {
        List<String> list = new ArrayList<>(Arrays.asList(data.split(",")));
        return doDeserialize(list);
    }

    private TreeNode doDeserialize(List<String> list) {
        String current = list.get(0);
        list.remove(0);
        if (current.equals("null")) {
            return null;
        }

        TreeNode node = new TreeNode(Integer.valueOf(current));
        node.left = doDeserialize(list);
        node.right = doDeserialize(list);

        return node;
    }
}
