package chapter04;

import java.util.ArrayList;
import java.util.List;

public class TreeNodeGeneric<T> {
    T data;
    public ArrayList<T> children = new ArrayList<T>();

    public TreeNodeGeneric(T data) {
        this.data = data;
    }

    public TreeNodeGeneric() {
    }

    public TreeNodeGeneric fromPreOrderList(List<T> list) {
        TreeNodeGeneric[] nodes = new TreeNodeGeneric[list.size()];

        for (int i = 0; i < list.size(); i++) {
            nodes[i] = new TreeNodeGeneric(list.get(i));
        }

        for (int i = 0; i < list.size() / 2; i++) {
            nodes[i].children.add(nodes[2*i +1]);
            nodes[i].children.add(nodes[2*i +2]);
        }

        return nodes[0];
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        visitChildren(this, sb);
        return sb.toString();
    }

    public void visitChildren(TreeNodeGeneric node, StringBuilder stringBuilder) {
        if (node == null) {
            return;
        }

        ArrayList<TreeNodeGeneric> nodeChildren = node.children;

        stringBuilder.append(node.data);
        nodeChildren.forEach(c -> visitChildren(c, stringBuilder));


    }
}
