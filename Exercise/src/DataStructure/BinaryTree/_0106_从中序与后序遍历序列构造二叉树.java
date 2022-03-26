/**
 * 解题思路：https://leetcode-cn.com/problems/construct-binary-tree-from-inorder-and-postorder-traversal/solution/tu-jie-zhong-xu-hou-xu-er-cha-shu-gou-za-vios/
 */

package DataStructure.BinaryTree;

import java.util.HashMap;
import java.util.Map;

public class _0106_从中序与后序遍历序列构造二叉树 {

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

     private Map<Integer, Integer> map = new HashMap<>();

     public TreeNode buildTree(int[] inorder, int[] postorder) {
         if (inorder == null || inorder.length == 0) return null;
         if (postorder == null || postorder.length == 0) return null;
         int len = inorder.length;

         for (int i = 0; i < len; i++) {
             map.put(inorder[i], i);
         }

        return buildTree(inorder, postorder, 0, len - 1, 0, len - 1);

    }

    private TreeNode buildTree(int[] inorder, int[] postorder, int il, int ir, int pl, int pr) {
         if (pl > pr) return null;

         int k = map.get(postorder[pr]);
         TreeNode root = new TreeNode(postorder[pr]);
         root.left = buildTree(inorder, postorder, il, k - 1, pl, pl + k - il - 1);
         root.right = buildTree(inorder,postorder, k + 1, ir,pr - ir + k, pr - 1);

         return root;
    }

}
