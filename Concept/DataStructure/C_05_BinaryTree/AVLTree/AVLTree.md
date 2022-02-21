## AVL树

![image-20211128152642817](images/image-20211128152642817.png)

![image-20211128152708015](images/image-20211128152708015.png)

### 平衡对比

![image-20211128152756894](images/image-20211128152756894.png)

### 简单的继承结构

![image-20211128152824796](images/image-20211128152824796.png)

### 添加导致的失衡

![image-20211128152854637](images/image-20211128152854637.png)

#### LL – 右旋转（单旋）

![image-20211128152926099](images/image-20211128152926099.png)

#### RR – 左旋转（单旋）

![image-20211128153012658](images/image-20211128153012658.png)

#### LR – RR左旋转， LL右旋转（双旋）

![image-20211128153108747](images/image-20211128153108747.png)

#### RL – LL右旋转， RR左旋转（双旋）

![image-20211128153145248](images/image-20211128153145248.png)

#### zig、 zag

![image-20211128153209138](images/image-20211128153209138.png)

#### 添加之后的修复

![image-20211128153250982](images/image-20211128153250982.png)

#### 旋转

![image-20211128153327084](images/image-20211128153327084.png)

#### 示例

![image-20211128153407851](images/image-20211128153407851.png)

![image-20211128153431599](images/image-20211128153431599.png)

#### 统一所有旋转操作

![image-20211128153458637](images/image-20211128153458637.png)

![image-20211128153526137](images/image-20211128153526137.png)

#### 独立出AVLNode

![image-20211128153600868](images/image-20211128153600868.png)

### 删除导致的失衡

![image-20211128153637476](images/image-20211128153637476.png)

#### LL – 右旋转（单旋）

![image-20211128153713391](images/image-20211128153713391.png)

#### RR – 左旋转（单旋）

![image-20211128153757351](images/image-20211128153757351.png)

#### LR – RR左旋转， LL右旋转（双旋）

![image-20211128153825071](images/image-20211128153825071.png)

#### RL – LL右旋转， RR左旋转（双旋）

![image-20211128153853694](images/image-20211128153853694.png)

#### 删除之后的修复

![image-20211128154027623](images/image-20211128154027623.png)

### 总结

![image-20211128154100061](images/image-20211128154100061.png)

### 作业

####  平衡二叉树

- https://leetcode-cn.com/problems/balanced-binary-tree/