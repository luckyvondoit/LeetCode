package DataStructure.Map;

import java.util.Comparator;
import java.util.LinkedList;
import java.util.Objects;
import java.util.Queue;

public class TreeMap<K, V> implements Map<K, V> {
    private static final boolean RED = false;
    private static final boolean BLACK = true;
    private int size;
    private Node<K, V> root;
    private final Comparator<K> comparator;

    public TreeMap() {
        this(null);
    }

    public TreeMap(Comparator<K> comparator) {
        this.comparator = comparator;
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public void clear() {
        root = null;
        size = 0;
    }

    public V put(K key, V value) {
        keyNotNullCheck(key);
        if (root == null) {
            root = new Node<>(key, value, null);
            ++size;
            afterPut(root);
            return null;
        } else {
            Node<K, V> parent;
            Node<K, V> node = root;
            boolean var5 = false;

            int cmp;
            do {
                cmp = compare(key, node.key);
                parent = node;
                if (cmp > 0) {
                    node = node.right;
                } else {
                    if (cmp >= 0) {
                        node.key = key;
                        V oldValue = node.value;
                        node.value = value;
                        return oldValue;
                    }

                    node = node.left;
                }
            } while(node != null);

            Node<K, V> newNode = new Node<>(key, value, parent);
            if (cmp > 0) {
                parent.right = newNode;
            } else {
                parent.left = newNode;
            }

            ++size;
            afterPut(newNode);
            return null;
        }
    }

    public V remove(K key) {
        return remove(node(key));
    }

    public V get(K key) {
        Node<K, V> node = node(key);
        return node != null ? node.value : null;
    }

    public boolean containsKey(K key) {
        return node(key) != null;
    }

    public boolean containsValue(V value) {
        if (root != null) {
            Queue<Node<K, V>> queue = new LinkedList<>();
            queue.offer(root);

            while (!queue.isEmpty()) {
                Node<K, V> node = queue.poll();
                if (valEquals(value, node.value)) {
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
        return false;
    }

    public void traversal(Visitor<K, V> visitor) {
        if (visitor == null) return;
        traversal(root, visitor);
    }

    private void traversal(Node<K, V> node, Visitor<K, V> visitor) {
        if (node == null || visitor.stop) return;
        traversal(node.left, visitor);
        if (visitor.stop) return;
         visitor.stop = visitor.visit(node.key, node.value);
         traversal(node.right, visitor);
    }

    private boolean valEquals(V v1, V v2) {
        return Objects.equals(v1, v2);
    }

    private V remove(Node<K, V> node) {
        if (node == null) {
            return null;
        } else {
            --size;
            V oldValue = node.value;
            Node<K, V> replacement;
            if (node.hasTwoChildren()) {
                replacement = successor(node);
                node.key = replacement.key;
                node.value = replacement.value;
                node = replacement;
            }

            replacement = node.left != null ? node.left : node.right;
            if (replacement != null) {
                replacement.parent = node.parent;
                if (node.parent == null) {
                    root = replacement;
                } else if (node == node.parent.left) {
                    node.parent.left = replacement;
                } else {
                    node.parent.right = replacement;
                }

                afterRemove(replacement);
            } else if (node.parent == null) {
                root = null;
            } else {
                if (node == node.parent.left) {
                    node.parent.left = null;
                } else {
                    node.parent.right = null;
                }

                afterRemove(node);
            }

            return oldValue;
        }
    }

    private void afterRemove(Node<K, V> node) {
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
                            afterRemove(parent);
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
                            afterRemove(parent);
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

    private Node<K, V> predecessor(Node<K, V> node) {
        if (node == null) {
            return null;
        } else {
            Node<K, V> p = node.left;
            if (p != null) {
                while(p.right != null) {
                    p = p.right;
                }

                return p;
            } else {
                while(node.parent != null && node == node.parent.left) {
                    node = node.parent;
                }

                return node.parent;
            }
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
        Node<K, V> node = root;

        while(node != null) {
            int cmp = compare(key, node.key);
            if (cmp == 0) {
                return node;
            }

            if (cmp > 0) {
                node = node.right;
            } else {
                node = node.left;
            }
        }

        return null;
    }

    private void afterPut(Node<K, V> node) {
        Node<K, V> parent = node.parent;
        if (parent == null) {
            black(node);
        } else if (!isBlack(parent)) {
            Node<K, V> uncle = parent.sibling();
            Node<K, V> grand = red(parent.parent);
            if (isRed(uncle)) {
                black(parent);
                black(uncle);
                afterPut(grand);
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
            root = parent;
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

    private int compare(K e1, K e2) {
        return comparator != null ? comparator.compare(e1, e2) : ((Comparable)e1).compareTo(e2);
    }

    private void keyNotNullCheck(K key) {
        if (key == null) {
            throw new IllegalArgumentException("key must not be null");
        }
    }

    private static class Node<K, V> {
        K key;
        V value;
        boolean color = false;
        Node<K, V> left;
        Node<K, V> right;
        Node<K, V> parent;

        public Node(K key, V value, Node<K, V> parent) {
            this.key = key;
            this.value = value;
            this.parent = parent;
        }

        public boolean isLeaf() {
            return left == null && right == null;
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
    }
}