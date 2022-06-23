package leetcode;

 public class TreeNode {
     int val;
     TreeNode left;
     TreeNode right;
     TreeNode() {}
     TreeNode(int val) { this.val = val; }
     TreeNode(int val, TreeNode left, TreeNode right) {
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
