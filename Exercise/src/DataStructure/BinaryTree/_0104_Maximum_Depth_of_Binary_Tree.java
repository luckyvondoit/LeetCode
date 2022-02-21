package DataStructure.BinaryTree;

import java.util.LinkedList;
import java.util.Queue;

public class _0104_Maximum_Depth_of_Binary_Tree {
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
     public int maxDepth(TreeNode root) {
          if (root == null) return 0;

          int height = 0;
          Queue<TreeNode> queue = new LinkedList<>();
          queue.offer(root);
          int levelSize = 1;
          while (!queue.isEmpty()) {
               TreeNode node = queue.poll();
               levelSize--;
               if (node.left != null) {
                  queue.offer(node.left);
               }
               if (node.right != null) {
                  queue.offer(node.right);
               }

               if (levelSize == 0) {
                  levelSize = queue.size();
                  height++;
               }
          }
          return height;
     }
}
