package chapter04;

import java.util.ArrayList;
import java.util.List;

public class TreeNode {
    public String status;
    String name;
    public ArrayList<TreeNode> children = new ArrayList<>();

    public TreeNode(String name) {
        this.name = name;
    }

}
