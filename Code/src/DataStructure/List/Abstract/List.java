package DataStructure.List.Abstract;


public interface List<E> {
    //接口中默认是static final
    int ELEMENT_NOT_FOUND = -1;

    /**
     * 元素的数量
     * @return size
     */
    int size();

    /**
     * 是否为空
     */
    boolean isEmpty();

    /**
     * 清除所有元素
     */
    void clear();

    /**
     * 添加元素到尾部
     * @param element 添加的元素
     */
    void add(E element);

    /**
     * 在index位置插入一个元素
     * @param index 插入的位置
     * @param element 插入的元素
     */
    void add(int index, E element);

    /**
     * 删除index位置的元素
     * @param index 删除的位置
     * @return 删除的元素
     */
    E remove(int index);

    /**
     * 设置index位置的元素
     * @param index 修改元素位置
     * @param element 修改的元素
     * @return 原来的元素ֵ
     */
    E set(int index, E element);

    /**
     * 获取index位置的元素
     * @param index 元素位置
     * @return 原来的元素
     */
    E get(int index);

    /**
     * 查看元素的索引
     * @param element 查找的元素
     * @return 元素索引
     */
    int indexOf(E element);

    /**
     * 是否包含某个元素
     * @param element 要查找的元素
     * @return 是否包含
     */
    boolean contains(E element);



}
