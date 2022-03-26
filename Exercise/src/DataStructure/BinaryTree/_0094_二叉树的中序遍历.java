package DataStructure.BinaryTree;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class _0094_二叉树的中序遍历 {

     public static class TreeNode {
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
     }


    public List<Integer> inorderTraversal(TreeNode root) {
         List<Integer> list = new LinkedList<>();
         if (root == null) return list;

         Stack<TreeNode> stack = new Stack<>();

         while (true) {
             if (root != null) {
                 stack.push(root);
                 root = root.left;
             } else if (stack.isEmpty()) {
                 return list;
             } else {
                 root = stack.pop();
                 list.add(root.val);
                 root = root.right;
             }
         }
    }
}
