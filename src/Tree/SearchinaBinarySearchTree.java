package Tree;

/**
 * @Number: #700 Search in a Binary Search Tree
 * @Descpription: Given the root node of a binary search tree (BST) and a value.
 * You need to find the node in the BST that the node's value equals the given value.
 * Return the subtree rooted with that node. If such node doesn't exist, you should return NULL.
 * @Author: Created by xucheng.
 */
public class SearchinaBinarySearchTree {
    public TreeNode searchBST(TreeNode root, int val) {
        if (root == null)
            return null;
        if (root.val == val)
            return root;
        TreeNode res = null;
        if (root.val > val)
           res = searchBST(root.left,val);
        if (root.val < val)
            res = searchBST(root.right,val);
        return res;
    }
}
