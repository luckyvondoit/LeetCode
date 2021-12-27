package DataStructure.Map;

public interface Map<K, V> {
    int size();
    boolean isEmpty();
    void clear();

    V put(K var1, V var2);
    V remove(K var1);
    V get(K var1);

    boolean containsKey(K var1);
    boolean containsValue(V var1);

    void traversal(Map.Visitor<K, V> var1);

    public abstract static class Visitor<K, V> {
        boolean stop;

        public Visitor() {
        }

        public abstract boolean visit(K var1, V var2);
    }
}
