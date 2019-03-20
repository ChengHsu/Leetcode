# Leetcode - Binary Search Tree

## Basic Property

1. The value in each node must be  `greater than`  (or equal to) any values stored in its left subtree.
2. The value in each node must be  `less than`  (or equal to) any values stored in its right subtree.
3. `Inorder traversal` in BST will be in `ascending order`.

## Probs Based on Basic Property

### LC#98. Validate Binary Search Tree
Given a binary tree, determine if it is a valid binary search tree (BST).    
1. The idea comes from first 2 basic properties
2. **Note**: While traversing the tree, we can not only check if `node.right.val > node.val` and`node.left.val < node.val`. We should all make sure `all the nodes in left subtree < node.val` and `all the nodes in right subtree > node.val`. So the right thing to do is to use `lower_bound` and `upper_bound`. When traversing to the left, the `upper_bound` is updated to the `root.val`. Otherwise the `lower_bound` is updated to the `root.val`.


### LC#285. Inorder Successor and Predecessor in BST

Given a binary search tree and a node ( `node p`) in it, find the in-order predecessor and successor of that node in the BST.                       	
- For successor
	- Since successor is the smallest node which is bigger than p, an intuitive idea is to consider `inorder traversal`. 
	- If p has right sub-tree, 
		- if `p.right` has left child, then successor is the left child.
		- Otherwise successor is `p.right`
	- Otherwise, successor is either `p's parent` or p is the rightmost node which has no successor.
- For predecessor
	- Since sucpredecessorcessor is the larggest node which is smaller than p, an intuitive idea is to consider `inorder traversal`.
	- If p has left sub-tree, 
		- if `p.left` has right child, then successor is the right child.
		- Otherwise successor is `p.left`
	- Otherwise, p is the leftmost node which has no predecessor.   
	  
### LC#173.  Binary Search Tree Iterator
Implement an iterator over a binary search tree (BST). Your iterator will be initialized with the root node of a BST.     
-  Use `Stack` to simulate recursion.
- We should alway maintain an `ascending order` using stack. 
- In `constructor`, we traverse  to the leftmost node and push the visited nodes to stack.
- In `next()` we pop once to get the current smallest node and find the next smallest node (its successor) for future use of `next()`. We achieve this by traversing and pushing all the left children of its right subtree into the stack. In this case, the current smallest one is always on top of the tack.


## Basic Operations in BST
### LC#700. Search in a Binary Search Tree
Assume the target node is P, 
 - if `root == null || root.val == P.val`, return `root`
 - if `root.val` < `P.val`, -> recurse to `root.right`
 - if  `root.val` < `P.val`, -> recurse to `root.right`
 
### LC#701. Insertion in a Binary Search Tree
The basic idea is to find out a proper leaf position for the target node and then insert the node as a leaf.           
Assume the target node is P,
 - if `root == null`, return `root.val`
 - if `root.val` < `P.val`, -> `root.right = insertion(root.right)`
 - if  `root.val` < `P.val`, -> `root.left = insertion(root.left)`
 
### LC#450. Deletion in a Binary Search Tree
The basic idea is to find out the node to be deleted, say node p. And then determine how to deal with its children, if it has any. Three cases to be considered:
 1. node p has no left child, return right child.
 2. node p has no right child, return left child.
 3. node p has both two children, then we should :
	 - find its successor  
	 - replace it with its successor  
	 - make sure to also delete its successor 

## LCA
Given a binary search tree (BST), find the lowest common ancestor (LCA) of two given nodes in the BST.    
Assume two given nodes are p and q. Three cases to be considered:
1. `p.val <= root.val <= q.val`, LCA is root
2. `root.val > p.val && root.val > q.val`, -> findLCA(root.left)
3. `root.val < p.val && root.val < q.val`, -> findLCA(root.right)

## Height Balanced BST
### Terminology used in trees:
-   Depth of node - the number of edges from the tree's root node to the node
-   Height of node - the number of edges on the longest path between that node and a leaf
-   Height of Tree - the height of its root node

### Property:
 - The height of a balanced BST with  `N` nodes is always  `logN`
 - The height of the two subtrees of every node never differs by more than 1.

### Popular Implementations of the Height Balanced BST
-   [Red-black tree](https://en.wikipedia.org/wiki/Red%E2%80%93black_tree)
-   [AVL tree](https://en.wikipedia.org/wiki/AVL_tre)
-   [Splay tree](https://en.wikipedia.org/wiki/Splay_tree)
-   [Treap](https://en.wikipedia.org/wiki/Treap)

### Practical Appications of the Height Balanced BST
Typically, there are two kinds of sets which are widely used:  `hash set`  and  `tree set`.

The `tree set`,  `TreeSet`  in Java or  `set`  in C++, is implemented by the height-balanced BST. Therefore, the time complexity of search, insertion and deletion are all  `O(logN)`.

The  `hash set`,  `HashSet`  in Java or  `unordered_set`  in C++, is implemented by hash, but the height-balanced BST also plays an important role in hash set. When there are too many elements with the same hash key, it will cost `O(N)`  time complexity to look up for a specific element, where  `N`  is the number of elements with the same hash key. Typically, the height-balanced BST will be used here to improve the performance from  `O(N)`  to  `O(logN)`.

The essential difference between the hash set and the tree set is that keys in the tree set are  `ordered`  


### LC#110. Balanced Binary Tree
Given a binary tree, determine if it is height-balanced.     
Compute the height of left subtree and right subtree, and then check if their difference > 1 in every subtree. Return the height of current tree: `Max(leftHeight, rightHeight) + 1`

### LC#108. Convert Sorted Array to Binary Search Tree
Given an array where elements are sorted in ascending order, convert it to a height balanced BST.    
The elements are in ascending order means they're traversed inorder-ly. Therefore, the root of each sub-BST should be in the middle. -> `Binary Search`:
```
binarySearch(nums, l, r):
	root = new TreeNode(nums[mid])
	root.left = binarySearch(nums, l, mid - 1)
	root.right = binarySearch(nums, mid + 1, r)
	return root
```

<!--stackedit_data:
eyJoaXN0b3J5IjpbLTQ2ODczMTI4MF19
-->