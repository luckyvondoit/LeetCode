package DataStructure.BinaryTree;

import java.util.IllegalFormatCodePointException;
import java.util.LinkedList;
import java.util.List;

public class _0589_N叉树的前序遍历 {
    public abstract class Node {
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
    };
    public List<Integer> preorder(Node root) {
        List<Integer> list = new LinkedList<>();
        if (root == null) return list;
        preorder(root, list);
        return list;
    }

    private void preorder(Node root, List<Integer> list) {
        if (root == null) return;
        list.add(root.val);
        for (Node node: root.children) {
            preorder(node, list);
        }
    }

}
