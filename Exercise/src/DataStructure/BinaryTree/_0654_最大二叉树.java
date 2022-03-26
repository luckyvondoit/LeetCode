package DataStructure.BinaryTree;

import java.util.Stack;

public class _0654_最大二叉树 {
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

    public TreeNode constructMaximumBinaryTree(int[] nums) {
         if (nums == null || nums.length == 0) return null;
         return findRoot(nums, 0, nums.length);
    }

    /**
     * 在[li, ri)中找出根节点。
     */
    private TreeNode findRoot(int[] nums, int li, int ri) {
        if (li == ri) return null;
        int maxIdx = li;
        for (int i = li + 1; i < ri; i++) {
            if (nums[i] > nums[maxIdx]) {
                maxIdx = i;
            }
        }
        TreeNode root = new TreeNode(nums[maxIdx]);
        root.left = findRoot(nums, li, maxIdx);
        root.right = findRoot(nums, maxIdx + 1, ri);
        return root;
    }

    /**
     * 返回最大二叉树么一个节点父节点的索引
     * 思路：利用栈求出左、右第一个比它大的数
     * 1、扫描一遍所有元素
     * 2、保持栈从栈低到栈顶是单调递减的
     * */
    public int[] parentIndexex(int[] nums) {
        if (nums == null || nums.length == 0) return null;

        // 左边第一个比i位置大的元素的索引
        int[] lis = new int[nums.length];
        // 右边第一个比i位置大的元素的索引
        int[] ris = new int[nums.length];

        for (int i = 0; i < nums.length; i++) {
            lis[i] = -1;
            ris[i] = -1;
        }

        Stack<Integer> stack = new Stack<>();

        // 如果栈顶元素小于nums[i] 需要将栈顶元素弹出，同时设置栈顶元素右边比它大的元素的索引为i
        // 如果栈顶元素大于nums[i] 设置当前元素左边第一个比它大的元素的索引为栈顶，同时push i
        for (int i = 0; i < nums.length; i++) {
            while (!stack.isEmpty() && nums[i] > nums[stack.peek()]) {
                ris[stack.pop()] = i;
            }
            if (!stack.isEmpty()) {
                lis[i] = stack.peek();
            }
            stack.push(i);
        }

        int[] pidx = new int[nums.length];

        for (int i = 0; i < nums.length; i++) {
            if (lis[i] == -1 && ris[i] == -1) {
                pidx[i] = -1;
            } else if (lis[i] != -1 && ris[i] == -1) {
                pidx[i] = lis[i];
            } else if (lis[i] == -1 && ris[i] != -1) {
                pidx[i] = ris[i];
            } else {
                if (nums[lis[i]] > nums[ris[i]]) {
                    pidx[i] = ris[i];
                } else {
                    pidx[i] = lis[i];
                }
             }
        }

        return pidx;

    }
}
