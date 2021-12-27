package DataStructure.BinaryTree;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class _0144_Binary_Tree_Preorder_Traversal {
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
    public List<Integer> preorderTraversal(TreeNode root) {
        return preorderTraversal1(root);
    }

    private List<Integer> preorderTraversal1(TreeNode root) {
        List<Integer> list = new LinkedList<>();
        if (root == null) return null;
        preorder1(root, list);
        return list;
    }

    private void preorder1(TreeNode node, List list) {
        if (node == null) return;

        list.add(node.val);
        preorder1(node.left, list);
        preorder1(node.right, list);

    }

    private List<Integer> preorderTraversal2(TreeNode root) {
        List<Integer> list = new LinkedList<>();
        if (root == null) return list;

        Stack<TreeNode> stack = new Stack<>();
        TreeNode node = root;

        while (true) {
            if (node != null) {
                list.add(node.val);
                if (node.right != null) {
                    stack.push(node.right);
                }
                node = node.left;
            } else if (stack.isEmpty()) {
                return list;
            } else {
                node = stack.pop();
            }
        }
    }

}
