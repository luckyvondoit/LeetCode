package DataStructure.BinaryTree;

import java.util.*;

public class _0102_Binary_Tree_Level_Order_Traversal {
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

    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> list = new ArrayList<>();
        if (root == null) return list;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        int levelSize = 1;
        List<Integer> innerList = new ArrayList<>();

        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            innerList.add(node.val);

            levelSize -= 1;
            if (node.left != null) {
                queue.offer(node.left);
            }

            if (node.right != null) {
                queue.offer(node.right);
            }

            if (levelSize == 0) {
                levelSize = queue.size();
                list.add(innerList);
                innerList = new ArrayList<>();
            }

        }
        return list;

    }
}
