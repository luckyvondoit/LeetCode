package DataStructure.BinaryTree;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class _0145_二叉树的后序遍历 {

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

         boolean isLeaf() {
             return this.left == null && this.right == null;
         }
     }

    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> list = new LinkedList<>();
        if (root == null) return list;

        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);

        TreeNode preNode = root;

        boolean isLeaf = false;
        boolean isParent = false;

        while (!stack.isEmpty()) {
            TreeNode node = stack.peek();
            isLeaf = node.left == null && node.right == null;
            isParent = node.left == preNode || node.right == preNode;
            if (isLeaf || isParent) {
                preNode = stack.pop();
                list.add(preNode.val);
                System.out.println(preNode.val);
            } else {
                if (node.right != null) {
                    stack.push(node.right);
                }

                if (node.left != null) {
                    stack.push(node.left);
                }
            }
        }

        return list;
    }

    public static void main(String[] args) {
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
        TreeNode node4 = new TreeNode(4);
        TreeNode node5 = new TreeNode(5);

        node1.right = node3;

        node3.left = node4;

        _0145_二叉树的后序遍历 obj = new _0145_二叉树的后序遍历();
        obj.postorderTraversal(node1);
    }

}
