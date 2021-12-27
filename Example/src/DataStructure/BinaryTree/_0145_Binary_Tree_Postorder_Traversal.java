package DataStructure.BinaryTree;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class _0145_Binary_Tree_Postorder_Traversal {
     public static class TreeNode {
         int val;
         TreeNode left;
         TreeNode right;
         TreeNode parent;
         TreeNode() {}
         TreeNode(int val) { this.val = val; }
         TreeNode(int val, TreeNode left, TreeNode right) {
             this.val = val;
             this.left = left;
             this.right = right;
         }
     }

    public List<Integer> postorderTraversal(TreeNode root) {
         return postorderTraversal1(root);
    }

    private List<Integer> postorderTraversal1(TreeNode root) {
         List<Integer> list = new LinkedList<>();
         if (root == null) return list;

         postorderTraversal1(root, list);
         return list;
    }

    private void postorderTraversal1(TreeNode node, List<Integer> list) {
         if (node == null) return;

         postorderTraversal1(node.left, list);
         postorderTraversal1(node.right, list);
         list.add(node.val);

    }

    private List<Integer> postorderTraversal2(TreeNode root) {
        List<Integer> list = new LinkedList<>();
        if (root == null) return list;

        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        TreeNode prev = null;
        while (!stack.isEmpty()) {
            TreeNode top = stack.peek();
            if (isLeaf(top) || (prev != null && prev.parent == top)) {
                prev = stack.pop();
                list.add(prev.val);

            } else {
                if (top.right != null) {
                    stack.push(top.right);
                }

                if (top.left != null) {
                    stack.push(top.left);
                }
            }
        }
        return list;
    }

    private boolean isLeaf(TreeNode node) {
         if (node == null) return false;
         return node.left == null && node.right == null;
    }
}
