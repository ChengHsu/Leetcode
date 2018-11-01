package Tree;

/**
 * @Number: #111. Minimum Depth of Binary Tree
 * @Descpription: Given a binary tree, find its minimum depth.
 * The minimum depth is the number of nodes along the shortest path from the root node down to the nearest leaf node.
 * @Author: Created by xucheng.
 */
public class MinimumDepthofBinaryTree {
    // Recursion
    int min = Integer.MAX_VALUE;
    public int minDepth(TreeNode root) {
        if (root == null)
            return 0;
        traversal(root, 0);
        return min;
    }

    private void traversal(TreeNode root, int num) {
        num += 1;
        if (root.left == null && root.right == null) {
            if (num < min)
                min = num;
            return;
        }
        if (root.left != null)
            traversal(root.left, num);
        if (root.right != null)
            traversal(root.right, num);
    }
}
