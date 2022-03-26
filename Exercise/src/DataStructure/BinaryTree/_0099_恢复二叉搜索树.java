package DataStructure.BinaryTree;

public class _0099_恢复二叉搜索树 {
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

     private TreeNode prev;
     private TreeNode first;
     private TreeNode second;

    public void recoverTree(TreeNode root) {
        if (root == null) return;
        inorder(root);
        int tmp = first.val;
        first.val = second.val;
        second.val = tmp;
    }

    /**
     * 中序遍历，按照从小到大排序，会出现一个（乱序两个元素挨在一起）或者两个逆序对（乱序的两个元素不挨在一起）。
     * 第一个乱序的元素的第一个逆序对的大值，第二个乱序元素是第二个逆序对的小值。
     */
    private void inorder(TreeNode root) {
        if (root == null) return;
        inorder(root.left);
        // prev为空是第一个逆序对，直接把较小的赋值给second，
        // 第二个逆序对会覆盖第一个，second为第二个的逆序对的小值
        if (prev != null && prev.val > root.val) {
            second = root;

            if (first == null) {
                first = prev;
            }
        }
        prev = root;

        inorder(root.right);
    }

}
