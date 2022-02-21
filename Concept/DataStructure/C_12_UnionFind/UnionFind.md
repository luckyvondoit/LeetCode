## 需求分析

![image-20211129210512096](images/image-20211129210512096.png)

## 并查集（Union Find）

![image-20211129210557234](images/image-20211129210557234.png)

### 如何存储数据？

![image-20211129210657540](images/image-20211129210657540.png)

### 接口定义

![image-20211129210739250](images/image-20211129210739250.png)

### 初始化

![image-20211129210807793](images/image-20211129210807793.png)

### Quick Find

#### Union

![image-20211129210908642](images/image-20211129210908642.png)

![image-20211129210933934](images/image-20211129210933934.png)

![image-20211129211013915](images/image-20211129211013915.png)

#### Find

![image-20211129211051072](images/image-20211129211051072.png)

### Quick Union

#### Union

![image-20211129211136140](images/image-20211129211136140.png)

![image-20211129211155812](images/image-20211129211155812.png)

![image-20211129211253712](images/image-20211129211253712.png)

#### Find

![image-20211129211400072](images/image-20211129211400072.png)

#### 优化

![image-20211129211454349](images/image-20211129211454349.png)

##### 基于size的优化

![image-20211129211533632](images/image-20211129211533632.png)

![image-20211129211555023](images/image-20211129211555023.png)

##### 基于rank的优化

![image-20211129211638415](images/image-20211129211638415.png)

##### 路径压缩（Path Compression）

![image-20211129212238484](images/image-20211129212238484.png)

![image-20211129212300956](images/image-20211129212300956.png)

##### 路径分裂（Раth Ѕрlіtіng）

![image-20211129212417252](images/image-20211129212417252.png)

##### 路径减半（Path Halving）

![image-20211129212514416](images/image-20211129212514416.png)

### 总结

![image-20211129212713646](images/image-20211129212713646.png)

### 自定义类型

![image-20211129214001878](images/image-20211129214001878.png)