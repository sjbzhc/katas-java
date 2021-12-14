package chapter04;

public class ContainsTree {

    public boolean containsTree(TreeNode t1, TreeNode t2) {
        StringBuilder s1 = new StringBuilder();
        StringBuilder s2 = new StringBuilder();

        createTreeString(t1, s1);
        createTreeString(t2, s2);

        // StringBuilder returns the index of a substring
        return s1.indexOf(s2.toString()) != -1;
    }

    private void createTreeString(TreeNode t1, StringBuilder s) {
        if (t1 == null) {
            s.append("X");
            return;
        }
        s.append(t1.name);
        t1.children.forEach(c -> createTreeString(c, s));
    }


}
