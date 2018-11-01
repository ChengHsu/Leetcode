package Tree;

/**
 * @Number: #404 Sum of Left Leaves
 * @Descpription: Find the sum of all left leaves in a given binary tree.
 * @Author: Created by xucheng.
 */
public class SumOfLeftLeaves {
    public int sumOfLeftLeaves(TreeNode root) {
        return findLeftLeaves(root,false);
    }

    private int findLeftLeaves(TreeNode root, boolean isLeft) {
        if (root == null) return 0;
        return (isLeft && root.left == null && root.right == null ? root.val : 0) + findLeftLeaves(root.left,true) + findLeftLeaves(root.right,false);
    }
}
