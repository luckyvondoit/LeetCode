## 图（Graph）

![image-20211130105130524](images/image-20211130105130524.png)

### 有向图（Directed Graph）

![image-20211130105226212](images/image-20211130105226212.png)

#### 出度、入度

![image-20211130105338770](images/image-20211130105338770.png)

### 无向图（Undirected Graph）

![image-20211130105423103](images/image-20211130105423103.png)

### 混合图（Mixed Graph）

![image-20211130105446456](images/image-20211130105446456.png)

### 简单图、多重图

![image-20211130105514016](images/image-20211130105514016.png)

### 无向完全图（Undirected Complete Graph）

![image-20211130110014992](images/image-20211130110014992.png)

### 有向完全图（Directed Complete Graph）

![image-20211130110037962](images/image-20211130110037962.png)

### 有权图（Weighted Graph）

![image-20211130110109379](images/image-20211130110109379.png)

### 连通图（Connected Graph）

![image-20211130110139789](images/image-20211130110139789.png)

### 连通分量（Connected Component）

![image-20211130110210827](images/image-20211130110210827.png)

### 强连通图（Strongly Connected Graph）

![image-20211130110236869](images/image-20211130110236869.png)

### 强连通分量（Strongly Connected Component）

![image-20211130110336873](images/image-20211130110336873.png)

## 图的实现方案

![image-20211130110423255](images/image-20211130110423255.png)

### 邻接矩阵（Adjacency Matrix）

![image-20211130110454561](images/image-20211130110454561.png)

#### 有权图

![image-20211130110528470](images/image-20211130110528470.png)

### 邻接表（Adjacency List）

![image-20211130110554509](images/image-20211130110554509.png)

#### 有权图

![image-20211130110625167](images/image-20211130110625167.png)

### 图的基础接口

![image-20211130110705022](images/image-20211130110705022.png)

### 顶点的定义

![image-20211130110744150](images/image-20211130110744150.png)

### 边的定义

![image-20211130110851006](images/image-20211130110851006.png)

### 遍历

![image-20211130110917991](images/image-20211130110917991.png)

#### 广度优先搜索（Breadth First Search）

![image-20211130110950697](images/image-20211130110950697.png)

![image-20211130111041683](images/image-20211130111041683.png)

##### 思路

![image-20211130111142259](images/image-20211130111142259.png)

##### 实现

![image-20211130111208062](images/image-20211130111208062.png)

#### 深度优先搜索（Depth First Search）

![image-20211130111242241](images/image-20211130111242241.png)

![image-20211130111303661](images/image-20211130111303661.png)

##### 递归实现

![image-20211130111339932](images/image-20211130111339932.png)

##### 非递归思路

![image-20211130111519749](images/image-20211130111519749.png)

![image-20211130111539792](images/image-20211130111539792.png)

### AOV网（Activity On Vertex Network）

![image-20211130111626007](images/image-20211130111626007.png)

#### 拓扑排序（Topological Sort）

![image-20211130111708748](images/image-20211130111708748.png)

##### 思路

![image-20211130111750416](images/image-20211130111750416.png)

##### 实现

![image-20211130111834232](images/image-20211130111834232.png)

## 生成树（Spanning Tree）

![image-20211130112137599](images/image-20211130112137599.png)

### 最小生成树（Minimum Spanning Tree）

![image-20211130112237703](images/image-20211130112237703.png)

![image-20211130112311415](images/image-20211130112311415.png)

#### Prim算法

##### 切分定理

![image-20211130112411456](images/image-20211130112411456.png)

##### 执行过程

![image-20211130112434504](images/image-20211130112434504.png)

![image-20211130112456658](images/image-20211130112456658.png)

![image-20211130112518993](images/image-20211130112518993.png)

##### 实现

![image-20211130112546099](images/image-20211130112546099.png)

#### Kruskal算法

##### 执行过程

![image-20211130112817637](images/image-20211130112817637.png)

![image-20211130112952811](images/image-20211130112952811.png)

![image-20211130113025222](images/image-20211130113025222.png)

##### 实现

![image-20211130113051142](images/image-20211130113051142.png)

## 最短路径（Shortest Path）

![image-20211130113127946](images/image-20211130113127946.png)

### 无权图

![image-20211130113228881](images/image-20211130113228881.png)

### 负权边

![image-20211130113306935](images/image-20211130113306935.png)

### 负权环

![image-20211130113333656](images/image-20211130113333656.png)

### 最短路径

![image-20211130113427289](images/image-20211130113427289.png)

#### Dijkstra

![image-20211130113502293](images/image-20211130113502293.png)

##### 等价思考

![image-20211130113633592](images/image-20211130113633592.png)

##### 执行过程

![image-20211130113940668](images/image-20211130113940668.png)

![image-20211130114107808](images/image-20211130114107808.png)

![image-20211130115125817](images/image-20211130115125817.png)

#### Bellman-Ford

##### 思路

![image-20211130115342497](images/image-20211130115342497.png)

![image-20211130115447346](images/image-20211130115447346.png)

##### 实例

![image-20211130115602373](images/image-20211130115602373.png)

![image-20211130115907192](images/image-20211130115907192.png)

![image-20211130115928828](images/image-20211130115928828.png)

#### Floyd

![image-20211130120509506](images/image-20211130120509506.png)