## 递归（Recursion）

![image-20220220194814408](images/image-20220220194814408.png)

### 函数的调用过程

![image-20220220194930904](images/image-20220220194930904.png)

### 函数的递归调用过程

![image-20220220195034005](images/image-20220220195034005.png)

### 实例分析

![image-20220220195146085](images/image-20220220195146085.png)

### 递归的基本思想

![image-20220220195258066](images/image-20220220195258066.png)

### 递归的使用套路

![image-20220220195333849](images/image-20220220195333849.png)

### 练习1 – 斐波那契数列

![image-20220220195442369](images/image-20220220195442369.png)

#### fib函数的调用过程

![image-20220220195627019](images/image-20220220195627019.png)

#### fib优化1 – 记忆化

![image-20220220195729051](images/image-20220220195729051.png)

#### fib优化2 - 去除递归

![image-20220220195829118](images/image-20220220195829118.png)

#### fib优化3 - 滚动数组

![image-20220220195904105](images/image-20220220195904105.png)

#### fib优化4 – 位运算取代模运算

![image-20220220200014098](images/image-20220220200014098.png)

#### fib优化5 - 使用变量

![image-20220220200052186](images/image-20220220200052186.png)

#### fib优化6 - 特征方程

![image-20220220200144645](images/image-20220220200144645.png)

### 练习2 – 上楼梯（跳台阶）

![image-20220220200222363](images/image-20220220200222363.png)

![image-20220220200235740](images/image-20220220200235740.png)

### 练习3 – 汉诺塔（Hanoi）

![image-20220220200303661](images/image-20220220200303661.png)

#### 1个盘子

![image-20220220200335404](images/image-20220220200335404.png)

#### 2个盘子

![image-20220220200356869](images/image-20220220200356869.png)

#### 3个盘子

![image-20220220200420370](images/image-20220220200420370.png)

![image-20220220200454937](images/image-20220220200454937.png)

#### 思路

![image-20220220200533175](images/image-20220220200533175.png)

#### 实现

![image-20220220200557048](images/image-20220220200557048.png)

### 递归转非递归

![image-20220220200735721](images/image-20220220200735721.png)

![image-20220220200813892](images/image-20220220201020417.png)

### 尾调用（Tail Call）

![image-20220220201053940](images/image-20220220201053940.png)

#### 下面代码不是尾调用

![image-20220220201139987](images/image-20220220201139987.png)

#### 尾调用优化（Tail Call Optimization）

![image-20220220201212402](images/image-20220220201212402.png)

##### 尾调用优化前的汇编代码（C++）

![image-20220220201324477](images/image-20220220201324477.png)

#### 尾调用优化后的汇编代码（C++）

![image-20220220201354971](images/image-20220220201354971.png)

#### 尾递归示例1 – 阶乘

![image-20220220201613235](images/image-20220220201613235.png)

#### 尾递归示例2 – 斐波那契数列

![image-20220220201646152](images/image-20220220201646152.png)