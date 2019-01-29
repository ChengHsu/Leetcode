package Tree;

/**
 * @Number: #235. Lowest Common Ancestor Search Tree
 * @Descpription: Given a binary search tree (BST), find the lowest common ancestor (LCA) of two given nodes in the BST.
 * The lowest common ancestor is defined between two nodes p and q as the lowest node in T that has both p and q as descendants (where we allow a node to be a descendant of itself)
 * @Author: Created by xucheng.
 */
public class LowestCommonAncestorOfABinarySearchTree {
    /**
     * Property of BST: left.val < parent.val < right.val
     * Traverse from top to bottom
     * Find a root n such that p.val<n.val<q.val
     * If current root.val > both, then go to its left subtree
     * If current root.val < both, then go to its right subtree
     * Else return current root
     * @param root
     * @param p
     * @param q
     * @return
     */
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        //Edge
        if (root == null || p == null || q == null)
            return null;
        return LCA(root, p, q);
    }

    private TreeNode LCA(TreeNode root, TreeNode p, TreeNode q) {

        if (root == null)
            return null;
        if (root.val > p.val && root.val > q.val)
            return LCA(root.left, p, q);
        if (root.val < p.val && root.val < q.val)
            return LCA(root.right, p, q);
        return root;
    }
}
