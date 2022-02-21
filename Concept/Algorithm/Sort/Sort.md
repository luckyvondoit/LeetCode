## 排序（Sorting）

### 10大排序算法

![image-20220220134626020](images/image-20220220134626020.png)

#### 排序算法的稳定性（Stability）

![image-20220220135040009](images/image-20220220135040009.png)

#### 原地算法（In-place Algorithm）

![image-20220220135123824](images/image-20220220135123824.png)

### 冒泡排序（Bubble Sort）

![image-20220220134718529](images/image-20220220134718529.png)

#### 优化①

![image-20220220134848118](images/image-20220220134848118.png)

#### 优化②

![image-20220220134936807](images/image-20220220134936807.png)

### 选择排序（Selection Sort）

![image-20220220135233599](images/image-20220220135233599.png)

### 堆排序（Heap Sort）

![image-20220220135454946](images/image-20220220135454946.png)

#### 实现

![image-20220220135551041](images/image-20220220135551041.png)

### 插入排序（Insertion Sort）

![image-20220220135627859](images/image-20220220135627859.png)

![image-20220220135831050](images/image-20220220135831050.png)

#### 逆序对（Inversion）

![image-20220220135911473](images/image-20220220135911473.png)

#### 优化

![image-20220220140713916](images/image-20220220140713916.png)

#### 二分搜索（Binary Search）

![image-20220220140758436](images/image-20220220140758436.png)

![image-20220220140832503](images/image-20220220140832503.png)

![image-20220220140854519](images/image-20220220140854519.png)

![image-20220220140920069](images/image-20220220140920069.png)

#### 二分搜索优化

![image-20220220140950085](images/image-20220220140950085.png)

![image-20220220141005257](images/image-20220220141005257.png)

##### 实例

![image-20220220141024899](images/image-20220220141024899.png)

![image-20220220141117394](images/image-20220220141117394.png)

![image-20220220141134183](images/image-20220220141134183.png)

##### 实现

![image-20220220141303600](images/image-20220220141303600.png)

### 归并排序（Merge Sort）

![image-20220220151310818](images/image-20220220151310818.png)

#### divide

![image-20220220151459950](images/image-20220220151459950.png)

#### merge

![image-20220220151615207](images/image-20220220151615207.png)

##### 细节

![image-20220220151708048](images/image-20220220151708048.png)

![image-20220220151851472](images/image-20220220151851472.png)

##### 左边先结束

![image-20220220152024761](images/image-20220220152024761.png)

##### 右边先结束

![image-20220220152052420](images/image-20220220152052420.png)

##### 实现

![image-20220220152209083](images/image-20220220152209083.png)

#### 复杂度分析

![image-20220220152434908](images/image-20220220152434908.png)

#### 常见的递推式与复杂度

![image-20220220153000780](images/image-20220220153000780.png)

#### 作业

- 合并两个有序数组
  - https://leetcode-cn.com/problems/merge-sorted-array/

- 合并两个有序链表
  - https://leetcode-cn.com/problems/merge-two-sorted-lists/comments/

- 合并K个有序链表
  - https://leetcode-cn.com/problems/merge-k-sorted-lists/

### 快速排序（Quick Sort）

![image-20220220153246709](images/image-20220220153246709.png)

#### 执行流程

![image-20220220153344559](images/image-20220220153344559.png)

#### 轴点构造

![image-20220220153552831](images/image-20220220153552831.png)

#### 时间复杂度

![image-20220220153933716](images/image-20220220153933716.png)

#### 实现

![image-20220220154031850](images/image-20220220154031850.png)

#### 与轴点相等的元素

![image-20220220154121442](images/image-20220220154121442.png)

![image-20220220154343542](images/image-20220220154343542.png)

### 希尔排序（Shell Sort）

![image-20220220154916767](images/image-20220220154916767.png)

#### 实例

![image-20220220155025627](images/image-20220220155025627.png)

![image-20220220155126023](images/image-20220220155126023.png)

![image-20220220155144031](images/image-20220220155144031.png)

![image-20220220155207185](images/image-20220220155207185.png)

![image-20220220155458031](images/image-20220220155458031.png)

#### 实现

![image-20220220160349198](images/image-20220220160349198.png)

#### 步长序列

![image-20220220161631856](images/image-20220220161631856.png)

![image-20220220161707176](images/image-20220220161707176.png)

### 计数排序（Counting Sort）

![image-20220220162428546](images/image-20220220162428546.png)

#### 最简单的实现

![image-20220220162520556](images/image-20220220162520556.png)

#### 改进思路

![image-20220220163124670](images/image-20220220163124670.png)

> **注意：**
>
> 1. 次数每次都会减一（注意黄色格子数字变化）
> 2. 数组倒着遍历是为了稳定性（原数组在后面的7，排序后还在后面）

![image-20220220164045769](images/image-20220220164045769.png)

![image-20220220164206505](images/image-20220220164206505.png)

![image-20220220164224762](images/image-20220220164224762.png)

![image-20220220164241155](images/image-20220220164241155.png)

![image-20220220164259470](images/image-20220220164259470.png)

#### 改进实现

![image-20220220164337725](images/image-20220220164337725.png)

#### 对自定义对象进行排序

![image-20220220164409790](images/image-20220220164409790.png)

![image-20220220164431099](images/image-20220220164431099.png)

### 基数排序（Radix Sort）

![image-20220220170329392](images/image-20220220170329392.png)

> 不能先从高位，位数不够，高位都是0

#### 实现

![image-20220220170621980](images/image-20220220170621980.png)

![image-20220220170636749](images/image-20220220170636749.png)

#### 另一种思路

![image-20220220170949168](images/image-20220220170949168.png)

![image-20220220171008658](images/image-20220220171008658.png)

### 桶排序（Bucket Sort）

![image-20220220171722602](images/image-20220220171722602.png)

实现

![image-20220220171938671](images/image-20220220171938671.png)

### 史上“最强”排序 – 休眠排序

![image-20220220172243213](images/image-20220220172243213.png)