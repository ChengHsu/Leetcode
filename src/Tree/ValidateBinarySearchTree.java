package Tree;

/**
 * @Number: 98. Validate Binary Search Tree
 * @Descpription: Given a binary tree, determine if it is a valid binary search tree (BST).
 * BST:
 * 1.The left subtree of a node contains only nodes with keys less than the node's key.
 * 2.The right subtree of a node contains only nodes with keys greater than the node's key.
 * 3.Both the left and right subtrees must also be binary search trees.
 * @Author: Created by xucheng.
 */
public class ValidateBinarySearchTree {
    /**
     * case [10,5,15,null,null,6,20] 没过，右子树的leftmost node should large than the root
     * @param root
     * @return
     */
//    public boolean isValidBST(TreeNode root) {
//        if (root == null)
//            return true;
//        boolean isLeftBST = true;
//        boolean isRightBST = true;
//        if (root.left != null) {
//            isLeftBST = isValidBST(root.left);
//            if (root.left.val >= root.val)
//                isLeftBST = false;
//        }
//        if (root.right != null) {
//            isRightBST = isValidBST(root.right);
//            if (root.right.val <= root.val)
//                isRightBST = false;
//        }
//        if (isLeftBST && isRightBST)
//            return true;
//        return false;
//    }

    /**
     * https://leetcode.com/problems/validate-binary-search-tree/solution/
     * @param root
     * @return
     */
    public boolean isValidBST(TreeNode root) {
        if (root == null)
            return true;
        return isBSTHelper(root,null,null);
    }

    private boolean isBSTHelper(TreeNode node, Integer lowerBound, Integer upperbound) {
        if (lowerBound != null && node.val <= lowerBound)
            return false;
        if (upperbound != null && upperbound <= node.val)
            return false;
        boolean left = node.left != null? isBSTHelper(node.left,lowerBound,node.val): true;
        if (left) {
            boolean right = node.right != null? isBSTHelper(node.right,node.val,upperbound): true;
            return right;
        }
        else return false;
    }
}
