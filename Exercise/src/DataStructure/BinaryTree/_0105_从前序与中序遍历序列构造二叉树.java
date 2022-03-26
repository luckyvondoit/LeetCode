package DataStructure.BinaryTree;

import java.util.HashMap;
import java.util.Map;

public class _0105_从前序与中序遍历序列构造二叉树 {
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

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder == null || preorder.length == 0) return null;
         if (inorder == null || inorder.length == 0) return null;

         int len = inorder.length;
         for (int i = 0; i < len; i++) {
             map.put(inorder[i], i);
         }
         return buildTree(preorder, inorder,0, len, 0, len);
    }

    public TreeNode buildTree(int[] preorder, int[] inorder, int pl, int pr, int il, int ir) {
        if (pl >= pr || il >= ir) return null;
        int k = map.get(preorder[pl]);

        TreeNode root = new TreeNode(preorder[pl]);
        root.left = buildTree(preorder, inorder,pl + 1,pl + 1 + k - il,il,k);
        root.right = buildTree(preorder, inorder,pr - ir + k + 1 ,pr,k + 1, ir);
        return root;
    }
}
