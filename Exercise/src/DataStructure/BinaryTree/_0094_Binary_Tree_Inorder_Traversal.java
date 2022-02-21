package DataStructure.BinaryTree;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class _0094_Binary_Tree_Inorder_Traversal {
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
    }

    public List<Integer> inorderTraversal(TreeNode root) {
         return inorderTraversal1(root);
    }

    private List<Integer> inorderTraversal1(TreeNode root) {
         List<Integer> list = new LinkedList<>();
         if (root == null) return list;

         inorderTraversal1(root, list);
         return list;

    }

    private void inorderTraversal1(TreeNode node, List list) {
         if (node == null) return;

         inorderTraversal1(node.left, list);
         list.add(node.val);
         inorderTraversal1(node.right, list);
    }

    private List<Integer> inorderTraversal2(TreeNode root) {
         List<Integer> list = new LinkedList<>();
         if (root == null) return list;

        Stack<TreeNode> stack = new Stack<>();
        TreeNode node = root;

        while (true) {
            if (node != null) {
               stack.push(node);
               node = node.left;
            } else if (stack.isEmpty()) {
                return list;
            } else {
                node = stack.pop();
                list.add(node.val);
                node = node.right;
            }
        }

    }
}
