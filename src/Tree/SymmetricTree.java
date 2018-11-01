package Tree;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @Number: #101 Symmetric Tree
 * @Descpription: Given a binary tree, check whether it is a mirror of itself (ie, symmetric around its center).
 * @Author: Created by xucheng.
 */
public class SymmetricTree {
    // Iterate
//    public boolean isSymmetric(TreeNode root) {
//        Queue<TreeNode> queue = new LinkedList<>();
//        if (root == null)
//            return true;
//        queue.offer(root);
//        queue.offer(root);
//        while (!queue.isEmpty()) {
//            TreeNode leftTn = queue.poll();
//            TreeNode rightTn = queue.poll();
//            // the left and right nodes of leaves r all null
//            if (leftTn == null && rightTn == null)
//                continue;
//            if (leftTn == null || rightTn == null)
//                return false;
//            if (leftTn.val != rightTn.val)
//                return false;
//            queue.offer(leftTn.left);
//            queue.offer(rightTn.right);
//            queue.offer(leftTn.right);
//            queue.offer(rightTn.left);
//        }
//        return true;
//    }

    // Recursive
    // 1. two roots of 2 trees have the same value.
    // 2. The right subtree of each tree is a mirror reflection of the left subtree of the other tree.
    public boolean isSymmetric(TreeNode root) {
        return isMirror(root, root);
    }
    private boolean isMirror(TreeNode leftTn, TreeNode rightTn) {
        if (leftTn == null && rightTn == null)
            return true;
        if (leftTn == null || rightTn == null)
            return false;
        return leftTn.val == rightTn.val && isMirror(leftTn.left,rightTn.right) && isMirror(leftTn.right,rightTn.left);

    }

}
