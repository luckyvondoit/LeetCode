package Algorithm.LRU缓存_146;

import java.util.HashMap;

public class LRUCache {
    private HashMap<Integer, Node> map;
    private int size;

    /** 虚拟头结点 */
    private Node first;
    /** 虚拟尾结点 */
    private Node last;




    public LRUCache(int capacity) {
        this.size = capacity;
        map = new HashMap<>(capacity);

        first = new Node();
        last = new Node();
        first.next =last;
        last.prev = first;
    }

    public int get(int key) {
        Node node = map.get(key);
        if (node == null) return -1;
        removeNode(node);
        addFirst(node);
        return node.v;
    }

    public void put(int key, int value) {
        Node node = map.get(key);
        if (node != null) {
            node.v = value;
            removeNode(node);
            addFirst(node);
        } else {
            node = new Node(key, value);
            if (map.size() == size) {
                removeNode(map.remove(last.prev.k));
            }
            map.put(key, node);
            addFirst(node);
        }
    }

    private void removeNode(Node node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }

    private void addFirst(Node node) {
        node.next = first.next;
        first.next.prev = node;

        node.prev = first;
        first.next = node;
    }


    private static class Node {
        int k;
        int v;
        Node prev;
        Node next;

        public Node(int k, int v) {
            this.k = k;
            this.v = v;
        }

        public Node() {
        }
    }
}
