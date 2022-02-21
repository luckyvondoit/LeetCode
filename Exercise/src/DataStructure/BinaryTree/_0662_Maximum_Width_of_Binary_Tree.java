package DataStructure.BinaryTree;

import java.util.LinkedList;
import java.util.Queue;

public class _0662_Maximum_Width_of_Binary_Tree {
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
     private class AnnotatedNode {
         TreeNode node;
         int depth, pos;
         AnnotatedNode(TreeNode n, int d, int p) {
             node = n;
             depth = d;
             pos = p;
         }
     }

     public int widthOfBinaryTree(TreeNode root) {
         if (root == null) return 0;

         Queue<AnnotatedNode> queue = new LinkedList<>();
         queue.add(new AnnotatedNode(root, 0, 0));
         int curDepth = 0, left = 0, ans = 0;

         while (!queue.isEmpty()) {
              AnnotatedNode aNode = queue.poll();
              if (aNode.node != null) {
                  queue.add(new AnnotatedNode(aNode.node.left, aNode.depth + 1, aNode.pos * 2));
                  queue.add(new AnnotatedNode(aNode.node.right, aNode.depth + 1, aNode.pos * 2 + 1));
                  if (curDepth !=  aNode.depth) {
                      curDepth = aNode.depth;
                      left = aNode.pos;
                  }
                  ans = Math.max(ans, aNode.pos - left + 1);
              }
         }
         return ans;
     }

}

