package DataStructure.BinaryTree;


/**
 * 思路
 * ①对每个节点都计算出：有穿过它但是不穿过父节点的最大路径和。（包括所有路径，如果当前节点是根节点，就会经过根节点）
 * ②整体最大路径和：①中所计算出的结果的最大值
 *                  A
 *               B     C
 *             D   E F   G
 * 假设S(L)是穿过L节点但是不穿过其父节点的最大路径和
 * 假设V(K)是节点K能提供给父节点的最大路径值
 *
 * S(A) = A + MAX(V(B), 0) + MAX(V(C), 0)
 * S(B) = B + MAX(V(D), 0) + MAX(V(E), 0)
 * S(C) = C + MAX(V(F), 0) + MAX(V(G), 0)
 * S(D) = D + 0 + 0
 * S(E) = D + 0 + 0
 * S(F) = D + 0 + 0
 * S(G) = D + 0 + 0
 * 整体的最大路径值：MAX(S(A),S(B),S(C),S(D),S(E),S(F),S(G))
 *
 * V(B) = B + MAX(MAX(V(D), 0), MAX(V(E), 0))
 * V(C) = C + MAX(MAX(V(F), 0), MAX(V(G), 0))
 * V(A) = A + MAX(MAX(V(B), 0), MAX(V(C), 0))
 * V(D) = D + MAX(0, 0)
 * V(E) = E + MAX(0, 0)
 * V(F) = F + MAX(0, 0)
 * V(G) = G + MAX(0, 0)
 * 由此可见，求1个节点能提供给父节点的最大路径需要采用后序遍历，时间空间复杂度都是O(n)
 */

public class _0124_二叉树中的最大路径和 {
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

     private int sum = Integer.MIN_VALUE;

    public int maxPathSum(TreeNode root) {
        value(root);
        return sum;

    }

    private int value(TreeNode node) {
         if (node == null) return 0;

         int lv = Math.max(value(node.left), 0);
         int rv = Math.max(value(node.right), 0);

         sum = Math.max(sum, node.val + lv + rv);

         return node.val + Math.max(lv, rv);
    }

}
