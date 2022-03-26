/**
 * 解题思路：https://leetcode-cn.com/problems/symmetric-tree/solution/dong-hua-yan-shi-101-dui-cheng-er-cha-shu-by-user7/
 */
package DataStructure.BinaryTree;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class _0101_对称二叉树 {
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

    public boolean isSymmetric(TreeNode root) {
         if (root == null) return false;
         return equalCheck(root.left, root.right);

    }

    private boolean equalCheck(TreeNode left, TreeNode right) {
         if (left == null && right == null) return true;
         if (left == null || right == null) return false;
         if (left.val != right.val) return false;
         return equalCheck(left.left, right.right) && equalCheck(left.right, right.left);
    }

}
