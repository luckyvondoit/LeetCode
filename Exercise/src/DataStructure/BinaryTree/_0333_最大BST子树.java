package DataStructure.BinaryTree;

public class _0333_最大BST子树 {
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
    }

    // 自顶向下，会出现重复的遍历
    public int largestBSTSubtree(TreeNode root) {
        if (root == null) return 0;
        if (isBST(root)) return nodesCount(root);
        return Math.max(largestBSTSubtree(root.left), largestBSTSubtree(root.right));
    }

    private boolean isBST(TreeNode root) {
        return false;
    }

    private int nodesCount(TreeNode root) {
        return 0;
    }

    // 自底向上

    private static class Info {
        public TreeNode root;
        public int size = 1;
        public int max;
        public int min;

        public Info(TreeNode root, int size, int max, int min) {
            this.root = root;
            this.size = size;
            this.max = max;
            this.min = min;
        }
    }

    public int largestBSTSubtree1(TreeNode root) {
        return root == null ? 0 : getInfo(root).size;
    }

    private Info getInfo(TreeNode root) {
        if (root == null) return null;
        Info li = getInfo(root.left);
        Info ri = getInfo(root.right);
        /**
         * 共4种情况，以root为根节点的二叉树就是BST，最大BST就是其本身
         * 1. li != null && ri != null
         * && li.root == root.left && root.val > li.max
         * && ri.root == root.right && root.val < ri.min
         *
         * 2. li != null && ri == null
         * && li.root == root.left && root.val > li.max
         *
         * 3. li == null && ri != null
         * && ri.root == root.right && root.val < ri.min
         *
         * 4. li == null && ri == null
         */

        int leftSize = -1, rightSize = -1, max = root.val, min = root.val;
        if (li == null) {
            leftSize = 0;
        } else if (li.root == root.left && root.val > li.max) {
            leftSize = li.size;
            min = li.min;
        }

        if (ri == null) {
            rightSize = 0;
        } else if (ri.root == root.right && root.val < ri.min) {
            rightSize = ri.size;
            max = ri.max;
        }

        if (leftSize >= 0 && rightSize >= 0) {
            return new Info(root,1 + leftSize + rightSize, max, min);
        }

        /**
         * 以root为根节点的二叉树不是bst，共三种情况
         * 1. li != null && ri != null
         * 2. li == null && ri != null
         * 3. li != null && ri == null
          */

        if (li != null && ri != null) return li.size > ri.size ? li : ri;

        // 返回li和ri不为空的那个
        return li != null ? li : ri;
    }


}
