package DataStructure.BinaryTree;

public class _0572_另一棵树的子树 {
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

    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
         if (root == null || subRoot == null) return false;
         return postSerialize(root).contains(postSerialize(subRoot));
    }

    /**
     * 利用后序遍历的方式进行序列化
     * 二叉树
     *          1
     *        2   3
     *      4   5
     * 序列化后的字符串为 #!#!4!#!#!5!2!#!#!3!1!
     * 用#代表空节点的值，在每个节点的值后加上!（节点4的左右子节点都为空）
     *
     * 如果使用前序遍历序列化
     * 树为    12     子树 2
     * 树序列化：12!#!#!
     * 子树序列化：2!#!#!
     * 树序列化字符串包含子树序列化字符串，但是子树不在树中，需要在字符串开头加上特殊字符
     * 树序列化：!12!#!#!
     * 子树序列化:!2!#!#!
     */

    private String postSerialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        postSerialize(root, sb);
        return sb.toString();
    }

    private void postSerialize(TreeNode node, StringBuilder sb) {
        if (node.left == null) {
            sb.append("#!");
        } else {
            postSerialize(node.left, sb);
        }

        if (node.right == null) {
            sb.append("#!");
        } else {
            postSerialize(node.right, sb);
        }

        sb.append(node.val).append("!");
    }


}
