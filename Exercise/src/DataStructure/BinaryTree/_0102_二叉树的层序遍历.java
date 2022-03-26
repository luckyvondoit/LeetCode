package DataStructure.BinaryTree;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class _0102_二叉树的层序遍历 {
     public static class TreeNode {
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
           List<List<Integer>> list = new LinkedList<>();
           if (root == null) return list;
           Queue<TreeNode> queue = new LinkedList<>();
           queue.offer(root);
           List<Integer> levelList = new LinkedList<>();
           int levelSize = 1;
           while (!queue.isEmpty()) {
                TreeNode node = queue.poll();
                levelList.add(node.val);

                levelSize--;

                if (node.left != null) {
                   queue.offer(node.left);
                }
                if (node.right != null) {
                   queue.offer(node.right);
                }

                if (levelSize == 0) {
                   levelSize = queue.size();
                   list.add(levelList);
                   levelList = new LinkedList<>();
                }
           }
           return list;
     }

}
