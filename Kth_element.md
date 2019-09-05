
# Leetcode - K-th Element

## K-th Largest Element in an Array

> 215. Kth Largest Element in an Array
Find the **k**th largest element in an unsorted array. Note that it is the kth largest element in the sorted order, not the kth distinct element.       

### naive solution
To sort the array, and return the element with index of (k-1). 

Complexity:
 - Time : **O(nlog(n))**
 - Space: O(1)

### Heap
To init a **min-heap** and add all elements from the array into this heap one by one while maintaing the size of this heap always <= k. The way of doing this is to pop the min element on the top every time when the new element comes in while the size already equals to k. That would results in containing k largest elements of the array in the heap. And the k-th largest element is the top element in this heap because it's the min element among k largest elements. 

Complexity:
 - Time: **O(nlog(k))**. The time of adding an element in a heap of size k is O(log(k)). And we do it n times.
 - Space: **O(k)**. To store the elements 


### Quickselect
The K-th largest element is (n - k)-th smallest element at the same time. Hence we convert the prob to : to find the (n - k)-th smallest.   Three steps to be followed:   
1. Choose a random pivot.
2. Use a `partition` algorithm to place the pivot into its right position `pos` if it's in ascending order. Move smaller elements to the left of pivot and larger or equal ones to the right.
	- Swap pivot to the end of paritition part
	-  Use two pointers to iterate every element in the partition part and compare it with pivot to overwrite the partition part. if(nms[fast] < pivot), then swap(slow, fast);
	- After iteration, swap pivot element at the end of parition part with the element that slow pointer points to.
3. Compare `pos` and (n-k) to choose the side of array to proceed recursively.  

Complexity:
 - Time : **O(n)** in average case, **O(n^2)** in worst case
 - Space: **O(1)**



## K-th Largest Element in a Stream

> 703. Kth Largest Element in a Stream
Design a class to find the  **k**th largest element in a stream. Note that it is the kth largest element in the sorted order, not the kth distinct element.                     
### Heap solution
Use a min-heap to always maintain the current K largest elements.
```
 queue.offer(val);
 if(queue.size() > k)
	 queue.poll();
```
**Comlexity**:
- Time: O(logk) for adding one element at a time into heap.
- Space: O(k)

### BST Solution
[Basic idea is to build a BST, and make use of insert and search operations ](https://leetcode.com/explore/learn/card/introduction-to-data-structure-binary-search-tree/142/conclusion/1026/)

## K-th Smallest Element in a BST
> 230. Kth Smallest Element in a BST
Given a binary search tree, write a function  `kthSmallest`  to find the  **k**th smallest element in it.       

Since is to find k-th smallest element, the intuitive idea is to use inorder traversal while maintaining a counter by adding it by 1 every time we reaches a root.
```
kthSmallest(root.left,k)
count++;
if(count == k)
  ans = root.val;
kthSmallest(root.right,k)
```
**Complexity**:
- Time : O(n)
- Space: O(1)

## Remove K-th Node From End of List
> 19. Remove Nth Node From End of List
Given a linked list, remove the _n_-th node from the end of list and return its head.  
### naive solution
To pass through the linkedlist 2 times. 
 - Get its length after 1st pass, say `len` 
 - Since the k-th node from the end is the **(len-k+1)-th** node from the beginning, we move through the pointer until it comes to the (len-k)-th node and relink its next pointer to `node.next.next`
 **Complexity:**
 - Time: O(2*len)
 - Space: O(1)

### One pass solution
Set two pointers: say `fast` and `slow`
 - Let `fast` moves forward k steps at first.
 - Let `fast` and `slow`(from dummy head) move forward at the smae time util `fast` reaches the end of list. Now `slow` is at the previous node of the node we are searching for. So relink `slow` to `slow.next.next`
 - **Why**:  Since we let `fast` moves k steps at first and then two pointers start at the same time until `fast` reaches the end(`null`). At this time `fast` walks (len + 1) steps in total, therefore `slow` walks (len-k+1) steps in total. So the node that `slow` points to should be the node we want. But the goal is to delete that node, which means we have to reach its previous node. So we let `slow` starts from `dummy`, thus we are at the position of previous node after `fast` reaches `null`.
**Complexity**:
- Time: O(len)
- Space: O(1)


## Follow Up
### K-th Smallest Number in a Sorted Matrix
#### Brute Force：
Convert the matrix into one dimenson array, sort the array and return (k - 1)-th  element
- time: O(n^2 log n^2)
#### Heap
Find min/max in a set (size > 2) => `Heap`
Push : O(log n)
Pop: O(log n)
Top: O(1)
```
 for(int i = 0; i < k - 1; i++) {
            Number min = heap.poll();
            for(int j = 0; j < 2; j++) {
                int nx = min.x + dx[j];
                int ny = min.y + dy[j];
                if(nx < matrix.length && ny < matrix[0].length && !visited[nx][ny]) {
                    visited[nx][ny] = true;
                    heap.add(new Number(nx, ny, matrix[nx][ny]));
                }
            }
        }
```

### Kth Largest in N Arrays
#### Heap
1. Sort every array => O( n log n )
2. Maintain n elements in max heap => O( log n)
3. After pop a current max element, add the next element in its array into the heap
4. Kth Largest is the k-th poped element
`Time`: O(n log n + k log n)


### Kth Smallest Sum in Two Sorted Arrays
#### Heap
We can construct a matrix consists of all the sums of any two elements from two arrays respectively:
nums1: {1, 7 , 11}
nums2: {2, 4, 6}
matrix of sums:
		 1  7  11
	2	 3  9  13
	4  5  11 15
	6  7  13 17
In this way, this problem is converted to compute the Kth Smallest number in a Sorted Matrix


### Kth Smallest Product in Two Sorted Arrays (non-negative)
We can construct a matrix consists of all the products of any two elements from two arrays respectively: 
nums1: {1, 7, 11}
nums2: {2, 4, 6}
matrix of sums:
		 1   7   11
	2	 2  14  22
	4   4  28  44
	6   6  42  66
In this way, this problem is converted to compute the Kth Smallest number in a Sorted Matrix


### K Closest Points to Origin
Priority Queue: always keep k points with k smallest distances in min heap
`time`: O(n log k)
`space`: O(k)
```
    public int[][] kClosest(int[][] points, int K) {
        int[][] res = new int[K][2];
        if(points == null || points.length == 0 || points[0] == null || points[0].length == 0 || points.length < K)
            return res;
        
        PriorityQueue<int[]> pq = new PriorityQueue<>(K, (int[] p1, int[] p2) -> {
            return getDis(p1) - getDis(p2);
        });
        
        for(int[] point: points)
            pq.offer(point);
        
        int idx = 0;
        while(K > 0) {
            res[--K] = pq.poll();
        }
        return res;
    }
    
     private int getDis(int[] p) {
        return p[0] * p[0] + p[1] * p[1];
    }
```

Quick Select: keep picking a pivot and partationing elements. Put all elements
`time`: O(n)
`space`: O(1)
```
    public int[][] kClosest(int[][] points, int K) {
        if(points == null || points.length == 0 || points[0] == null || points[0].length == 0 || points.length < K)
            return null;
        
        int l = 0;
        int r = points.length - 1;
        while(l <= r) {
            int mid = (r - l) / 2 + l;
            mid = partition(points, l, r, mid);
            if(mid == K - 1)
                break;
            else if(mid < K - 1)
                l = mid + 1;
            else
                r = mid - 1;
        }
        
        return Arrays.copyOfRange(points, 0, K);
    }
    
    private int partition(int[][]points, int l, int r, int pivotIdx) {
        int[] pivot = points[pivotIdx];
        swap(points, pivotIdx, r);
        int pivotDis = getDis(pivot);
        int idx = l;
        for(int i = l; i < r; i++) {
            if(getDis(points[i]) < pivotDis) {
                swap(points, idx, i);
                idx++;
            }
        }
        // put pivot at its right position
        swap(points, idx, r);
        return idx;
    }

     private int getDis(int[] p) {
        return p[0] * p[0] + p[1] * p[1];
    }
    
    private void swap(int[][] points, int a, int b) {
        int[] tmp = points[a];
        points[a] = points[b];
        points[b] = tmp;
    }
```






 
<!--stackedit_data:
eyJoaXN0b3J5IjpbLTgwNzU0Mzk0NywtMzAzOTk1OTNdfQ==
-->