package DataStructure.BinaryTree;

public class _0098_验证二叉搜索树 {
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

     private Integer prevValue;

    public boolean isValidBST(TreeNode root) {
         if (root == null) return true;

         if (!isValidBST(root.left)) return false;

         if (prevValue != null && prevValue > root.val) return false;
         prevValue = root.val;

         if (!isValidBST(root.right)) return false;

         return true;

    }

}
