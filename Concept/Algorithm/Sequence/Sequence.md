## 串（Sequence）

![image-20220220213204998](images/image-20220220213204998.png)

### 串匹配算法

![image-20220220213226850](images/image-20220220213226850.png)

### 蛮力（Brute Force）

![image-20220220213249702](images/image-20220220213249702.png)

#### 蛮力1 – 执行过程

![image-20220220213327981](images/image-20220220213327981.png)

![image-20220220213343744](images/image-20220220213343744.png)

#### 蛮力1 – 实现

![image-20220220213612897](images/image-20220220213612897.png)

#### 蛮力1 – 优化

![image-20220220213634200](images/image-20220220213634200.png)

#### 蛮力1 – 优化实现

![image-20220220213658312](images/image-20220220213658312.png)

#### 蛮力2 – 执行过程

![image-20220220213726113](images/image-20220220213726113.png)

![image-20220220213741176](images/image-20220220213741176.png)

#### 蛮力2 – 实现

![image-20220220213801471](images/image-20220220213801471.png)

#### 蛮力 – 性能分析

![image-20220220213825223](images/image-20220220213825223.png)

![image-20220220213838696](images/image-20220220213838696.png)

### KMP

![image-20220220213902624](images/image-20220220213902624.png)

#### 蛮力 vs KMP

![image-20220220213928177](images/image-20220220213928177.png)

#### KMP – next表的使用

![image-20220220213951963](images/image-20220220213951963.png)

![image-20220220214010957](images/image-20220220214010957.png)

#### KMP – 核心原理

![image-20220220214033952](images/image-20220220214033952.png)

#### KMP – 真前缀后缀的最大公共子串长度

![image-20220220214104260](images/image-20220220214104260.png)

#### KMP – 得到next表

![image-20220220214126665](images/image-20220220214126665.png)

#### KMP – 负1的精妙之处

![image-20220220214148320](images/image-20220220214148320.png)

#### KMP – 主算法实现

![image-20220220214207847](images/image-20220220214207847.png)

#### KMP – 为什么是“最大“公共子串长度？

![image-20220220214229702](images/image-20220220214229702.png)

#### KMP – next表的构造思路

![image-20220220214251607](images/image-20220220214251607.png)

#### KMP – next表的代码实现

![image-20220220214312209](images/image-20220220214312209.png)

#### KMP – next表的不足之处

![image-20220220214335036](images/image-20220220214335036.png)

#### KMP – next表的优化思路

![image-20220220214400442](images/image-20220220214400442.png)

#### KMP – next表的优化实现

![image-20220220214421574](images/image-20220220214421574.png)

#### KMP – next表的优化效果

![image-20220220214440864](images/image-20220220214440864.png)

#### KMP – 性能分析

![image-20220220214503125](images/image-20220220214503125.png)

#### 蛮力 vs KMP

![image-20220220214531673](images/image-20220220214531673.png)