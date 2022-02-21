package DataStructure.BinaryTree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class _0107_Binary_Tree_Level_Order_Traversal_II {
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

    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> list = new ArrayList<>();
        if (root == null) return list;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int levelSize = 1;
        List<Integer> innerList = new ArrayList<>();

        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            levelSize--;
            innerList.add(node.val);


            if (node.left != null) {
                queue.add(node.left);
            }
            if (node.right != null) {
                queue.add(node.right);
            }

            if (levelSize == 0) {
                list.add(0, innerList);
                innerList = new ArrayList<>();
                levelSize = queue.size();
            }
        }

        return list;
    }
}
