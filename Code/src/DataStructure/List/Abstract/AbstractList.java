package DataStructure.List.Abstract;

public abstract class AbstractList<E> implements List<E>  {
    /**
     * 元素的数量
     */
    protected int size;

    /**
     * 元素的数量
     * @return size
     */
    public int size() {
        return size;
    }

    /**
     * 是否为空
     * @return isEmpty
     */
    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * 是否包含某个元素
     * @param element 查询的元素
     * @return isContain
     */
    public boolean contains(E element) {
        return indexOf(element) != ELEMENT_NOT_FOUND;
    }

    /**
     * 添加元素到尾部
     * @param element 添加的元素
     */
    public void add(E element) {
        add(size, element);
    }

    /**
     * 越界异常
     * @param index 越界的索引
     */
    protected void outOfBounds(int index) {
        throw new IndexOutOfBoundsException("Index:" + index + ", Size:" + size);
    }

    /**
     * 检测是否越界
     * @param index 检查的索引
     */
    protected void rangeCheck(int index) {
        if (index < 0 || index >= size) {
            outOfBounds(index);
        }
    }

    /**
     * 检测添加是否越界
     * @param index 要添加的索引
     */
    protected void rangeCheckForAdd(int index) {
        if (index < 0 || index > size) {
            outOfBounds(index);
        }
    }
}
