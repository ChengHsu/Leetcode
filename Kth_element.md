
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
 
<!--stackedit_data:
eyJoaXN0b3J5IjpbLTMwMzk5NTkzXX0=
-->