package Tree;

/**
 * @Number: #112. Path Sum
 * #437. Path Sum III
 * @Descpription: #112: Given a binary tree and a sum, determine if the tree has a root-to-leaf path such that adding up all
 * the values along the path equals the given sum.
 * #437: You are given a binary tree in which each node contains an integer value.
 * Find the number of paths that sum to a given value.
 * The path does not need to start or end at the root or a leaf, but it must go downwards
 * @Author: Created by xucheng.
 */
public class PathSum {
    // #112. Path Sum
    public boolean hasPathSum(TreeNode root, int sum) {
        if (root == null)
            return false;
        // initial total should be the value of root
        return preorder(root, sum, root.val, false);
    }

    private boolean preorder(TreeNode root, int target, int total, boolean isFind) {
        if (total == target && root.left == null && root.right == null) {
            isFind = true;
            return isFind;
        }
        if (root.left != null) {
            isFind = preorder(root.left, target, total + root.left.val, isFind);
        }
        if (root.right != null) {
            isFind = preorder(root.right, target, total + root.right.val, isFind);
        }
        return isFind;
    }

    // #437. Path Sum III
    // Double recursion
    // ?????
    public int pathSum(TreeNode root, int sum) {
        if (root == null)
            return 0;
        dfs(root, sum);
        return dfs(root, sum) + pathSum(root.left, sum) + pathSum(root.right, sum);
    }

    private int dfs(TreeNode root, int sum) {
        int count = 0;
        if (root == null)
            return 0;
        if (root.val == sum)
            count += 1;
        count += dfs(root.left, sum - root.val);
        count += dfs(root.right, sum - root.val);
        return count;
    }
}
