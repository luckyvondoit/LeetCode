## 链表（Linked List）

![image-20211124165017994](images/image-20211124165017994.png)

### 链表的设计

![image-20211124165227018](images/image-20211124165227018.png)

### 接口设计

![image-20211124165302249](images/image-20211124165302249.png)

### 清空元素 - clear()

![image-20211124165338988](images/image-20211124165338988.png)

### 添加元素

#### 添加元素 - add(int index, E element)

![image-20211124165429021](images/image-20211124165429021.png)

#### node方法用于获取index位置的节点

![image-20211124165517511](images/image-20211124165517511.png)

#### 注意0位置

![image-20211124165743167](images/image-20211124165743167.png)

### 删除元素

#### 删除元素 - remove(int index)

![image-20211124165845098](images/image-20211124165845098.png)

#### 注意0位置

![image-20211124165924267](images/image-20211124165924267.png)

### 练习

#### 删除链表中的节点

- https://leetcode-cn.com/problems/delete-node-in-a-linked-list/

#### 翻转一个链表

- https://leetcode-cn.com/problems/reverse-linked-list/

#### 判断一个链表是否有环

- https://leetcode-cn.com/problems/linked-list-cycle/

### 虚拟头结点

![image-20211124170906272](images/image-20211124170906272.png)

#### node方法

![image-20211124170933010](images/image-20211124170933010.png)

#### 添加、删除

![image-20211124171006148](images/image-20211124171006148.png)

### 复杂度分析

- 最好情况复杂度
- 最坏情况复杂度
- 平均情况复杂度

#### 数组的随机访问

![image-20211124171125895](images/image-20211124171125895.png)

#### 动态数组、链表复杂度分析

![image-20211124171238490](images/image-20211124171238490.png)

#### 动态数组add(E element)复杂度分析

![image-20211124171328708](images/image-20211124171328708.png)

#### 动态数组的缩容

![image-20211124171447524](images/image-20211124171447524.png)

### 双向链表

![image-20211124171632948](images/image-20211124171632948.png)

#### 只有一个元素

![image-20211124171659405](images/image-20211124171659405.png)

#### node方法

![image-20211124171719006](images/image-20211124171719006.png)

#### add(int index, E element)

![image-20211124171754987](images/image-20211124171754987.png)

![image-20211124171814868](images/image-20211124171814868.png)

#### remove(int index)

![image-20211124171854783](images/image-20211124171854783.png)

![image-20211124171912689](images/image-20211124171912689.png)

#### 双向链表 vs 单向链表

![image-20211124171959342](images/image-20211124171959342.png)

#### 双向链表 vs 动态数组

![image-20211124172042721](images/image-20211124172042721.png)

#### LinkedList源码分析

![image-20211124172208887](images/image-20211124172208887.png)

### 单向循环链表

![image-20211124172319702](images/image-20211124172319702.png)

#### 只有1个节点

![image-20211124172354324](images/image-20211124172354324.png)

#### add(int index, E element)

![image-20211124172502039](images/image-20211124172424193.png)

![image-20211124172502039](images/image-20211124172502039.png)

#### remove(int index)

![image-20211124172638273](images/image-20211124172638273.png)

![image-20211124172701380](images/image-20211124172701380.png)

### 双向循环链表

![image-20211124172739389](images/image-20211124172739389.png)

#### 只有1个节点

![image-20211124172811450](images/image-20211124172811450.png)

#### add(int index, E element)

![image-20211124172844368](images/image-20211124172844368.png)

![image-20211124172902610](images/image-20211124172902610.png)

#### remove(int index)

![image-20211124172936449](images/image-20211124172936449.png)

![image-20211124172950549](images/image-20211124172950549.png)

### 练习

#### 约瑟夫问题(Josephus Problem)

![image-20211124173058670](images/image-20211124173058670.png)

![image-20211124173115207](images/image-20211124173115207.png)

### 静态链表

![image-20211124173147827](images/image-20211124173147827.png)

### 作业

#### 移除链表中的元素

- https://leetcode-cn.com/problems/remove-linked-list-elements/

#### 删除排序链表中的重复元素

- https://leetcode-cn.com/problems/remove-duplicates-from-sorted-list/

#### 链表中间节点

- https://leetcode-cn.com/problems/middle-of-the-linked-list/solution/

### 思考

ArrayList是否能进一步优化？

- 循环数组