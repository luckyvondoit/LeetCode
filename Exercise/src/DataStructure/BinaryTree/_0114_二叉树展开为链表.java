package DataStructure.BinaryTree;

public class _0114_二叉树展开为链表 {
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

    // 前序遍历-递归
    public void flatten(TreeNode root) {
         if (root == null) return;

         if (root.left != null) {
             TreeNode prevRight = root.right;
             root.right = root.left;
             root.left = null;

             TreeNode lastRight = root;
             while (lastRight.right != null) {
                 lastRight = lastRight.right;
             }
             lastRight.right = prevRight;
         }
         //左子树已经置为空，不需要遍历
         flatten(root.right);
    }

    // 前序遍历-非递归
    public void flatten1(TreeNode root) {

         while (root != null) {
             if (root.left != null) {
                 TreeNode prevRight = root.right;
                 root.right = root.left;
                 root.left = null;

                 TreeNode lastRight = root;
                 while (lastRight.right != null) {
                     lastRight = lastRight.right;
                 }
                 lastRight.right = prevRight;
             }

             root = root.right;
         }
    }

}
