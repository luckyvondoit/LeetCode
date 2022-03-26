package DataStructure.BinaryTree;

public class _0236_二叉树的最近公共祖先 {
     public class TreeNode {
         int val;
         TreeNode left;
         TreeNode right;
         TreeNode(int x) { val = x; }
     }

     /**
      * 去以root为根节点的二叉树中查找p,q的最近公共祖先（公共祖先可以是p或q）
      * 1.
      */

     public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
          if (root == null || root == p || root == q) return root;
          TreeNode left = lowestCommonAncestor(root.left, p, q);
          TreeNode right = lowestCommonAncestor(root.right, p, q);
          if (left != null && right != null) return root;
          return left != null ? left : right;
     }
}
