## Topological Sort:
对于一个Directed Acyclic Graph(DAG) G 进行拓扑排序，
是将G中所有顶点排成一个线性序列，使得G中任意一对顶点u和
v,若边(u,v)属于E(G),则u在线性序列中出现在v之前。

即若存在一条有向边从u到v，则在排序后的顺序里u在v的前面。
并且每个点在这个拓扑序里只能出现一次。考虑为什么必须是有向无环图，
首先无向显然是不行的，而如果存在环，则会存在冲突的前后关系。

一个DAG可以有一个或多个拓扑排序序列，顺序取决于求解过程。

### 求解方法：
#### 寻找in-degree=0的点 O(n+e)
    1).遍历: O(e)
        i.有向图将每个点的in-degree存入InDegree Array
        ii.构造Adjancency List(Map) - key:u val:List<Integer> v
    2).从InDegree Array中找出所有入度为0的点，构成初始队列。- O(n)
    3).通过队首出列,调整与出列的点相连的其他点的in-degree(减1),并检查这些点的in-degree是否为0，若是则加入队列
    4).重复3)至队列为空,若此时从队列出列的所有点数目为G中所有点的数目,则不存在环，出列顺序是排序顺序 -O(n+e)


Note: 如果最后输出的拓扑序的顶点数小于总顶点数，则表明存在有向环；反之，则是DAG;
      只要任意时刻出现队列中元素个数大于1的情况，就有多个拓扑序。
      如果任意时刻队列中元素的个数始终为1，则有唯一的拓扑序。
      
#### DFS
在dfs的时候，对于一个点v，它指向许多别的点，在这些点visited之后，
从v点开始backtrack，将v加入一个数组，backtrack到u，再把u加入数组。
最后将数组逆序。