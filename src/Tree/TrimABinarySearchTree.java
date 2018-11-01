package Tree;

/**
 * @Number: #669 Trim a binary search tree
 * @Descpription: Given a binary search tree and the lowest and highest boundaries as L and R,
 * trim the tree so that all its elements lies in [L, R] (R >= L).
 * You might need to change the root of the tree, so the result should return the new root of the trimmed binary search tree.
 * @Author: Created by xucheng.
 */
public class TrimABinarySearchTree {
    /**
     * Good
     * idea: property of BST: left.val <= root.val < right.val
     * Case 1: L <= root.val <= R.
     * Root remains unchanged.
     * root.left = trim(root.left);
     * root.right = trim(root.right);
     * Case 2: root.val < L
     * Root and its left subtree both r discarded.
     * root = trim(root.right);
     * Case 3: root.val > R
     * Root and its right subtree both r discarded.
     * root = trim(root.left);
     */
    public TreeNode trimBST(TreeNode root, int L, int R) {
        if (root == null)
            return null;
        //Case 2
        if (root.val < L)
            return trimBST(root.right,L,R);
        //case 3
        if (root.val > R)
            return trimBST(root.left,L,R);
        //case 1
        root.left = trimBST(root.left,L,R);
        root.right = trimBST(root.right,L,R);
        return root;
    }
}
