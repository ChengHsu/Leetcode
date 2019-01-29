package Tree;

/**
 * @Number: 236. Lowest Common Ancestor of a Binary Tree
 * @Descpription: Given a binary tree, find the lowest common ancestor (LCA) of two given nodes in the tree.
 * @Author: Created by xucheng.
 */
public class LowestCommonAncestorOfABinaryTree {
    private TreeNode ans = null;

    /**
     * https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-tree/solution/
     * Postorder
     * @param root
     * @param p
     * @param q
     * @return
     */
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        recurseTree(root, p, q);
        return ans;
    }

    private boolean recurseTree(TreeNode root, TreeNode p, TreeNode q) {
//        Edge case
        if (root == null)
            return false;
//        Left Recursion. If left recursion returns true, set left = 1 else 0
        int left = recurseTree(root.left, p, q) ? 1 : 0;
//        Right Recursion
        int right = recurseTree(root.right, p, q) ? 1 : 0;
//        If the current node is one of p or q
        int mid = (root == p || root == q) ? 1 : 0;
//        If any two of the flags left, right or mid become True
        if (left + right + mid >= 2) ans = root;
//         Return true if any one of the three bool values is True.
        return (left + right + mid > 0);
    }
}
