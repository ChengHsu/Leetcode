package Tree;

/**
 * @Number: #99. Recover Binary Search Tree
 * @Descpription: Two elements of a binary search tree (BST) are swapped by mistake.
 * @Author: Created by xucheng.
 */
public class RecoverBinarySearchTree {
    TreeNode firstEle = null;
    TreeNode secondEle = null;
    TreeNode prevEle = null;

    /**
     * Inorder traversal: 找pre element > current element
     * https://leetcode.com/problems/recover-binary-search-tree/discuss/32535/No-Fancy-Algorithm-just-Simple-and-Powerful-In-Order-Traversal
     * @param root
     */
    public void recoverTree(TreeNode root) {
        if (root == null)
            return;
        inorder(root);
        int tmp = firstEle.val;
        firstEle.val = secondEle.val;
        secondEle.val = tmp;
    }

    private void inorder(TreeNode root) {
        if (root == null)
            return;
        inorder(root.left);
        if (prevEle != null && prevEle.val > root.val) {
            if (firstEle == null)
                firstEle = prevEle;
            secondEle = root;
        }
        prevEle = root;
        inorder(root.right);
    }
}
