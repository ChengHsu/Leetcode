package Tree;

/**
 * @Number: 230. Kth Smallest Element in a BST
 * @Descpription: Given a binary search tree, write a function kthSmallest to find the kth smallest element in it.
 * @Author: Created by xucheng.
 */
public class KthSmallestElementInABST {
    int count = 0;
    int result = Integer.MIN_VALUE;
    /**
     * inorder traversal : ascending order
     * 1. find the leftmost node which is the smallest node
     * 2. starts from the leftmost node, maintain a count which increases by 1 every it meets a node
     * 3. return the val of current node when count == k
     * @param root
     * @param k
     * @return
     */
    public int kthSmallest(TreeNode root, int k) {
        if(root == null) return 0;
        kthSmallest(root.left, k);
        count++;
        if(count == k) result = root.val;
        kthSmallest(root.right, k);
        return result;
    }
}
