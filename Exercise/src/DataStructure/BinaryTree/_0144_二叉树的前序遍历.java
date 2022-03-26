package DataStructure.BinaryTree;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class _0144_二叉树的前序遍历 {

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

    public List<Integer> preorderTraversal(TreeNode root) {
         List<Integer> list = new LinkedList<>();
        if (root == null) return list;

        Stack<TreeNode> stack = new Stack<>();

        while (true) {
            if (root != null) {
                list.add(root.val);
                if (root.right != null) {
                    stack.push(root.right);
                    root = root.left;
                }
            } else if (stack.isEmpty()) {
                return list;
            } else {
                root = stack.pop();
            }
        }
    }

}
