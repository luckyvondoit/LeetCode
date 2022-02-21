package DataStructure.BinaryTree;

import java.sql.Array;
import java.util.*;

public class _0589_N_ary_Tree_Preorder_Traversal {
    class Node {
        public int val;
        public List<Node> children;

        public Node() {}

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, List<Node> _children) {
            val = _val;
            children = _children;
        }
    }

    public List<Integer> preorder(Node root) {
        List<Integer> list = new LinkedList<>();
        if (root == null) return list;

        Stack<Node> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            Node top = stack.pop();
            list.add(top.val);

            Collections.reverse(top.children);
            for (Node node : top.children) {
                stack.push(node);
            }
        }
        return list;
    }


//    public List<Integer> preorder(Node root) {
//        List<Integer> list = new LinkedList<>();
//        if (root == null) return list;
//        preorder(root, list);
//
//        return list;
//    }
//
//    private void preorder(Node node, List<Integer> list) {
//        list.add(node.val);
//
//        if (node.children == null || node.children.size() == 0) return;
//
//        for (Node child : node.children) {
//            preorder(child, list);
//        }
//    }


}
