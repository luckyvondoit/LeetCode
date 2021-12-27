package DataStructure.Map;

import java.util.LinkedList;
import java.util.Objects;
import java.util.Queue;

import Common.Printer.BinaryTreeInfo;
import Common.Printer.BinaryTrees;

public class HashMap<K, V> implements Map<K, V> {
    private static final boolean RED = false;
    private static final boolean BLACK = true;
    private int size;
    private Node<K, V>[] table;
    private static final int DEFAULT_CAPACITY = 1 << 4;
    private static final float DEFAULT_LOAD_FACTOR = 0.75F;

    public HashMap() {
        table = new Node[DEFAULT_CAPACITY];
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public void clear() {
        if (size != 0) {
            size = 0;

            for(int i = 0; i < table.length; ++i) {
                table[i] = null;
            }

        }
    }

    @Override
    public V put(K key, V value) {
        resize();
        int index = index(key);
        Node<K, V> root = table[index];
        if (root == null) {
            root = createNode(key, value, null);
            table[index] = root;
            ++size;
            fixAfterPut(root);
            return null;
        } else {
            Node<K, V> node = root;
            int cmp = 0;
            K k1 = key;
            int h1 = hash(key);
            Node<K, V> result = null;
            boolean searched = false;

            Node<K, V> parent;
            do {
                parent = node;
                K k2 = node.key;
                int h2 = node.hash;
                if (h1 > h2) {
                    cmp = 1;
                } else if (h1 < h2) {
                    cmp = -1;
                } else if (Objects.equals(k1, k2)) {
                    cmp = 0;
                } else if (k1 == null || k2 == null || !(k1 instanceof Comparable) || k1.getClass() != k2.getClass() || (cmp = ((Comparable)k1).compareTo(k2)) == 0) {
                    if (searched) {
                        cmp = System.identityHashCode(k1) - System.identityHashCode(k2);
                    } else if ((node.left == null || (result = node(node.left, k1)) == null) && (node.right == null || (result = node(node.right, k1)) == null)) {
                        searched = true;
                        cmp = System.identityHashCode(k1) - System.identityHashCode(k2);
                    } else {
                        node = result;
                        cmp = 0;
                    }
                }

                if (cmp > 0) {
                    node = node.right;
                } else {
                    if (cmp >= 0) {
                        V oldValue = node.value;
                        node.key = key;
                        node.value = value;
                        node.hash = h1;
                        return oldValue;
                    }

                    node = node.left;
                }
            } while(node != null);

            Node<K, V> newNode = createNode(key, value, parent);
            if (cmp > 0) {
                parent.right = newNode;
            } else {
                parent.left = newNode;
            }

            ++size;
            fixAfterPut(newNode);
            return null;
        }
    }

    @Override
    public V remove(K key) {
        return remove(node(key));
    }

    @Override
    public V get(K key) {
        Node<K, V> node = node(key);
        return node != null ? node.value : null;
    }

    @Override
    public boolean containsKey(K key) {
        return node(key) != null;
    }

    @Override
    public boolean containsValue(V value) {
        if (size != 0) {
            Queue<Node<K, V>> queue = new LinkedList<>();

            for (int i = 0; i < table.length; ++i) {
                if (table[i] != null) {
                    queue.offer(table[i]);

                    while (!queue.isEmpty()) {
                        Node<K, V> node = (Node) queue.poll();
                        if (Objects.equals(value, node.value)) {
                            return true;
                        }

                        if (node.left != null) {
                            queue.offer(node.left);
                        }

                        if (node.right != null) {
                            queue.offer(node.right);
                        }
                    }
                }
            }

        }
        return false;
    }

    @Override
    public void traversal(Visitor<K, V> visitor) {
        if (size != 0 && visitor != null) {
            Queue<Node<K, V>> queue = new LinkedList();

            for(int i = 0; i < table.length; ++i) {
                if (table[i] != null) {
                    queue.offer(table[i]);

                    while(!queue.isEmpty()) {
                        Node<K, V> node = (Node)queue.poll();
                        if (visitor.visit(node.key, node.value)) {
                            return;
                        }

                        if (node.left != null) {
                            queue.offer(node.left);
                        }

                        if (node.right != null) {
                            queue.offer(node.right);
                        }
                    }
                }
            }

        }
    }

    public void print() {
        if (size != 0) {
            for(int i = 0; i < table.length; ++i) {
                final Node<K, V> root = table[i];
                System.out.println("【index = " + i + "】");
                BinaryTrees.println(new BinaryTreeInfo() {
                    public Object string(Object node) {
                        return node;
                    }

                    public Object root() {
                        return root;
                    }

                    public Object right(Object node) {
                        return ((Node)node).right;
                    }

                    public Object left(Object node) {
                        return ((Node)node).left;
                    }
                });
                System.out.println("---------------------------------------------------");
            }

        }
    }

    protected Node<K, V> createNode(K key, V value, Node<K, V> parent) {
        return new Node(key, value, parent);
    }

    protected void afterRemove(Node<K, V> willNode, Node<K, V> removedNode) {
    }

    private void resize() {
        if (!((float)(size / table.length) <= 0.75F)) {
            Node[] oldTable = table;
            table = new Node[oldTable.length << 1];
            Queue<Node<K, V>> queue = new LinkedList<>();

            for(int i = 0; i < oldTable.length; ++i) {
                if (oldTable[i] != null) {
                    queue.offer(oldTable[i]);

                    Node<K, V> node;
                    for(; !queue.isEmpty(); moveNode(node)) {
                        node = queue.poll();
                        if (node.left != null) {
                            queue.offer(node.left);
                        }

                        if (node.right != null) {
                            queue.offer(node.right);
                        }
                    }
                }
            }

        }
    }

    private void moveNode(Node<K, V> newNode) {
        newNode.parent = null;
        newNode.left = null;
        newNode.right = null;
        newNode.color = false;
        int index = index(newNode);
        Node<K, V> root = table[index];
        if (root == null) {
            table[index] = newNode;
            fixAfterPut(newNode);
        } else {
            Node<K, V> node = root;
            int cmp = 0;
            K k1 = newNode.key;
            int h1 = newNode.hash;

            Node parent;
            do {
                parent = node;
                K k2 = node.key;
                int h2 = node.hash;
                if (h1 > h2) {
                    cmp = 1;
                } else if (h1 < h2) {
                    cmp = -1;
                } else if (k1 == null || k2 == null || !(k1 instanceof Comparable) || k1.getClass() != k2.getClass() || (cmp = ((Comparable)k1).compareTo(k2)) == 0) {
                    cmp = System.identityHashCode(k1) - System.identityHashCode(k2);
                }

                if (cmp > 0) {
                    node = node.right;
                } else if (cmp < 0) {
                    node = node.left;
                }
            } while(node != null);

            newNode.parent = parent;
            if (cmp > 0) {
                parent.right = newNode;
            } else {
                parent.left = newNode;
            }

            fixAfterPut(newNode);
        }
    }

    protected V remove(Node<K, V> node) {
        if (node == null) {
            return null;
        } else {
            Node<K, V> willNode = node;
            --size;
            V oldValue = node.value;
            Node<K, V> replacement;
            if (node.hasTwoChildren()) {
                replacement = successor(node);
                node.key = replacement.key;
                node.value = replacement.value;
                node.hash = replacement.hash;
                node = replacement;
            }

            replacement = node.left != null ? node.left : node.right;
            int index = index(node);
            if (replacement != null) {
                replacement.parent = node.parent;
                if (node.parent == null) {
                    table[index] = replacement;
                } else if (node == node.parent.left) {
                    node.parent.left = replacement;
                } else {
                    node.parent.right = replacement;
                }

                fixAfterRemove(replacement);
            } else if (node.parent == null) {
                table[index] = null;
            } else {
                if (node == node.parent.left) {
                    node.parent.left = null;
                } else {
                    node.parent.right = null;
                }

                fixAfterRemove(node);
            }

            afterRemove(willNode, node);
            return oldValue;
        }
    }

    private Node<K, V> successor(Node<K, V> node) {
        if (node == null) {
            return null;
        } else {
            Node<K, V> p = node.right;
            if (p != null) {
                while(p.left != null) {
                    p = p.left;
                }

                return p;
            } else {
                while(node.parent != null && node == node.parent.right) {
                    node = node.parent;
                }

                return node.parent;
            }
        }
    }

    private Node<K, V> node(K key) {
        Node<K, V> root = table[index(key)];
        return root == null ? null : node(root, key);
    }

    private Node<K, V> node(Node<K, V> node, K k1) {
        int h1 = hash(k1);
        Node<K, V> result = null;
        boolean var5 = false;

        while(true) {
            while(node != null) {
                K k2 = node.key;
                int h2 = node.hash;
                if (h1 > h2) {
                    node = node.right;
                } else if (h1 < h2) {
                    node = node.left;
                } else {
                    if (Objects.equals(k1, k2)) {
                        return node;
                    }

                    int cmp;
                    if (k1 != null && k2 != null && k1 instanceof Comparable && k1.getClass() == k2.getClass() && (cmp = ((Comparable)k1).compareTo(k2)) != 0) {
                        node = cmp > 0 ? node.right : node.left;
                    } else {
                        if (node.right != null && (result = node(node.right, k1)) != null) {
                            return result;
                        }

                        node = node.left;
                    }
                }
            }

            return null;
        }
    }

    private int index(K key) {
        return hash(key) & table.length - 1;
    }

    private int hash(K key) {
        if (key == null) {
            return 0;
        } else {
            int hash = key.hashCode();
            return hash ^ hash >>> 16;
        }
    }

    private int index(Node<K, V> node) {
        return node.hash & table.length - 1;
    }

    private void fixAfterRemove(Node<K, V> node) {
        if (isRed(node)) {
            black(node);
        } else {
            Node<K, V> parent = node.parent;
            if (parent != null) {
                boolean left = parent.left == null || node.isLeftChild();
                Node<K, V> sibling = left ? parent.right : parent.left;
                boolean parentBlack;
                if (left) {
                    if (isRed(sibling)) {
                        black(sibling);
                        red(parent);
                        rotateLeft(parent);
                        sibling = parent.right;
                    }

                    if (isBlack(sibling.left) && isBlack(sibling.right)) {
                        parentBlack = isBlack(parent);
                        black(parent);
                        red(sibling);
                        if (parentBlack) {
                            fixAfterRemove(parent);
                        }
                    } else {
                        if (isBlack(sibling.right)) {
                            rotateRight(sibling);
                            sibling = parent.right;
                        }

                        color(sibling, colorOf(parent));
                        black(sibling.right);
                        black(parent);
                        rotateLeft(parent);
                    }
                } else {
                    if (isRed(sibling)) {
                        black(sibling);
                        red(parent);
                        rotateRight(parent);
                        sibling = parent.left;
                    }

                    if (isBlack(sibling.left) && isBlack(sibling.right)) {
                        parentBlack = isBlack(parent);
                        black(parent);
                        red(sibling);
                        if (parentBlack) {
                            fixAfterRemove(parent);
                        }
                    } else {
                        if (isBlack(sibling.left)) {
                            rotateLeft(sibling);
                            sibling = parent.left;
                        }

                        color(sibling, colorOf(parent));
                        black(sibling.left);
                        black(parent);
                        rotateRight(parent);
                    }
                }

            }
        }
    }

    private void fixAfterPut(Node<K, V> node) {
        Node<K, V> parent = node.parent;
        if (parent == null) {
            black(node);
        } else if (!isBlack(parent)) {
            Node<K, V> uncle = parent.sibling();
            Node<K, V> grand = red(parent.parent);
            if (isRed(uncle)) {
                black(parent);
                black(uncle);
                fixAfterPut(grand);
            } else {
                if (parent.isLeftChild()) {
                    if (node.isLeftChild()) {
                        black(parent);
                    } else {
                        black(node);
                        rotateLeft(parent);
                    }

                    rotateRight(grand);
                } else {
                    if (node.isLeftChild()) {
                        black(node);
                        rotateRight(parent);
                    } else {
                        black(parent);
                    }

                    rotateLeft(grand);
                }

            }
        }
    }

    private void rotateLeft(Node<K, V> grand) {
        Node<K, V> parent = grand.right;
        Node<K, V> child = parent.left;
        grand.right = child;
        parent.left = grand;
        afterRotate(grand, parent, child);
    }

    private void rotateRight(Node<K, V> grand) {
        Node<K, V> parent = grand.left;
        Node<K, V> child = parent.right;
        grand.left = child;
        parent.right = grand;
        afterRotate(grand, parent, child);
    }

    private void afterRotate(Node<K, V> grand, Node<K, V> parent, Node<K, V> child) {
        parent.parent = grand.parent;
        if (grand.isLeftChild()) {
            grand.parent.left = parent;
        } else if (grand.isRightChild()) {
            grand.parent.right = parent;
        } else {
            table[index(grand)] = parent;
        }

        if (child != null) {
            child.parent = grand;
        }

        grand.parent = parent;
    }

    private Node<K, V> color(Node<K, V> node, boolean color) {
        if (node == null) {
            return null;
        } else {
            node.color = color;
            return node;
        }
    }

    private Node<K, V> red(Node<K, V> node) {
        return color(node, false);
    }

    private Node<K, V> black(Node<K, V> node) {
        return color(node, true);
    }

    private boolean colorOf(Node<K, V> node) {
        return node == null ? true : node.color;
    }

    private boolean isBlack(Node<K, V> node) {
        return colorOf(node);
    }

    private boolean isRed(Node<K, V> node) {
        return !colorOf(node);
    }

    protected static class Node<K, V> {
        int hash;
        K key;
        V value;
        boolean color = false;
        Node<K, V> left;
        Node<K, V> right;
        Node<K, V> parent;

        public Node(K key, V value, Node<K, V> parent) {
            this.key = key;
            int hash = key == null ? 0 : key.hashCode();
            this.hash = hash ^ hash >>> 16;
            this.value = value;
            this.parent = parent;
        }

        public boolean hasTwoChildren() {
            return left != null && right != null;
        }

        public boolean isLeftChild() {
            return parent != null && this == parent.left;
        }

        public boolean isRightChild() {
            return parent != null && this == parent.right;
        }

        public Node<K, V> sibling() {
            if (isLeftChild()) {
                return parent.right;
            } else {
                return isRightChild() ? parent.left : null;
            }
        }

        public String toString() {
            return "Node_" + key + "_" + value;
        }
    }
}
