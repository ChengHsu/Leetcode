package Tree;

/**
 * @Number: #108. Convert Sorted Array to binary search tree
 * @Descpription: Given an array where elements are sorted in ascending order, convert it to a height balanced BST.
 * For this problem, a height-balanced binary tree is defined as a binary tree in which the depth of the two subtrees
 * of every node never differ by more than 1.
 * @Author: Created by xucheng.
 */
public class ConvertSortedArrayToBinarySearchTree {
    // given array is in preorder sequence, use binary search
    public TreeNode sortedArrayToBST(int[] nums) {
        if (nums.length == 0)
            return null;
        return binarySearch(nums, 0, nums.length - 1);
    }

    private TreeNode binarySearch(int[] nums, int l, int r) {
        if (l > r)
            return null;
        int mid = (l + r) / 2;
        TreeNode root = new TreeNode(nums[mid]);
        root.left = binarySearch(nums, l, mid - 1);
        root.right = binarySearch(nums, mid + 1, r);
        return root;
    }
}
